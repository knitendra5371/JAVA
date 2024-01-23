package com.centerexception.globalexception.controller;



import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class EmployeeController {


    @GetMapping("/nullexception")
    public String nullTesting() {

        String str = null;
        System.out.println(str.length());

        return "data inserted Successfully";
    }

    @GetMapping("/numberformatexception")
    public String numberFromatTesting() {

        String str = "123bc";
        Integer value = Integer.parseInt(str);

        return "data inserted Successfully";
    }

   /*
    if we write exception handler method inside a controller then that will work only for that controller
    if we want to centralized exception then we need to create own my exception class
    Note: @Controller ----> @ControllerAdvice , @RestController -----> @RestControllerAdvice

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
    */
}
