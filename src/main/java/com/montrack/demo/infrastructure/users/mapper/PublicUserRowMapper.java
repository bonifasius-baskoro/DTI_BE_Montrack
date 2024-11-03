package com.montrack.demo.infrastructure.users.mapper;

import com.montrack.demo.entity.Users;
import com.montrack.demo.infrastructure.users.dto.GetAllUserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class PublicUserRowMapper implements RowMapper<GetAllUserDto> {
    @Override
    public GetAllUserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        GetAllUserDto user = new GetAllUserDto();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));

        return user;


    }
}
