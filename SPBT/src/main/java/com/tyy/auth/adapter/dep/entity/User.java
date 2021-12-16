package com.tyy.auth.adapter.dep.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    String username;
    String password;
    boolean enabled;
}
