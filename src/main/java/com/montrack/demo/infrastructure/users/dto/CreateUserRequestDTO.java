package com.montrack.demo.infrastructure.users.dto;


import com.montrack.demo.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestDTO {
    private String email;
    private String password;
    private int pin;
    private String name;

    public Users toEntity(){
        Users user= new Users();
        user.setEmail(email);
        user.setPassword(password);
        user.setPin(pin);
        user.setName(name);
        return user;
    }

}
