package com.ssafy.step5.javaconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 나는 설정파일이다! 
public class GreetingConfig {
	
	@Bean
	public GreetingService greetingService() {
		return new GreetingServiceImpl(outputter());
	}
	
	@Bean // 이 Method를 실행하고 난 결과물을 Bean에 등록하고, 그 객체의 이름은 Method의 이름은 outputter!
	public OutputService outputter() {
		return new OutputServiceFile();
	}
}