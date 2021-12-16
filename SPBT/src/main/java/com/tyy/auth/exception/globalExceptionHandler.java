package com.tyy.auth.exception;




import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
public class globalExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public void UserNotFound(){
        log.warn("user not find");
    }


}
