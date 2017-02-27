package com.springboot.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootDocker {

	public static void main(String[] args) {
		System.out.println("it works!");
		SpringApplication.run(SpringbootDocker.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}
}
