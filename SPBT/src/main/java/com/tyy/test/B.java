package com.tyy.test;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Date 2022/9/14 17:12
 * @Created by taoyuanyuan
 */
@Component
public class B {

//    C c;
//
//    public B(C c) {
//        this.c = c;
//    }

    A a;

    public B(@Lazy A a) {
        this.a = a;
    }
}
