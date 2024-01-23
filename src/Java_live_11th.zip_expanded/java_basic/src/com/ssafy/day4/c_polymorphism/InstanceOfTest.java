package com.ssafy.day4.c_polymorphism;

import com.ssafy.day3.a_inheritance.person.Person;
import com.ssafy.day3.a_inheritance.person.SpiderMan;

public class InstanceOfTest {
    private void unsafeCasting() {
        Object obj = 1;
        String s = (String) obj;
        System.out.println(s.length());
    }

    private void safeCasting() {
        // TODO: 위 메서드가 안전하게 형 변환할 수 있도록 수정해보자.

        // END
    }

    public static void main(String[] args) {
        InstanceOfTest instance = new InstanceOfTest();
        instance.unsafeCasting();
        instance.safeCasting();
    }

}
