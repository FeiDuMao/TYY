package com.tyy.auth.adapter.in.view;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class RespBody implements Serializable {
    Object o;
    String msg;
    int status;

    public static RespBody OK(Object o, String msg) {
        return new RespBody(o,msg, 200);
    }

    public static RespBody ERROR(Object o, String msg) {
        return new RespBody(o, msg, 400);
    }

}
