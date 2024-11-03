package com.montrack.demo.usecase.user.impl;

import com.montrack.demo.entity.Users;
import com.montrack.demo.infrastructure.users.dto.CreateUserRequestDTO;
import com.montrack.demo.infrastructure.users.gateway.UsersDatabaseGateway;
import com.montrack.demo.usecase.user.CreateUserUsecase;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUsecaseImpl implements CreateUserUsecase {
    private final UsersDatabaseGateway usersDatabaseGateway;

    public CreateUserUsecaseImpl(UsersDatabaseGateway usersDatabaseGateway) {
        this.usersDatabaseGateway=usersDatabaseGateway;
    }

    @Override
    public Users createUser(CreateUserRequestDTO req){
        System.out.println(req.getEmail());
        return usersDatabaseGateway.save(req.toEntity());
    }
}
