package com.montrack.demo.infrastructure.users.gateway;

import com.montrack.demo.entity.Users;
import com.montrack.demo.infrastructure.users.dto.GetAllUserDto;
import com.montrack.demo.infrastructure.users.mapper.PublicUserRowMapper;
import com.montrack.demo.infrastructure.users.mapper.UserRowMapper;
import com.montrack.demo.infrastructure.users.repository.UsersRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class UsersDatabaseGateway implements UsersRepository {
    private final JdbcTemplate jdbcTemplate;

    public UsersDatabaseGateway(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public Users save (Users entity){
        String sql = "INSERT INTO montrack_be.users (password,name,email,pin,created_at,updated_at) VALUES (?,?,?,?,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP) RETURNING id";
        int insertedUserID = jdbcTemplate.queryForObject(sql, Integer.class,
                entity.getPassword(),
                entity.getName(),
                entity.getEmail(),
                entity.getPin());

        entity.setUserId(insertedUserID);
        return entity;
    }

}
