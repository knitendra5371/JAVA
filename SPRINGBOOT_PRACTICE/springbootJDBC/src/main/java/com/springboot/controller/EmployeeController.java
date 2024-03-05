package com.springboot.controller;

import com.springboot.dao.EmployeeDao;
import com.springboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody Employee emp){

        int status=employeeDao.saveEmployee(emp);
        return "data inserted Successfully";
    }

    @PostMapping("/update")
    public String updateEmployee(@RequestBody Employee emp){

        int status=employeeDao.updateEmployee(emp);
        return "data updated Successfully";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestBody Employee emp){

        int status=employeeDao.deleteEmployee(emp);
        return "data inserted Successfully";
    }

    @GetMapping("/{id}")
    public Optional<Employee> fetchById(@PathVariable int id){
        return employeeDao.findById(id);
    }

    @GetMapping("/list")
    public List<Employee> fetchAll(){
        return employeeDao.findAll();
    }

}
