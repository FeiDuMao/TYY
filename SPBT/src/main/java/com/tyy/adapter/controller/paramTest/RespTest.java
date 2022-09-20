package com.tyy.adapter.controller.paramTest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * 一个对象做为返回的对象时
 *
 * @Date 2022/9/19 16:34
 * @Created by taoyuanyuan
 */


public class RespTest {

    private String name;
    private String address;

    public RespTest(String name, String address) {
        this.name = name;
        this.address = address;
    }

//    当一个对象作为返回视图时，至少要有一个Get方法,对于没有Getter的属性，在返回的json字符串中，就不会有该字段
    public String getName() {
        return name;
    }


}
