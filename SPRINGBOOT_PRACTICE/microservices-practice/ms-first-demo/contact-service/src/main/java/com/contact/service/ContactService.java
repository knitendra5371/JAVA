package com.contact.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.entity.Contact;

@Service
public class ContactService {

	List<Contact> cList=new ArrayList<>();
	
	{
		cList.add(new Contact(1,"nitendra@gmail.com","12345",120));
		cList.add(new Contact(2,"nitendra@gmail.com","12345",120));
		cList.add(new Contact(3,"jitendra@gmail.com","12345",121));
		cList.add(new Contact(4,"ramendra@gmail.com","12345",122));
	}
	
	public List<Contact> getContact(int userId) {
		return cList.stream().filter(contact->contact.getUserId()==userId).collect(Collectors.toList());
	}
	
}
