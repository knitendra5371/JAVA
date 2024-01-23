package com.student;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

// this is a simple java project, we add spring libraries and created bean

public class Test {
    public static void main(String[] args) {
        // if we put xml file inside src it will pick directly otherwise we need to provide cull path after src

        //Resource resource=new ClassPathResource("com/student/applicationContext.xml"); //
        Resource resource=new ClassPathResource("applicationContext.xml");
        BeanFactory factory=new XmlBeanFactory(resource);

        Student student=(Student)factory.getBean("studentbean");
        student.displayInfo();
    }
}
