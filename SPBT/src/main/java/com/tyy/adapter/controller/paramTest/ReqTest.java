package com.tyy.adapter.controller.paramTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Date 2022/9/19 16:35
 * @Created by taoyuanyuan
 */

@AllArgsConstructor
@Data
public class ReqTest implements Serializable {

    @Serial
    private static final long serialVersionUID = -7843869606042047318L;
    private String name;
    private String age;

    //一个对象作为@RequestBody接收参数的对象时，必须要有无参构造器！！！
    public ReqTest() {
    }

    @SneakyThrows
    @Override
    public String toString() {
        return new ObjectMapper().writeValueAsString(this);
    }

    //至少要有一个Setter方法，对于没有Setter的属性，在反序列化的时候，该字段的值为null
    public void setName(String name) {
        this.name = name;
    }


}
