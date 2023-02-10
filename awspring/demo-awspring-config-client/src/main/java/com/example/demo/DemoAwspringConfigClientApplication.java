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
public class DemoAwspringConfigClientApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoAwspringConfigClientApplication.class);

	@Value("${ssm.hello}")
	private String ssmHello;

	@Value("${asm.hello}")
	private String asmHello;

	@RequestMapping("/")
	public String home() {
		LOGGER.info("home() called");
		return "Hello World!";
	}

	@RequestMapping("/ssm")
	public String ssm() {
		LOGGER.info("ssm() called");
		return this.ssmHello;
	}

	@RequestMapping("/asm")
	public String asm() {
		LOGGER.info("asm() called");
		return this.asmHello;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoAwspringConfigClientApplication.class, args);
	}

}
