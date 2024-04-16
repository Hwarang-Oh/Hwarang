package com.ssafy.step3.setter.autowire;

import java.io.IOException;

public class GreetingServiceImpl implements GreetingService {

	private OutputService outputter; // 의존객체
	public void setOutputter(OutputService outputter) { // setter DI
		this.outputter = outputter;
	}
	public GreetingServiceImpl() {
		System.out.println("GreetingServiceImpl()...");
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
