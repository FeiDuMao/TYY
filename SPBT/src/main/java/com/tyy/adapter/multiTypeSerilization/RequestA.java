package com.tyy.adapter.multiTypeSerilization;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

/**
 * @Date 2022/9/19 10:43
 * @Created by taoyuanyuan
 */
public class RequestA extends BaseRequest {

    List<String> codes;
    String c1;

    @JsonCreator
    public RequestA(String date, List<String> codes, String c1) {
        super(date);
        this.codes = codes;
        this.c1 = c1;
    }

    @Override
    Universe getUniverse() {
        return new Universe.Static(codes);
    }
}
