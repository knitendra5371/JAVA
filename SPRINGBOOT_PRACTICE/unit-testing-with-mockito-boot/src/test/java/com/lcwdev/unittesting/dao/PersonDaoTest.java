package com.lcwdev.unittesting.dao;

import com.lcwdev.unittesting.model.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PersonDaoTest {

    @Autowired
    private PersonDao personDao;

    @Test
    public void testIsPersonExistsById(){
        Person person = new Person(128,"Nitendra","Bangalore");
        personDao.save(person);

        Boolean actualResult = personDao.isPersonExistsById(128);

//        assertTrue(actualResult); // this assertion by jupitor

       assertThat(actualResult).isTrue(); // this assertion by assetj library

    }

}