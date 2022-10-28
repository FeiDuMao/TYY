package com.tyy.common.exception;

import java.io.Serial;

public class TyyIllegalOperationException extends BaseException {
    @Serial
    private static final long serialVersionUID = 3346600657740537382L;

    public TyyIllegalOperationException(String key, String msg, Object[] args) {
        super(key, msg, args);
    }
}
