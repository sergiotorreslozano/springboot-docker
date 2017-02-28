package com.springboot.docker;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootDocker {

	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void main(String[] args) {
		log.debug("Springbood Docker init...");
		SpringApplication.run(SpringbootDocker.class, args);
	}

	@RequestMapping("/")
	public String home() {
		log.debug("Got a request!");
		return "Hello Docker World";
	}
}
