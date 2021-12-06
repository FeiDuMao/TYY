package com.example.spbt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class User {

    String id;
    String username;
    String password;
    boolean enabled;
    LocalDateTime lastLoginTime;


}
