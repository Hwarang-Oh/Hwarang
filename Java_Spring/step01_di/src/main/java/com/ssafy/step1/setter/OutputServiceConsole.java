package com.ssafy.step1.setter;

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
