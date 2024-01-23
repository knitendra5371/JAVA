package com.content.controller;

import com.content.model.Person;
import com.content.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/list")
    public List<Person> getAll() {
//        List<Person> list = List.of(new Person(1, "Nitendra", "Bahjoi"), new Person(2, "Ramendra", "chandausi"));
        System.out.println("indise person controller***********************");
        return personService.findAll();
    }
}
