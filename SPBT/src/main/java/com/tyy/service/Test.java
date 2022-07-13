package com.tyy.service;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Date 2022/7/13 14:54
 * @Created by taoyuanyuan
 */
@Component
@RequiredArgsConstructor
public class Test {


    public void doSomeThing() {
        System.out.println("OK");
    }


}
