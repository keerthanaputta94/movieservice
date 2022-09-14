package com.brainfirst.cinema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Springboot2CurlApiDemoApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(Springboot2CurlApiDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Springboot2CurlApiDemoApplication.class, args);
		logger.info("Info| Server Started !!!");
		logger.debug("Debug| Server Started !!!");
		System.out.println("Server Started !!!");
	}
	
	@GetMapping("/")
	public String Welcome() {
		return "Welcome!";
	}
	
}
