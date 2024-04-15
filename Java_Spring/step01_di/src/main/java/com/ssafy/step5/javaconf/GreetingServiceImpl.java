package com.ssafy.step5.javaconf;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// @Component
@Service("greetingService") // 설정하는 과정이 대폭 줄어듬
public class GreetingServiceImpl implements GreetingService {

	private OutputService outputter;
	
	@Autowired // byType byName 정보 모두 가지고 있음. => 생성자가 1개면, Autowired를 생략할 수 있다. 
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
