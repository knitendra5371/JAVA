package com.springboot.controller;

import com.springboot.dao.EmployeeDao;
import com.springboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "data inserted Successfully";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestBody Employee emp){

        int status=employeeDao.deleteEmployee(emp);
        return "data inserted Successfully";
    }


}
