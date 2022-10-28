package com.tyy.adapter.multiTypeSerilization;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

import java.util.List;

/**
 * @Date 2022/9/19 10:43
 * @Created by taoyuanyuan
 */
public class RequestC extends BaseRequest {

    List<String> codes;
    Double d;

    @JsonCreator
    public RequestC(String date, List<String> codes, Double d) {
        super(date);
        this.codes = codes;
        this.d = d;
    }

    @Override
    Universe getUniverse() {
        return new Universe.Static(codes);
    }
}
