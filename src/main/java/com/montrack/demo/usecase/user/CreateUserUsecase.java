package com.montrack.demo.usecase.user;

import com.montrack.demo.entity.Users;
import com.montrack.demo.infrastructure.users.dto.CreateUserRequestDTO;

public interface CreateUserUsecase {
    Users createUser(CreateUserRequestDTO req);
}
