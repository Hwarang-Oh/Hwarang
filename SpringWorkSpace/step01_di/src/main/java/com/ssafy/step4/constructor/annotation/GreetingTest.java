package com.ssafy.step4.constructor.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans4.xml");
		GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
		greetingService.sayHello("소수빈");
	}

}
