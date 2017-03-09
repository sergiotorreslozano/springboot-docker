package com.springboot.docker;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootDocker {

	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void main(String[] args) {
		log.debug("Springbood Docker init");
		SpringApplication.run(SpringbootDocker.class, args);
	}

	@RequestMapping("/")
	public @ResponseBody Greeting home() {
		log.debug("Got a request!");
		return new Greeting("Hello Docker World and Kubernetes and Travis-ci and Spring boot");
	}

	@RequestMapping("/{greeting}")
	public @ResponseBody Greeting greeting(@PathVariable String greeting) {
		log.debug("Got a request!");
		return new Greeting("Hello " + greeting);
	}

}

class Greeting {
	String greeting;

	/**
	 * @param greeting
	 */
	Greeting(String greeting) {
		super();
		this.greeting = greeting;
	}

	/**
	 * @return the greeting
	 */
	public String getGreeting() {
		return greeting;
	}


}
