package com.ssafy.step1.aop.xml;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
		System.out.println(greetingService.getClass().getName());
		System.out.println(Arrays.toString(greetingService.getClass().getMethods()));
		greetingService.sayHello("소수빈");
		greetingService.sayGoodBye("소수빈");
		greetingService.smile();
	}
}
