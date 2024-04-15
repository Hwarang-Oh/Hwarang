package com.ssafy.step5.javaconf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans4.xml");
		// 이제 더이상 XML에서 설정을 하지 않는다.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GreetingConfig.class);
		// Application Context 유형
		GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
		greetingService.sayHello("오화랑");
	}
}
// Resources는 Class 파일이 있는 위치로 그대로 복사되어 있기에, Class Path라 함
// ClassPath 내에서 찾아내는 친구 
