package com.ssafy.step3.setter.autowire;

import java.io.IOException;

public class OutputServiceConsole implements OutputService {
	
	public OutputServiceConsole() {
		System.out.println("WoWWoW");
	}

	@Override
	public void output(String message) {
		System.out.println(message);
	}

}
