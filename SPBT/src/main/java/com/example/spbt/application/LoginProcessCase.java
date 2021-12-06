package com.example.spbt.application;

import com.example.spbt.adapter.entity.LoginBody;
import com.example.spbt.domain.AuthorizedUser;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface LoginProcessCase {

    public AuthorizedUser login(LoginBody loginBody);

}
