package com.alti.sprindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@EnableConfigServer
@SpringBootApplication
public class SprindemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprindemoApplication.class, args);
	}

}
