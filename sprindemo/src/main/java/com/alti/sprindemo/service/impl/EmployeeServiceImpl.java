package com.alti.sprindemo.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alti.sprindemo.dao.EmployeeRepository;
import com.alti.sprindemo.exception.EmployeeNotFound;
import com.alti.sprindemo.model.Employee;
import com.alti.sprindemo.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee result = Optional.ofNullable(employee)  
                .orElseThrow(() -> new EmployeeNotFound("Employee is null"));  
		return employeeRepository.save(result) ;
	}

	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		
		
	Optional<Employee>	 employee =Optional.ofNullable(employeeRepository.findById(id)).orElseThrow(null);
		
		return employee.get();
	}
	
	

}
