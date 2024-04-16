package com.ssafy.step4.constructor.annotation;

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