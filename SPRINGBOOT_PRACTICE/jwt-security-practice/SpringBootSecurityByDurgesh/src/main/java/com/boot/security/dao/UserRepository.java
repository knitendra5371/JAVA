package com.boot.security.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.security.entities.User;

@Repository
@Transactional
public class UserRepository {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	
	
	public User getUserByUsername(String username) {
		User user=null;
		List<User> l=sessionfactory.getCurrentSession().createQuery("from User where email = "+username).list();
		if(l.size()>0) {
			user=l.get(0);
		}
		return user;
	}
	

	public void save(User user) {
		sessionfactory.getCurrentSession().save(user);
	}

}
