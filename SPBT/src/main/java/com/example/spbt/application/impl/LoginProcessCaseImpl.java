package com.example.spbt.application.impl;

import com.example.spbt.adapter.entity.LoginBody;
import com.example.spbt.application.LoginProcessCase;
import com.example.spbt.application.TokenService;
import com.example.spbt.application.exceptioin.IncorrectPasswordException;
import com.example.spbt.domain.AuthorizedUser;
import com.example.spbt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginProcessCaseImpl implements LoginProcessCase {




    @Autowired
    UserDetailServiceImpl userDetailService;

    @Autowired
    TokenService tokenService;

    PasswordEncoder passwordEncoder;

    @Override
    public AuthorizedUser login(LoginBody loginBody) {
        AuthorizedUser authorizedUser = userDetailService.loadUserByUsername(loginBody.getUsername());

        if (null==authorizedUser||passwordEncoder.matches(loginBody.getPassword(), authorizedUser.getPassword())){
            throw new IncorrectPasswordException();
        }

        String token = tokenService.GenerateToken(authorizedUser);

        authorizedUser.setPassword(null);
        authorizedUser.setToken(token);

        return authorizedUser;
    }
}
