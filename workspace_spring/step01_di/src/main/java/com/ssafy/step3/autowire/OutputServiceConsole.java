package com.ssafy.step3.autowire;

import java.io.IOException;

public class OutputServiceConsole implements OutputService {

    public OutputServiceConsole() {
        System.out.println("OutputServiceConsole()...");
    }

    @Override
    public void output(String msg) throws IOException {
        System.out.println(msg);
    }

}