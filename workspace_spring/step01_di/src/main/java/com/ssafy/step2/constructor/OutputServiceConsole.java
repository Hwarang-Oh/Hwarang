package com.ssafy.step2.constructor;

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