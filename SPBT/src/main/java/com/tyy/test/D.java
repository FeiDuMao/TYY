package com.tyy.test;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Date 2022/8/5 16:29
 * @Created by taoyuanyuan
 */
@Component
@AllArgsConstructor
public class D {


    A a;

    public void print(){
        System.out.println("ddd");
    }


}
