package com.springboot.docker.chuck;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChuckController {

	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private ChuckFactClient chuckFactClient;

	ChuckController(ChuckFactClient chuckFactClient) {
		this.chuckFactClient = chuckFactClient;
	}

	@RequestMapping("/")
	public @ResponseBody String home() {
		log.debug("Got a request!");
		return "Hello Docker World and Kubernetes and Travis-ci and Spring boot";
	}

	@RequestMapping("/chuck")
	public @ResponseBody ChuckFact greeting() {
		log.debug("Got a request!");
		return chuckFactClient.randomFact();
	}

}

@FeignClient("springboot-docker-db")
interface ChuckFactClient {

	@RequestMapping(method = RequestMethod.GET, value = "/chuck")
	ChuckFact randomFact();
}
