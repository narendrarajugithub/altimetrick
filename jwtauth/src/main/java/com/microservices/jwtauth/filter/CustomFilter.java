package com.microservices.jwtauth.filter;

import java.io.IOException;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CustomFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httprequest=(HttpServletRequest)request;
		HttpServletResponse httpresponse=(HttpServletResponse)response;
		
		String authdata=httprequest.getHeader("Authorization");
		
		if(authdata==null||!authdata.startsWith("Bearer")) 
			throw new ServletException();
		String mytoken=authdata.substring(7);
		
		try {
		JwtParser jparser =	Jwts.parser().setSigningKey("mysigninkey");
		Jwt obj=	jparser.parse(mytoken);
			Claims claimdata=(Claims)obj.getBody();
			String username=claimdata.getSubject();
			HttpSession session= httprequest.getSession();
			session.setAttribute("username", username);
			
		}
		catch (SignatureException se) {
			se.getMessage();
		}
		
		
		
	}
	
	

}
