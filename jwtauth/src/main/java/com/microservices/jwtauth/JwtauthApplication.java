package com.microservices.jwtauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.microservices.jwtauth.filter.CustomFilter;

@SpringBootApplication
public class JwtauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtauthApplication.class, args);
	}
	
	@Bean
	
	public FilterRegistrationBean geFilter() {
		UrlBasedCorsConfigurationSource urlConfigSource=new UrlBasedCorsConfigurationSource();
		
		CorsConfiguration corsConfig=new CorsConfiguration();
		corsConfig.addAllowedOrigin("*");
		corsConfig.addExposedHeader("*");
		corsConfig.addAllowedMethod("*");
		corsConfig.setAllowCredentials(true);
		urlConfigSource.registerCorsConfiguration("/**", corsConfig);
		FilterRegistrationBean fbean=new FilterRegistrationBean<>(new CorsFilter(urlConfigSource));
		fbean.setFilter(new CustomFilter());
		fbean.addUrlPatterns("/getusers");
		
		
		
		return fbean;
		
	}

}
