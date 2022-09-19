package com.tyy.adapter.controller;

import com.tyy.service.RespView;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * @Date 2022/9/19 16:09
 * @Created by taoyuanyuan
 */
@RestController
@RequestMapping("/param")
public class ParamTestController {


    @GetMapping("/get/{name}")
    public String testGet(@PathVariable("name") String name,//使用@PathVariable获取路径参数
                          @RequestParam("addr") String address) {//当入参名字不一样时，使用@RequestParam，相同可以不加！！！
        System.out.println(name);
        return "ok";
    }

    @GetMapping("/date")//@DateTimeFormat(pattern = "yyyy-MM-dd") 可以反序列化一个LocalDate的入参类型
    public String test2(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, String name) {
        System.out.println(date);
        System.out.println(name);
        return "ok";
    }

    @PostMapping("/resp")
    public RespTest respTest(@RequestBody ReqTest reqTest){
        System.out.println(reqTest);
        return new RespTest("tyy","123");
    }

}
