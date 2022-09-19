package com.tyy.adapter.multiTypeSerilization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Date 2022/9/19 10:44
 * @Created by taoyuanyuan
 */
public class RequestB extends BaseRequest {

    String code;

    @JsonCreator
    public RequestB(String date, String code) {
        super(date);
        this.code = code;
    }

    @Override
    Universe getUniverse() {
        return new Universe.Dynamic(code);
    }
}
