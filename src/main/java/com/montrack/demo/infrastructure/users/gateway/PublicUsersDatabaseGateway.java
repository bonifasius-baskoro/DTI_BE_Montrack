package com.montrack.demo.infrastructure.users.gateway;

import com.montrack.demo.infrastructure.users.dto.GetAllUserDto;
import com.montrack.demo.infrastructure.users.mapper.PublicUserRowMapper;
import com.montrack.demo.infrastructure.users.repository.PublicUsersRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class PublicUsersDatabaseGateway implements PublicUsersRepository {
    private final JdbcTemplate jdbcTemplate;

    public PublicUsersDatabaseGateway(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<GetAllUserDto> findAll() {
        String sql = "select id, name, email from montrack_be.users";
        return jdbcTemplate.query(sql, new PublicUserRowMapper());
    }

    @Override
    public GetAllUserDto findById (Integer id){
        String sql = "select id, name, email from montrack_be.users where id = ?";
        return jdbcTemplate.queryForObject(sql, new PublicUserRowMapper(), id);

    }



}
