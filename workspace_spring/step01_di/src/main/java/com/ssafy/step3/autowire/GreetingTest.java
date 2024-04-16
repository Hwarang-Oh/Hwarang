package com.ssafy.step3.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
        GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
        greetingService.sayHello("오화랑");
    }
}
