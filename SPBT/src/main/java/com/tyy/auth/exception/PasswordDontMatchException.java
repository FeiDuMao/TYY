package com.tyy.auth.exception;

public class PasswordDontMatchException extends RuntimeException{

    public PasswordDontMatchException() {
        super("Password dont match");
    }
}
