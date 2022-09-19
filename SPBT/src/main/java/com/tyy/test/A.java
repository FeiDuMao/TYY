package com.tyy.test;

import org.springframework.stereotype.Component;

/**
 * @Date 2022/9/14 17:12
 * @Created by taoyuanyuan
 */
@Component
public class A {

    B b;

    public A(B b) {
        this.b = b;
    }
}
