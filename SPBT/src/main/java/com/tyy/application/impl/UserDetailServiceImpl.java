package com.tyy.application.impl;

import com.tyy.adapter.dep.entity.User;
import com.tyy.adapter.dep.mapper.UserRepository;
import com.tyy.domain.AuthorizedUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    UserRepository repository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public AuthorizedUser loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.LoadUserByUserName(username);
        if (null!=user){
            String password = passwordEncoder.encode(user.getPassword());
            user.setPassword(password);
            return new AuthorizedUser(user);
        }
        log.error("用户: "+username+" 不存在");
        return null;
    }
}
