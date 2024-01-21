package com.SSAFY_1.day4.c_polymorphism;

import com.SSAFY_1.day3.a_inheritance.Person;
import com.SSAFY_1.day3.a_inheritance.SpiderMan;

public class PolyTest {
    public static void main(String[] args) {
        SpiderMan sman = new SpiderMan();
        Person p = sman;
        Object o = sman;
    }
}
