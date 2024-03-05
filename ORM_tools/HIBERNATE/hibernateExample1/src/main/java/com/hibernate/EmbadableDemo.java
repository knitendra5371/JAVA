package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbadableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Configuration cfg=new Configuration();
	        cfg.configure("hibernate.cfg.xml");     // if cfg file at src/main/java then no need to pass file name otherwise provide correct path
	        
	        SessionFactory factory= cfg.buildSessionFactory();
	        
	        Student stu1=new Student();
	        stu1.setCity("kanpur");
	        stu1.setName("kaliya");
	        
	        Certificate certi=new Certificate();
	        certi.setCourse("python");
	        certi.setDuration("3 months");
	        
	        stu1.setCerti(certi);
	        
	        
	        
	        Student stu2=new Student();
	        stu2.setCity("allahabad");
	        stu2.setName("ramendra");
	        
	        Certificate certi1=new Certificate();
	        certi1.setCourse("java");
	        certi1.setDuration("5 months");
	        
	        stu2.setCerti(certi1);
	        
	        Session session=factory.openSession();
	        
	        Transaction tx= session.beginTransaction();
	        
	        session.save(stu1);
	        session.save(stu2);
	        
	        
	        tx.commit();
	        session.close();
	        factory.close();

	}

}
