package com.tyy.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Date 2022/7/13 14:54
 * @Created by taoyuanyuan
 */
@Component
public class Test {

    private String id;

    public Test(@Value("${asset.factor.id}")
                        String id) {
        this.id = id;
    }

    public void doSomeThing() {

        System.out.println("OK");

    }


}
