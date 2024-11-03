package com.montrack.demo.infrastructure.users.repository;

import com.montrack.demo.entity.Users;
import com.montrack.demo.infrastructure.users.dto.GetAllUserDto;
import com.montrack.demo.repository.GenericRepository;

public interface UsersRepository extends GenericRepository<Users, Long> {

}

