package com.example.spbt.application.exceptioin;

public class TokenExpiredException extends Exception{

    public TokenExpiredException(String message) {
        super(message);
    }
}
