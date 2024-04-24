package com.microservices.jwtauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.jwtauth.entity.User;
import com.microservices.jwtauth.repo.AuthenticationUser;
@Service
public class UserAuthenticationService {
	
	@Autowired
	private AuthenticationUser authuserrepo;
	
	public User saveUser(User user) {
		
	return	authuserrepo.save(user);
	}
	
	
	public User getUser(User user) {
		return authuserrepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

}
