package com.ssafy.step2.constructor;

import java.io.IOException;

public class GreetingServiceImpl implements GreetingService {

    private OutputService outputter;

    public GreetingServiceImpl(OutputService outputter) {
        System.out.println("GreetingServiceImpl(OutputService Outputter)...");
        this.outputter = outputter;
    }

    @Override
    public void sayHello(String name) {
        try {
            outputter.output("Hello " + name);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
