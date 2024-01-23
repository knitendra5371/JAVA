package com.swaggerdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
//@SecurityRequirement(name = "scheme1")  // we need to add this annotation if we use annotation based swagger configuration
public class HomeController {

    @GetMapping("/test")
    public String homeTest(){
        return "This is a protected data";
    }

    @GetMapping("/user")
    public String userDetail(){
        return "This is a user data";
    }
}
