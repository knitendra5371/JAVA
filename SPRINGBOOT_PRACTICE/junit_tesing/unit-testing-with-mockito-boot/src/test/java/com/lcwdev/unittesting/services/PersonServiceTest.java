package com.lcwdev.unittesting.services;

import com.lcwdev.unittesting.dao.PersonDao;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {


    private PersonService personService;

    @Mock
    private PersonDao personDao;

    @BeforeAll
    static void init(){

    }

    @AfterAll
    static void cleanup(){

    }

    @BeforeEach
    void setUp() {
        personService = new PersonService(personDao);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testFindAll(){
        personService.findAll();
        verify(personDao).findAll();

    }

}