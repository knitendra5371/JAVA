package com.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.User;

@Service
public class UserService {

	List<User> list=new ArrayList<>();
	{
		list.add(new User(120,"nitendra",null));
		list.add(new User(121,"jitendra",null));
		list.add(new User(122,"ramendra",null));
		list.add(new User(123,"shayamendra",null));
	}
	
	public UserService() {
		super();
//		list.add(new User(120,"nitendra",null));
//		list.add(new User(121,"jitendra",null));
//		list.add(new User(122,"ramendra",null));
//		list.add(new User(123,"shayamendra",null));
	}

	public User getUser(int userId) {
		return this.list.stream().filter(user->user.getId()==userId).findAny().orElse(null);
	}
	
}
