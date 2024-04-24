package com.microservices.jwtauth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.jwtauth.entity.User;
@Repository
public interface AuthenticationUser extends JpaRepository<User, String> {

	User findByUsernameAndPassword(String username,String Password);
	
}
