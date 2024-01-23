package com.jwt.config.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class CustomSecurityDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        /*
        * here we are using fake user that provide by spring.
        * when We will use DB then we will get the user from database
        * */
        if(userName.equals("nitendra")){
            return new User("Nitendra","nk123",new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User Not Found !!");
        }
    }
}
