package com.ssafy.step5.javaconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingConfig {

	@Bean
	public GreetingService greetingService() {
		return new GreetingServiceImpl(outputter());
	}
	@Bean
	public OutputService outputter() {
//		return new OutputServiceFile();
		return new OutputServiceConsole();
	}
}
