package com.tyy.common.exception;

/**
 * @Date 2022/9/19 17:15
 * @Created by taoyuanyuan
 */
public class BadRequestParamExceptioin extends Throwable {
    public BadRequestParamExceptioin(String className, String fieldName) {
        super(String.format("%s 's filed : %s is null", className, fieldName));
    }
}
