package com.ssafy.step3.setter.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
		GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
		greetingService.sayHello("오화랑");
	}
}
// Resources는 Class 파일이 있는 위치로 그대로 복사되어 있기에, Class Path라 함
// ClassPath 내에서 찾아내는 친구 
