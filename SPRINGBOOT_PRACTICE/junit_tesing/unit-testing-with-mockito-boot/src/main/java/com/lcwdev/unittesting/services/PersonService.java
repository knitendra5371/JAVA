package com.lcwdev.unittesting.services;

import com.lcwdev.unittesting.dao.PersonDao;
import com.lcwdev.unittesting.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;


    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> findAll(){
        return this.personDao.findAll();
    }

    public Person save(Person person){
        return this.personDao.save(person);
    }

    public Optional<Person> findById(Integer id){
        System.out.println("service id=====>>>"+id);
        return this.personDao.findById(id);
    }

    public void delete(Person person){
        this.personDao.delete(person);
    }

    public Boolean isPersonExistById(Integer id){
        return this.personDao.isPersonExistsById(id);
    }
}
