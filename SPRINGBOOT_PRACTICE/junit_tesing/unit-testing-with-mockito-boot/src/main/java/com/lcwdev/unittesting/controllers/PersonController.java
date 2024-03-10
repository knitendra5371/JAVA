package com.lcwdev.unittesting.controllers;

import com.lcwdev.unittesting.model.Person;
import com.lcwdev.unittesting.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/save")
    public Person save(@RequestBody Person person){
        return this.personService.save(person);
    }

    @GetMapping("/list")
    public List<Person> findAll(){
        return this.personService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable Integer id){
        System.out.println("controller id=====>>>"+id);
        return this.personService.findById(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Person person){
        this.personService.delete(person);
    }

    @GetMapping("/exist/{id}")
    public Boolean isPersonExistsById(@PathVariable Integer id){
        System.out.println("controller isPersonExistsById id=====>>>"+id);
        return this.personService.isPersonExistById(id);
    }
}
