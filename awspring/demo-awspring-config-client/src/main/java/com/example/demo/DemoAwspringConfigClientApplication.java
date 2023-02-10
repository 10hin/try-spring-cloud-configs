package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@SpringBootApplication
@RestController
@RefreshScope
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

	@RequestMapping("/ssm/long")
	public Flux<String> ssmLong() {
		LOGGER.info("ssmLong() called");
		return Flux.range(0, 60)
				.delayElements(Duration.ofSeconds(1L))
				.map((neverUsed) -> this.ssmHello + "\n");
	}

	@RequestMapping("/asm")
	public String asm() {
		LOGGER.info("asm() called");
		return this.asmHello;
	}

	@RequestMapping("/asm/long")
	public Flux<String> asmLong() {
		LOGGER.info("asmLong() called");
		return Flux.range(0, 60)
				.delayElements(Duration.ofSeconds(1L))
				.map((neverUsed) -> this.asmHello + "\n");
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoAwspringConfigClientApplication.class, args);
	}

}
