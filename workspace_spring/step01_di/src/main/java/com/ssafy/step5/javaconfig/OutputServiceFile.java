package com.ssafy.step5.javaconfig;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputServiceFile implements OutputService {

    public OutputServiceFile() {
        System.out.println("OutputServiceFile()...");
    }

    @Override
    public void output(String msg) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter("msg.txt", true))) {
            out.println(msg);
        }
    }
}