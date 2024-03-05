package com.sqlExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.query.NativeQuery;
//import org.hibernate.query.Query;

public class SqlExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		String q="select * from STUDENT";
//		NativeQuery query=session.createSQLQuery(q);
//
//		List<Object[]> list=query.list();
//
//		for(Object[] st:list) {
//			System.out.println(Arrays.toString(st));
//		}
//
		
		
		session.close();
		factory.close();

	}

}
