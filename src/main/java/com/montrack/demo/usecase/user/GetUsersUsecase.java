package com.montrack.demo.usecase.user;

import com.montrack.demo.infrastructure.users.dto.GetAllUserDto;

import java.util.List;

public interface GetUsersUsecase {
    List<GetAllUserDto> getAllUsers();
    GetAllUserDto findUserById(Integer Id);

}
