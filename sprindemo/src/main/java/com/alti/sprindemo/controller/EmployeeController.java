package com.alti.sprindemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alti.sprindemo.model.Employee;
import com.alti.sprindemo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	private static Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		LOG.info("Employee save performed");
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping( "/employee")
	@ResponseBody
	public Employee getEmployee() {
		LOG.info("Employee get performed");
		return employeeService.getEmployee(1L);
		
	}

}
