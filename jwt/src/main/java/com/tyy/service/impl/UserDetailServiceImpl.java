package com.tyy.service.impl;

import com.tyy.entity.LoginUser;
import com.tyy.entity.Student;
import com.tyy.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        System.out.println("执行了自定义loadUserByUsername");


        Student student=studentService.findByUsername(s);

        if (student==null){
            throw  new UsernameNotFoundException("user not find");
        }
        String password = passwordEncoder.encode(student.getPassword());


        student.setPassword(password);

        return new LoginUser(student);

//        return new LoginUser(student.getUsername(),password,
//                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
