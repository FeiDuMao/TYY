package com.example.spbt.adapter.in;

import com.example.spbt.adapter.entity.LoginBody;
import com.example.spbt.application.LoginProcessCase;
import com.example.spbt.domain.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class loginController {

    @Autowired
    LoginProcessCase loginProcessCase;

    @RequestMapping("/login")
    public ResponseEntity login(@RequestBody LoginBody loginBody, HttpServletRequest req){

        if (validateLoginBody(loginBody)){
            AuthorizedUser authorizedUser= loginProcessCase.login(loginBody);

            return ResponseEntity.ok(authorizedUser);
        }

        return null;
    }

    @RequestMapping("/register")
    public ResponseEntity register(LoginBody loginUserTerms) {
        System.out.println(loginUserTerms);
        return ResponseEntity.ok(loginUserTerms);
    }

    private boolean validateLoginBody(LoginBody loginBody){
        if (StringUtils.isEmpty(loginBody.getUsername())){
            throw new IllegalArgumentException("username is empty!");
        }else if (StringUtils.isEmpty(loginBody.getPassword())){
            throw new IllegalArgumentException("password is empty!");
        }
        return true;
    }



}
