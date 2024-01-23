package com.boot.security.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.entities.User;
import com.boot.security.service.UserService;

@RestController
@RequestMapping("")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping("/save")
	public  Map<String,Object> save(@RequestBody User user, HttpServletRequest req, HttpServletResponse res) {
		
		Map<String,Object> map=new HashMap<>();
		
		try {
			
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userService.save(user);
			map.put("status", "success");
		}catch(Exception e) {
			map.put("status", e.getMessage());
		}
		
		return map;
	}

	
}
