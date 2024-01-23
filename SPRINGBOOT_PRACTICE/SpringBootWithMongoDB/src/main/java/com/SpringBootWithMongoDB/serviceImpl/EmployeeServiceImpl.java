package com.SpringBootWithMongoDB.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootWithMongoDB.dao.EmployeeDao;
import com.SpringBootWithMongoDB.entity.Employee;
import com.SpringBootWithMongoDB.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.save(employee);
	}

	@Override
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	public void deleteEmployee(String epmloyeeId) {
		// TODO Auto-generated method stub
		employeeDao.deleteById(epmloyeeId);
		
	}

	@Override
	public Employee getEmployee(String employeeId) {
		// TODO Auto-generated method stub
//		return employeeDao.findOne(employeeId);
		return null;
	}

}
