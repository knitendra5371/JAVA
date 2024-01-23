package com.jwtwithdb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
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
