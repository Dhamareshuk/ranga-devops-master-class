package com.dhamareshuk.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dhamareshuk.rest.webservices.restfulwebservices.environment.InstanceInformationService;

@RestController
public class HelloWorldController {
	
	@Autowired
	private InstanceInformationService service;

	@GetMapping(path = "/")
	public String imUpAndRunning() {
		return "{healthy:true}";
	}

	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World " + " RELEASE : 3 " + service.retrieveInstanceInfo();
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	/// hello-world/path-variable/dhamareshuk
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
