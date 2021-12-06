package com.tyy.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object object;

    public static RespBean success(String msg){
        return new RespBean(200,msg,null);
    }

    public static RespBean success(String msg,Object o){
        return new RespBean(200,msg,o);
    }

    public static RespBean error(String msg){
        return new RespBean(500,msg,null);
    }

    public static RespBean error(String msg,Object o){
        return new RespBean(500,msg,o);
    }
}
