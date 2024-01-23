package com.jdbcclient.controllers;

import com.jdbcclient.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private JdbcClient jdbcClient;

    @GetMapping("/list")
    public List<Person> getAllPerson(){
        return jdbcClient.sql("select * from persons").query(Person.class).list();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable int id){
        return jdbcClient.sql("SELECT * FROM persons WHERE id = :id")
                .param("id", id)
                .query(Person.class)
                .optional();
    }

    @PostMapping("/create")
    public void create(@RequestBody Person person){
        int update = jdbcClient.sql("INSERT INTO persons(id,name,city) values(?,?,?)")
                .params(List.of(person.getId(),person.getName(),person.getCity()))
                .update();

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        var updated = jdbcClient.sql("delete from persons where id = :id")
                .param("id", id)
                .update();
    }
}
