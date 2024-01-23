package com.centerexception.globalexception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
* This is a centralized exception class.
* Note: @Controller ----> @ControllerAdvice , @RestController -----> @RestControllerAdvice
* */


@RestControllerAdvice
public class MyExceptionHandler {

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = NullPointerException.class)
    public String exceptionHandlerNull() {
        return "Null Pointer exception has occured";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = NumberFormatException.class)
    public String exceptionHandlerNumberFormat() {
        return "Number Format exception has occured";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public String exceptionHandlerException() {
        return "Exception has occured";
    }
}
