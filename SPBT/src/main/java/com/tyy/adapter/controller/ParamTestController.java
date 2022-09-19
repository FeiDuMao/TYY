package com.tyy.adapter.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Date 2022/9/19 16:09
 * @Created by taoyuanyuan
 */
@RestController
@RequestMapping("/param")
public class ParamTestController {


    @GetMapping("/get/{name}")
    public String testGet(@PathVariable("name") String name,
                          @RequestParam("addr") String address) {//当入参名字不一样时，使用@RequestParam，相同可以不加
        System.out.println(name);
        return "ok";
    }


}
