package com.ssafy.step2.constructor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
        greetingService.sayHello("오화랑");
    }
}
