package com.tyy.controller;


import com.google.code.kaptcha.Producer;
import com.tyy.entity.RespBean;
import com.tyy.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("/t")
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @Resource(name = "Math")
    private Producer producer;

    @RequestMapping("/getCaptcha")
    public RespBean test1(){

        String text = producer.createText();
        System.out.println(text);
        String[] split = text.split("@");
        //将答案放入redis中，有效时间为120s
        redisUtil.setCacheObject("CaptchaAns",split[1],120);
        Object t1 = redisUtil.getCacheObject("CaptchaAns");
        System.out.println(t1);

        return RespBean.success("success",split[0]);
    }

    //分布式锁测试
    @RequestMapping("/lock")
    public RespBean lock(Principal principal){

        //加锁
        if (redisUtil.setLock(principal)) {

            redisUtil.setCacheObject("name",principal.getName());
            //解锁
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            redisUtil.unLock(principal);
        }else {
            return RespBean.error("已被加锁，无法访问");
        }

        return RespBean.success("success");
    }




}
