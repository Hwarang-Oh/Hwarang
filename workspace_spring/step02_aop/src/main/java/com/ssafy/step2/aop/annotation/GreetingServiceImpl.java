package com.ssafy.step2.aop.annotation;

import org.springframework.stereotype.Service;

@Service("greetingService")
public class GreetingServiceImpl implements GreetingService {

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("Hello" + name);
	}

	@Override
	public void sayGoodBye(String name) {
		// TODO Auto-generated method stub
		System.out.println("goodBye" + name);
	}

	@Override
	public void smile() {
		// TODO Auto-generated method stub
		System.out.println("Let's smile ^____^");
	}
}
