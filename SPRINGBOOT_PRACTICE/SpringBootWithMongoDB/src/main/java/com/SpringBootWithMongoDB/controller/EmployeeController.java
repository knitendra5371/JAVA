package com.SpringBootWithMongoDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootWithMongoDB.entity.Employee;
import com.SpringBootWithMongoDB.service.EmployeeService;

@RestController
@RequestMapping(value="employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value="/save")
	public Employee save(@RequestBody Employee employee) {	
		return employeeService.save(employee);
	}
	
	@PutMapping(value="/update")
	public Employee update(@RequestBody Employee employee) {
		return employeeService.update(employee);
	}
	
	@GetMapping(value="/all")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping(value="/by/{employeeId}")
	public Employee getEmployee(@PathVariable(name="employeeId") String employeeId) {
		return employeeService.getEmployee(employeeId);
	}
	
	@DeleteMapping(value="/delete/{employeeId}")
	public void deleteEmployee(@PathVariable(name="employeeId") String employeeId) {
		
	}

}
