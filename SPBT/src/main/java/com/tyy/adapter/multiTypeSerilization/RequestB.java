package com.tyy.adapter.multiTypeSerilization;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.beans.ConstructorProperties;

/**
 * @Date 2022/9/19 10:44
 * @Created by taoyuanyuan
 */
public class RequestB extends BaseRequest {

    String code;

    @ConstructorProperties({"date","code"})
    public RequestB(String date, String code) {
        super(date);
        this.code = code;
    }

    @Override
    Universe getUniverse() {
        return new Universe.Dynamic(code);
    }
}
