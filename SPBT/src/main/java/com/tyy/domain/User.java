package com.tyy.domain;

import lombok.Data;

@Data
public class User {
    String username;
    String password;
    boolean enabled;
}
