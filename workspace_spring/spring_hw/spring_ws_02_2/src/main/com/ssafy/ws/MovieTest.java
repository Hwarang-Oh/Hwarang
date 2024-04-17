package main.com.ssafy.ws;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = context.getBean("audience", Audience.class);
		try {
			person.watch("예외");
		} catch (CallException e) {
		}
	}
}
