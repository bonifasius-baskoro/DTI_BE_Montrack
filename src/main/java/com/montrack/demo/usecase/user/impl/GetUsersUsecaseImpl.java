package com.montrack.demo.usecase.user.impl;

import com.montrack.demo.infrastructure.users.dto.GetAllUserDto;
import com.montrack.demo.infrastructure.users.gateway.PublicUsersDatabaseGateway;
import com.montrack.demo.usecase.user.GetUsersUsecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersUsecaseImpl implements GetUsersUsecase {
    private final PublicUsersDatabaseGateway publicUsersDatabaseGateway;

    public GetUsersUsecaseImpl(PublicUsersDatabaseGateway publicUsersDatabaseGateway) {
        this.publicUsersDatabaseGateway = publicUsersDatabaseGateway;
    }

    @Override
    public List<GetAllUserDto> getAllUsers(){
        return publicUsersDatabaseGateway.findAll();
    }


    @Override
    public GetAllUserDto findUserById(Integer id){
        return publicUsersDatabaseGateway.findById(id);
    }

}
