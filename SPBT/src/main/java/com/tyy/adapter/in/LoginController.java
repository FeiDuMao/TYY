package com.tyy.adapter.in;


import com.tyy.adapter.entity.LoginBody;
import com.tyy.application.LoginService;
import com.tyy.application.entity.AuthorizedUser;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public AuthorizedUser login(@RequestBody LoginBody loginBody){
        AuthorizedUser authorizedUser = loginService.login(loginBody);
        return authorizedUser;
    }




}
