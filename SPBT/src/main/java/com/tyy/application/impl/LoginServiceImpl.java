package com.tyy.application.impl;

import com.tyy.adapter.dep.entity.User;
import com.tyy.adapter.dep.mapper.UserRepository;
import com.tyy.adapter.in.view.LoginBody;
import com.tyy.adapter.in.view.RegisterBody;
import com.tyy.application.LoginService;
import com.tyy.application.TokenService;
import com.tyy.domain.AuthorizedUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
@Slf4j
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    UserDetailServiceImpl userDetailService;
    PasswordEncoder passwordEncoder;
    TokenService tokenService;
    UserRepository userRepository;

    @Override
    public AuthorizedUser login(LoginBody loginBody) {
        AuthorizedUser authorizedUser = userDetailService.loadUserByUsername(loginBody.getUsername());
        if (null != authorizedUser) {
            if (passwordEncoder.matches(loginBody.getPassword(), authorizedUser.getPassword())) {
                String token = tokenService.GenerateToken(authorizedUser);
                authorizedUser.setToken(token);
                return authorizedUser;
            }
            log.error("密码不正确");
        }
        return null;

    }

    @Override
    public boolean register(RegisterBody registerBody) {
        User exit = userRepository.LoadUserByUserName(registerBody.getUsername());
        if (exit == null && registerBody.getPassword().equals(registerBody.getConfirmedPassword())) {
            exit = new User(registerBody.getUsername(), registerBody.getPassword(), true);
            userRepository.save(exit);
            return true;
        }
        return false;

    }

    public boolean validate(Object o) {
        Class clazz = null;
        try {
            clazz = Class.forName(o.getClass().getName());
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if (field.get(o) == null) {
                    return false;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return true;
    }


}
