package com.tyy.controller;


import com.tyy.entity.LoginBody;
import com.tyy.entity.LoginUser;
import com.tyy.entity.RespBean;
import com.tyy.entity.Student;
import com.tyy.service.IStudentService;
import com.tyy.util.RedisUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Api(value = "loginController")
@RestController
public class LoginController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping ("/login")
    public RespBean login(@RequestBody LoginBody loginBody, HttpServletRequest request){
         return studentService.login(loginBody, request);
    }


    @GetMapping("/UserInfo")
    public RespBean getAdminInfo(Principal principal){
        if (principal==null){
            return null;
        }

        LoginUser loginUser=redisUtil.getCacheObject(principal.getName());
        loginUser.setPassword(null);

        return RespBean.success("success",loginUser);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello Admin!";
    }



}
