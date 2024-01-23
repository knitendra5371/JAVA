package com.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
	
	
	@Bean
	public UserDetailsService userDetailService() {
		
		InMemoryUserDetailsManager user_detail=new InMemoryUserDetailsManager();
		
		UserDetails user=User.withUsername("neet").password("123").authorities("read").build();
		
		 user_detail.createUser(user);
		
		 return user_detail;
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}

}
