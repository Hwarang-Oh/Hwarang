package com.ssafy.step6.javaconf2;

import java.io.IOException;


public class GreetingServiceImpl implements GreetingService {

	private OutputService outputter; // 의존객체

//	@Autowired
	public GreetingServiceImpl(OutputService outputter) { // 생성자 DI
		System.out.println("GreetingServiceImpl(OutputService outputter)...");
		this.outputter = outputter;
	}
	@Override
	public void sayHello(String name) {
		try {
			outputter.output("Hello "+name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
