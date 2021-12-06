package com.example.spbt.application.impl;

import com.example.spbt.domain.AuthorizedUser;
import com.example.spbt.domain.User;
import com.example.spbt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthorizedUser loadUserByUsername(String s) throws UsernameNotFoundException {

//        User user = userMapper.loadUserByUsername(s);
//        if (null==user){
//            throw new UsernameNotFoundException("user does not exits");
//        }

        User user=new User("1","tyy","123",true, LocalDateTime.now());

        String password=passwordEncoder.encode(user.getPassword());

        user.setPassword(password);

        return new AuthorizedUser(user);
    }
}
