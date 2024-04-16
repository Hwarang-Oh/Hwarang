package com.ssafy.step6.javaconf2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan({"com.ssafy.step6"})
@Configuration
public class GreetingConfig {

	@Bean
//	public GreetingService greetingService(@Qualifier("console") OutputService outputter) {
	public GreetingService greetingService(OutputService outputter) {
		return new GreetingServiceImpl(outputter);
	}

}
