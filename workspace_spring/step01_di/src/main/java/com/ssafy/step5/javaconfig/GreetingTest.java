package com.ssafy.step5.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GreetingTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GreetingConfig.class);
        GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
        greetingService.sayHello("오화랑");
    }
}
