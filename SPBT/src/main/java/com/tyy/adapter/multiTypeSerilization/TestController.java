package com.tyy.adapter.multiTypeSerilization;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2022/9/9 16:53
 * @Created by taoyuanyuan
 */
@RestController
@RequestMapping("/test")
public class TestController {




    @RequestMapping("/serialization")
    public void handle(@RequestBody BaseRequest baseRequest){

        Universe universe = baseRequest.getUniverse();
        String date = baseRequest.getDate();
        System.out.println(date);


    }



}
