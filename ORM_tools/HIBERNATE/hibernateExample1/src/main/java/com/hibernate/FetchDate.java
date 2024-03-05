package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDate {

	public static void main(String[] args) {
		
		// get and load method example
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory= cfg.buildSessionFactory();
        
        
        Session session=factory.openSession();
        
        //Transaction tx= session.beginTransaction();
        
        Student student=(Student)session.get(Student.class, 3);
        
        System.out.println(student);
        
        //Address address=(Address)session.load(Address.class, 2);
        //System.out.println("$$$$$"+address.getCity());
        
        //tx.commit();
        session.close();

	}

}
