package com.example.spbt.application.exceptioin;


public class IncorrectPasswordException extends RuntimeException{

    public IncorrectPasswordException(){
        super("Incorrect password！");
    }
}
