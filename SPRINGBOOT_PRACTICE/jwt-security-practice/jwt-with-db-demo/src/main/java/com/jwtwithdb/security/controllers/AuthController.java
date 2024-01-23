package com.jwtwithdb.security.controllers;

import com.jwtwithdb.security.helper.JwtHelper;
import com.jwtwithdb.security.models.JwtRequest;
import com.jwtwithdb.security.models.JwtResponse;
import com.jwtwithdb.security.models.JwtUser;
import com.jwtwithdb.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        System.out.println("email: "+request.getEmail()+"  password: "+request.getPassword());
        this.doAuthenticate(request.getEmail(), request.getPassword());
        System.out.println("authentication completed....");
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        System.out.println("user details==> "+userDetails);
        String token = this.jwtHelper.generateToken(userDetails);
        System.out.println("token==> "+token);
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        System.out.println("response==> "+response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
        System.out.println("doAuthenticate emil: "+email+"   password : "+password);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
        try {
            System.out.println("authenticationToken ==> "+authenticationToken);
            System.out.println("authenticationToken =====> "+authenticationToken.getCredentials().toString());
            authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new BadCredentialsException("Invalid username or password !!");
        }

    }

    @PostMapping("/create-user")
    public JwtUser createUser(@RequestBody JwtUser jwtUser){
        System.out.println("jwtUser before ==> "+jwtUser.getPassword());
        jwtUser.setPassword(passwordEncoder.encode(jwtUser.getPassword()));
        System.out.println("jwtUser before ==> "+jwtUser.getPassword());
        return userService.createUser(jwtUser);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler(){
        return "Invalid Credentials !!";
    }

}
