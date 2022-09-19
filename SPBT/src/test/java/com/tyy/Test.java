package com.tyy;

import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @Date 2022/9/9 16:44
 * @Created by taoyuanyuan
 */
public class Test {




    @org.junit.jupiter.api.Test
    public void test(){


        List<String> list = List.of("2","3");
        List<String> result = list.stream().filter(s -> s.equals("1")).map(String::toUpperCase).toList();
        System.out.println(result.isEmpty());


    }




}
