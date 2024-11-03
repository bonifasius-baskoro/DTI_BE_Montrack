package com.montrack.demo.infrastructure.users.repository;

import com.montrack.demo.infrastructure.users.dto.GetAllUserDto;

import com.montrack.demo.repository.PublicRepository;

public interface PublicUsersRepository extends PublicRepository<GetAllUserDto, Integer> {

}
