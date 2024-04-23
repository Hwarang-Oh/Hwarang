package com.ssafy.step2.aop.annotation;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
		System.out.println(greetingService.getClass().getName());
		System.out.println(Arrays.toString(greetingService.getClass().getMethods()));
		greetingService.sayHello("카리나");
		greetingService.sayGoodBye("카리나");
		greetingService.smile();
	}
}
