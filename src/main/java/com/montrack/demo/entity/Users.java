package com.montrack.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;


//    id SERIAL PRIMARY KEY,
//    password VARCHAR(255),
//    name VARCHAR(100),
//    email VARCHAR(150),
//    pin INTEGER,
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    deleted_at TIMESTAMP

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    private int userId;
    private String password;
    private String name;
    private String email;
    private int pin;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime deletedAt;

}
