package com.tyy.auth.exception;

public class UserNotFoundException extends RuntimeException{


    public UserNotFoundException(){
        super("user not find");
    }

}
