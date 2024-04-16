package com.ssafy.step5.javaconf;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Service;

public class OutputServiceFile implements OutputService {

	@Override
	public void output(String msg) throws IOException {
		try (PrintWriter out = new PrintWriter(new FileWriter("msg.txt", true))) {
			out.println(msg);
		}
	}

}
