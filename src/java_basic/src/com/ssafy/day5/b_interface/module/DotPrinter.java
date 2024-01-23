package com.ssafy.day5.b_interface.module;

public class DotPrinter implements Printer {

    @Override
    public void print(String fileName) {
        System.out.println("Dot Printer로 프린트 한다.");
    }

}
