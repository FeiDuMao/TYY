package com.tyy.auth.adapter.in.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginBody {
    String uuid;
    String captcha;
    String username;
    String password;
}
