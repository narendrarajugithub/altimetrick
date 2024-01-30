package com.alti.sprindemo.service;

import org.springframework.stereotype.Service;

import com.alti.sprindemo.model.Employee;
public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	
	public Employee getEmployee(Long id);
	
}
