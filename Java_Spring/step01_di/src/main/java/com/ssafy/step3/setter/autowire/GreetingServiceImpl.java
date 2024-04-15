package com.ssafy.step3.setter.autowire;

import java.io.IOException;

public class GreetingServiceImpl implements GreetingService {

	private OutputService outputter;
	public void setOutputter(OutputService outputter) {
		this.outputter = outputter;
	}
	
	
	
	public GreetingServiceImpl() {
		System.out.println("WoW!!");
	}


	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		try {
			outputter.output("Hello" + name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
