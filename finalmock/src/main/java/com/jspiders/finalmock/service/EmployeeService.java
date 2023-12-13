package com.jspiders.finalmock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.finalmock.pojo.EmployeePOJO;
import com.jspiders.finalmock.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public EmployeePOJO addEmployee(String name) {

		EmployeePOJO employee = repository.addEmployee(name);
		return employee;
	}

	public List<EmployeePOJO> findAllEmployees() {

		List<EmployeePOJO> employees = repository.findAllEmployees();

		
		return employees;
	}

	public List<EmployeePOJO> searchPattern(String pattern) {

	List<EmployeePOJO> employees = repository.searchPattern(pattern);
		return employees;
	}
	
	
}
