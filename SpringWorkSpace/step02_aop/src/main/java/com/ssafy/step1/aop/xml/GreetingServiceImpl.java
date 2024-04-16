package com.ssafy.step1.aop.xml;

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
		System.out.println("Big SMile");
	}
}
