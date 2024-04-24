package com.microservices.jwtauth.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.jwtauth.entity.User;
import com.microservices.jwtauth.services.UserAuthenticationService;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

	@Autowired
	private UserAuthenticationService authService;
	
	
	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@Validated @RequestBody  User user){
		
		authService.saveUser(user);
		
		return null;
	}
	
	
	@GetMapping("/login")
	public ResponseEntity validateUserLogin(@RequestBody User user){
		
	User findUser=authService.getUser(user);
	ResponseEntity<String> token;
	
	token= findUser!=null ?(new ResponseEntity<String>(genarateToken(findUser), HttpStatus.ACCEPTED)):(new ResponseEntity<String>("Invalid User", HttpStatus.BAD_REQUEST)); 
		
		return token;
	}
	
	@GetMapping("/getusers")
	public String getUsers() {
		return "token is valid";
	}
	
	
	
	public String genarateToken(User user) {
		
		long expiration =1000000;
		return Jwts.builder().setSubject(user.getUsername())
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+expiration))
		.signWith(SignatureAlgorithm.HS256, "mysuperkey").compact();
		
		
		
	}
	
	
	
	
	
}
