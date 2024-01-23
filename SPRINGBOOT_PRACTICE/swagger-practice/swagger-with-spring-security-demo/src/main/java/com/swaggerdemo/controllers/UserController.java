package com.swaggerdemo.controllers;


import com.swaggerdemo.security.models.JwtUser;
import com.swaggerdemo.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
//@SecurityRequirement(name = "scheme1")  // we need to add this annotation if we use annotation based swagger configuration
@Tag(name = "User Controller", description = "To perform Operations on users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @Operation(summary = "GET operation on users",
            description = "It's used to retrieve all user objects from database")
    public List<JwtUser> getAllUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/current-user")
    @Operation(summary = "GET operation on users",
            description = "It's used to retrieve current or login user objects from database")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}
