package com.montrack.demo.infrastructure.users.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUserDto {
    private int id;
    private String name;
    private String email;


}
