package com.alti.sprindemo.exception;

public class EmployeeNotFound extends RuntimeException {

	public EmployeeNotFound() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public EmployeeNotFound(String msg) {
		super(msg);
	}
	
}
