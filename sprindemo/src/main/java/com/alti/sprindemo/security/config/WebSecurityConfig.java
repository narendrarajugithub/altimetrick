package com.alti.sprindemo.security.config;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.TargetClassAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




 
@Configuration
 @EnableWebMvc
public class WebSecurityConfig  {
	
	 private static Logger log = LoggerFactory.getLogger(WebSecurityConfig.class);
	
	/*
	 * spring Security provides SecurityFilterChain to validate authentication,authorization,CSRF,..
	 * etc,
	 * */
	
	 @Bean
	public	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 log.info("Security filter exicution started----------------------------------------->");
			http.authorizeHttpRequests(
					auth -> {
						auth.anyRequest().authenticated();
					});
	
	http.sessionManagement(
					session -> 
						session.sessionCreationPolicy(
								SessionCreationPolicy.STATELESS)
					);
	
	http.headers(headers -> headers.frameOptions(frameOptionsConfig-> frameOptionsConfig.disable()));
	//http.formLogin();
	http.httpBasic(withDefaults());

	http.csrf(csrf -> csrf.disable());
	
	return http.build();
		}

	
	
	
	  @Bean 
	  public UserDetailsService userDetailsService(DataSource dataSource) {
	  
	  var user =
	  User.withUsername("narendra").password("raju").passwordEncoder(string ->
	  passwordEncoder().encode(string)).roles("ADMIN").build();
	  
	  JdbcUserDetailsManager juser = new JdbcUserDetailsManager(dataSource);
	  juser.createUser(user);
	  return juser; 
	  }
	
	
	 
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	 
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// TODO Auto-generated method stub
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:8088");
				
				//WebMvcConfigurer.super.addCorsMappings(registry);
			}
		};
		
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
				.build();
	}
	
	
	
}
