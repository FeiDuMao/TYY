package com.tyy.test;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Date 2022/8/5 16:29
 * @Created by taoyuanyuan
 */
@Component
@AllArgsConstructor
public class A {

    B b;
    public void print(){
        System.out.println("AA");
        b.print();
    }




}
