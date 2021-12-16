package com.tyy.auth.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class RespBody implements Serializable {

    Object object;
    String msg;
    int code;

    public static RespBody OK(Object object) {
        return new RespBody(object,"login success",200);
    }

    public static RespBody ERROR(Object object,String msg) {
        return new RespBody(object,msg,500);
    }


}
