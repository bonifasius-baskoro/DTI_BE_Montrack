package com.montrack.demo.infrastructure.users.controller;

import com.montrack.demo.common.response.ApiResponse;
import com.montrack.demo.infrastructure.users.dto.CreateUserRequestDTO;
import com.montrack.demo.usecase.user.CreateUserUsecase;
import com.montrack.demo.usecase.user.GetUsersUsecase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserPublicController {
    private final CreateUserUsecase createUserUsecase;
    private final GetUsersUsecase getUsersUsecase;

    public UserPublicController(CreateUserUsecase createUserUsecase, GetUsersUsecase getUsersUsecase) {
        this.createUserUsecase = createUserUsecase;
        this.getUsersUsecase = getUsersUsecase;
    }

    @GetMapping
    public ResponseEntity<?> getUsers(){
        return ApiResponse.successfulResponse("Get Users Data Success", getUsersUsecase.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable final Integer id){
        return ApiResponse.successfulResponse("Get user success", getUsersUsecase.findUserById(id));
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequestDTO req){
        System.out.println("this is "+ req.getEmail());
        return ApiResponse.successfulResponse("Create New User Success",createUserUsecase.createUser(req));
    }

}
