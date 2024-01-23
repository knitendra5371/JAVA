package com.SpringBootWithMongoDB.service;

import java.util.List;

import com.SpringBootWithMongoDB.entity.Employee;

public interface EmployeeService {
	
	Employee save(Employee employee);
	
	Employee update(Employee employee);
	
	List<Employee> getAllEmployee();
	
	void deleteEmployee(String epmloyeeId);
	
	Employee getEmployee(String employeeId);

}
