package com.ssafy.step3.autowire;

import java.io.IOException;

public class GreetingServiceImpl implements GreetingService {

    private OutputService outputter; // 의존 객체를 받을 준비

    public void setOutputter(OutputService outputter) { // Setter DI
        this.outputter = outputter;
    }

    /*
     * constructor Dependency Injection
     * public GreetingServiceImpl(OutputService outputter) {
     * System.out.println("GreetingServiceImpl(OutputService Outputter)...");
     * this.outputter = outputter;
     * }
     */

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
