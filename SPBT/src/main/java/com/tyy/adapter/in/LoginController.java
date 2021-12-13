package com.tyy.adapter.in;


import com.tyy.adapter.in.view.LoginBody;
import com.tyy.adapter.in.view.RegisterBody;
import com.tyy.adapter.in.view.RespBody;
import com.tyy.application.LoginService;
import com.tyy.application.impl.CaptchaService;
import com.tyy.domain.AuthorizedUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    CaptchaService captchaService;


    @PostMapping("/login")
    public RespBody login(@RequestBody LoginBody loginBody,HttpServletRequest request){
        if (!loginService.validate(loginBody)){
            return RespBody.ERROR(null,"登录参数错误");
        }
        if (!captchaService.validateCaptcha(request,loginBody)){
            return RespBody.ERROR(null,"验证码不正确");
        }
        AuthorizedUser authorizedUser = loginService.login(loginBody);
        if (authorizedUser==null){
            return RespBody.ERROR(null,"用户名或密码错误");
        }
        return RespBody.OK(authorizedUser,"登录成功");
    }

    @RequestMapping("/register")
    public RespBody register(@RequestBody RegisterBody registerBody) throws ClassNotFoundException {
        if (loginService.validate(registerBody)){
            return RespBody.ERROR(null,"登录参数错误");
        }
        if (loginService.register(registerBody)){
            return RespBody.OK(null,"注册成功");
        }else {
            return RespBody.ERROR(null,"该用户名已存在");
        }

    }

    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {

        captchaService.sendCaptcha(request,response);

    }
    @RequestMapping("/validateCaptcha")
    public boolean validate(HttpServletRequest request,@RequestBody LoginBody loginBody){
        return captchaService.validateCaptcha(request,loginBody);
    }

    private boolean validateLoginBody(LoginBody loginBody){
        return true;
    }


    @Test
    public void test(){

    }


}
