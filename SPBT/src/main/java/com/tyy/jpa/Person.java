package com.tyy.jpa;

import lombok.*;

/**
 * @Date 2022/9/19 17:17
 * @Created by taoyuanyuan
 */

@Data
@Builder//当一个类的属性较少时，可以使用构造器的方式构造对象，最好二者选其一
/**
 * 不能将@Builder和@NoArgsConstructor单独一起使用
 * 否则会报错 ： 无法将类 com.tyy.jpa.Person中的构造器 Person应用到给定类型;
 * 原因：builder在获取参数列表的时候，获取不到所有的属性，实际参数列表和形式参数列表长度不同
 */
public class Person {

    private String name;
    private Integer age;

    public Person(Integer age) {
        this.age = age;
    }
}

