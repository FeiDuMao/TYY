package com.tyy.common.exception;


import lombok.Getter;

import java.io.Serial;

@Getter
public class BaseException extends Exception {
    @Serial
    private static final long serialVersionUID = -8081767129228449890L;
    private final String key;
    private final String msg;
    private final Object[] args;

    public BaseException(String key, String msg, Object[] args) {
        super(msg);
        this.key = key;
        this.msg = msg;
        this.args = args;
    }
}
