package com.tyy.common.exception;

import java.io.Serial;

/**
 * @Date 2022/9/19 17:15
 * @Created by taoyuanyuan
 */
public class BadRequestParamException extends Throwable {
    @Serial
    private static final long serialVersionUID = 5895429040744027754L;

    public BadRequestParamException(String className, String fieldName) {
        super(String.format("%s 's filed : %s is null", className, fieldName));
    }
}
