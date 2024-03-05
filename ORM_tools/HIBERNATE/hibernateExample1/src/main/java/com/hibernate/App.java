package com.hibernate;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");     // if cfg file at src/main/java then no need to pass file name otherwise provide correct path
        
        SessionFactory factory= cfg.buildSessionFactory();
        
        
//        System.out.println(factory);
        
//        Student st=new Student();
//        
//        st.setName("nitendra");
//        st.setCity("Bahjoi");
//        
//        Address ad=new Address();
//        
//        ad.setStreet("street2");
//        ad.setCity("chandausi");
//        ad.setX(23.345);
//        ad.setAddedDate(new Date());
//        ad.setOpen(true);

        Employee emp=new Employee();
        emp.setAge(20);
        emp.setName("shayam kumar");
        
        Session session=factory.openSession();
//        
        Transaction tx= session.beginTransaction();
//        
        session.save(emp);

//        Employee e=session.get(Employee.class, 1);
//        e.setAge(25);
        System.out.println("before ===> "+emp);
        tx.commit();
//        emp.setAge(30);
        //session.evict(emp);
//        Employee e=session.load(Employee.class, 11);
//        e.setAge(40);
        //session.beginTransaction();
        //Employee e=session.get(Employee.class, 18);
        //e.setAge(70);
        //session.update(emp);
        //emp.setAge(40);
        //session.update(emp);
       // session.getTransaction().commit();
       // System.out.println("e ===>  "+e);
        
        session.beginTransaction();
//        session.delete(emp);
//        System.out.println("deleted emp ==>> "+emp);
        //Employee demp=session.get(Employee.class, emp.getId());
        emp.setAge(100);
        session.update(emp);
        session.getTransaction().commit();
        
        //Employee demp=session.get(Employee.class, emp.getId());
        System.out.println("demp==>> "+emp);
        session.close();
        System.out.println("after===>  "+emp);


        
        
    }
}
