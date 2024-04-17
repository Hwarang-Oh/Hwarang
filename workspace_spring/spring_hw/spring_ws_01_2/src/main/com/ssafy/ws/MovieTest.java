package main.com.ssafy.ws;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Audience audience = context.getBean("audience", Audience.class);
		audience.watch();
	}
}
