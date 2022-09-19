package com.tyy.adapter.multiTypeSerilization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @Date 2022/9/19 10:40
 * @Created by taoyuanyuan
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)//表示根据属性名字自动推断; 若子类属性名字和入参名字不同，可以搭配@JsonProperty; 相同则直接在子类的构造器上加上@JsonCreator
@JsonSubTypes({
        @JsonSubTypes.Type(RequestA.class),
        @JsonSubTypes.Type(RequestB.class)
})

public abstract class BaseRequest {

    String date;

    public BaseRequest(String date) {
        this.date = date;
    }

    abstract Universe getUniverse();

    public String getDate() {
        return date;
    }
}
