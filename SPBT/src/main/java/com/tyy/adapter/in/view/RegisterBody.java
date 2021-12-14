package com.tyy.adapter.in.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegisterBody{
    String username;
    String password;
    String confirmedPassword;
}
