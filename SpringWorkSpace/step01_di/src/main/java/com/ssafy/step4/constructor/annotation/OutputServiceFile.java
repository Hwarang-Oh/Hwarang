package com.ssafy.step4.constructor.annotation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Service;

@Service("outputter")
public class OutputServiceFile implements OutputService {

	@Override
	public void output(String msg) throws IOException {
		try (PrintWriter out = new PrintWriter(new FileWriter("msg.txt", true))) {
			out.println(msg);
		}
	}

}
