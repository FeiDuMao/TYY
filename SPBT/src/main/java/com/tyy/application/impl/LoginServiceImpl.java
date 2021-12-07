package com.tyy.application.impl;

import com.tyy.adapter.entity.LoginBody;
import com.tyy.application.LoginService;
import com.tyy.application.TokenService;
import com.tyy.application.entity.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    UserDetailServiceImpl userDetailService;
    PasswordEncoder passwordEncoder;
    TokenService tokenService;

    @Autowired
    public LoginServiceImpl(UserDetailServiceImpl userDetailService, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userDetailService = userDetailService;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @Override
    public AuthorizedUser login(LoginBody loginBody) {
        AuthorizedUser authorizedUser = userDetailService.loadUserByUsername(loginBody.getUsername());
        if (null!=authorizedUser&&passwordEncoder.matches(loginBody.getPassword(), authorizedUser.getPassword())){
            String token = tokenService.GenerateToken(authorizedUser);
            authorizedUser.setToken(token);
        }

        return authorizedUser;
    }


}
