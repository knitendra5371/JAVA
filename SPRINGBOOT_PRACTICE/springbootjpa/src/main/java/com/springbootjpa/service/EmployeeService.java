package com.springbootjpa.service;

import com.springbootjpa.dao.EmployeeDao;
import com.springbootjpa.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public String saveEmployee(Employee emp){
        employeeDao.save(emp);
//        int status=employeeDao.saveEmployee(emp);
        return "data inserted Successfully";
    }
    public String updateEmployee( Employee emp){
        employeeDao.save(emp);
//        int status=employeeDao.updateEmployee(emp);
        return "data inserted Successfully";
    }

    public String deleteEmployee( Employee emp){
            employeeDao.delete(emp);
//        int status=employeeDao.deleteEmployee(emp);
        return "data inserted Successfully";
    }
}
