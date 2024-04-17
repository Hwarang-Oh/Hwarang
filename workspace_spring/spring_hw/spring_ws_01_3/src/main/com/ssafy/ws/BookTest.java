package main.com.ssafy.ws;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Reader reader = context.getBean("reader", Reader.class);
		reader.Read();
	}
}
