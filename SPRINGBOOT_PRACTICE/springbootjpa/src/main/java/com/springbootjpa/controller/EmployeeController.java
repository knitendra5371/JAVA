package com.springbootjpa.controller;

import com.springbootjpa.dao.EmployeeDao;
import com.springbootjpa.model.Employee;
import com.springbootjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody Employee emp){

//        int status=employeeDao.saveEmployee(emp);
        employeeService.saveEmployee(emp);
        return "data inserted Successfully";
    }

    @PostMapping("/update")
    public String updateEmployee(@RequestBody Employee emp){

//        int status=employeeDao.updateEmployee(emp);
        employeeService.updateEmployee(emp);
        return "data updated Successfully";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestBody Employee emp){
        employeeService.deleteEmployee(emp);
//        int status=employeeDao.deleteEmployee(emp);
        return "data deleted Successfully";
    }

}
