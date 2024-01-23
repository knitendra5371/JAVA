package com.cache.hibernate2levelcache.controllers;

import com.cache.hibernate2levelcache.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired(required = true)
    private SessionFactory factory;

    @GetMapping("/test")
    public void test(){



        Session session1 = factory.openSession();
        Student student1 = session1.get(Student.class, 123);
        System.out.println(student1);

        session1.close();

        Session session2 = factory.openSession();
        Student student2 = session2.get(Student.class, 123);
        System.out.println(student2);
        session2.close();
    }

}
