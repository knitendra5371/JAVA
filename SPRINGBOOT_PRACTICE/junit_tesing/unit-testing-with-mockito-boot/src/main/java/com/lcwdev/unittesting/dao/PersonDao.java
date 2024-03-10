package com.lcwdev.unittesting.dao;

import com.lcwdev.unittesting.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

//@Repository
//@Transactional
//@EnableJpaRepositories
public interface PersonDao extends JpaRepository<Person, Integer> {

//    @Query("SELECT p FROM Person p WHERE p.id = ?1 and p.name = ?2")
//    Person findPersonByStatusAndName(Integer id, String name);

//    @Query("SELECT p FROM Person p WHERE p.id = ?1")
//    Person isPersonExistsById(Integer id);

//    @Query(value = "SELECT * FROM persons p WHERE p.status = ?1", nativeQuery = true) // this is a native query
//    Person findPersonByIdNative(Integer id);

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM Person p WHERE p.id = ?1")// This is a JPQL
    Boolean isPersonExistsById(Integer id);
}
