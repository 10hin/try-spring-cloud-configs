package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoClientApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoClientApplication.class);

	@Value("${foo}")
	private String foo;

	@RequestMapping("/")
	public String home() {
		LOGGER.info("home() called");
		return "Hello World!";
	}

	@RequestMapping("/foo")
	public String foo() {
		LOGGER.info("foo() called");
		return this.foo;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoClientApplication.class, args);
	}

}
