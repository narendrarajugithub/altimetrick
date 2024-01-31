package com.alti.todo.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alti.todo.model.Employee;
import com.alti.todo.service.EmployyeClient;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@RestController
@NoArgsConstructor
public class TodoController {
	@Autowired(required = true)
	private EmployyeClient client;
	
	@GetMapping("/hello/{msg}")
	public Employee getMessage(@PathVariable Long msg) {
		
		/*
		 * URI uri = null; try { uri = new URI("http://localhost:8088/employee/2"); }
		 * catch (URISyntaxException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } RestTemplate template = new RestTemplate();
		 * System.out.println(template.getForEntity(uri, Employee.class).toString());
		 */
		
Employee e =	client.getEmployee(msg);
		
		return e;
	}
}
