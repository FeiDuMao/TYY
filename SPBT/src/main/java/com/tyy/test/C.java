package com.tyy.test;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Date 2022/8/5 16:29
 * @Created by taoyuanyuan
 */
@Component
@AllArgsConstructor
public class C {


    D d;

    public void print(){
        System.out.println("cc");
    }


}
