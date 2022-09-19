package com.tyy.adapter.multiTypeSerilization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Date 2022/9/19 10:43
 * @Created by taoyuanyuan
 */
public class RequestA extends BaseRequest {

    @JsonProperty
    List<String> codes;

    public RequestA(String date, List<String> codes) {
        super(date);
        this.codes = codes;
    }

    @Override
    Universe getUniverse() {
        return new Universe.Static(codes);
    }
}
