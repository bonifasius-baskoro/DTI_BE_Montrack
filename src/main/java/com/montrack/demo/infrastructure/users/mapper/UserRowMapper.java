package com.montrack.demo.infrastructure.users.mapper;

import com.montrack.demo.entity.Users;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class UserRowMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users user = new Users();
        user.setUserId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        Timestamp createTimestamp = rs.getTimestamp("created_at");
        Timestamp updatedTimestamp = rs.getTimestamp("updated_at");
        Timestamp deletedTimestamp = rs.getTimestamp("deleted_at");
        dateAssigned(user, createTimestamp,"createdAt");
        dateAssigned(user, deletedTimestamp,"deletedAt");
        dateAssigned(user, updatedTimestamp,"updatedAt");
        return user;


    }

    private void dateAssigned (Users user ,Timestamp timestamp, String propertyName) {

        try {

            String setterMethodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);

            ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(
                    timestamp.toInstant(),
                    ZoneId.systemDefault()
            );

            Method setter = Users.class.getDeclaredMethod(setterMethodName, ZonedDateTime.class);

            setter.invoke(user, zonedDateTime);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Error assigning date to property: " + propertyName + e);

        }
    }
}
