package com.ssafy.step1.setter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
		greetingService.sayHello("소수빈");
	}

}
