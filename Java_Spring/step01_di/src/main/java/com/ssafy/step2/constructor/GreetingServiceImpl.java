package com.ssafy.step2.constructor;

import java.io.IOException;

public class GreetingServiceImpl implements GreetingService {

	private OutputService outputter;
	
	public void setOutputter(OutputService outputter) { // 생성자 DI
		System.out.println("WOWWOWWOW");
		this.outputter = outputter;
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
