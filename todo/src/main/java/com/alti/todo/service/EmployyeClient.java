package com.alti.todo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alti.todo.model.Employee;

import lombok.NoArgsConstructor;

@FeignClient(name = "EMPLOYEE-SERVICE" , url = "http://localhost:8088")
public interface EmployyeClient {

	@GetMapping("/employee/{id}")
	Employee getEmployee(@PathVariable Long id);
	
}

