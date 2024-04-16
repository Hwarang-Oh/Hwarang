package com.ssafy.step6.javaconf2;

import java.io.FileWriter;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("outputterFile")
public class OutputServiceFile implements OutputService {

	@Override
	public void output(String msg) throws IOException {
		try (PrintWriter out = new PrintWriter(new FileWriter("msg.txt", true))) {
			out.println(msg);
		}
	}

}
