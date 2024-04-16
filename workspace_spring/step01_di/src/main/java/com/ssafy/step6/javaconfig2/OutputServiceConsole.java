package com.ssafy.step6.javaconfig2;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("console")
@Service("outputter")
public class OutputServiceConsole implements OutputService {

    public OutputServiceConsole() {
        System.out.println("OutputServiceConsole()...");
    }

    @Override
    public void output(String msg) throws IOException {
        System.out.println(msg);
    }

}