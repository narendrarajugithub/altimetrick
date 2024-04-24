package com.microservices.jwtauth.user;

import org.springframework.lang.NonNull;

public class User {
	@NonNull
	private String username;
	@NonNull
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User() {
		
	}
	
	
	
}
