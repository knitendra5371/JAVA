package com.swaggerdemo.security.services;



import com.swaggerdemo.security.repositories.JwtUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private JwtUserRepository jwtUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // load user from database
//        User user = this.userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found !!"));

        return this.jwtUserRepository.findByEmail(username).orElseThrow(()->new RuntimeException("User not found"));
    }
}
