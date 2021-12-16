package com.tyy.auth.adapter.in;

import com.tyy.auth.adapter.in.view.LoginBody;
import com.tyy.auth.domain.AuthorizedUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("/test")
    public AuthorizedUser test(@RequestBody LoginBody loginBody){

        return new AuthorizedUser("tyy","123");
    }
}
