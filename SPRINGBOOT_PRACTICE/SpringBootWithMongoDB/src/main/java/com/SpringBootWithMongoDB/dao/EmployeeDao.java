package com.SpringBootWithMongoDB.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootWithMongoDB.entity.Employee;


@Repository
public interface EmployeeDao extends MongoRepository<Employee, String>{

}
