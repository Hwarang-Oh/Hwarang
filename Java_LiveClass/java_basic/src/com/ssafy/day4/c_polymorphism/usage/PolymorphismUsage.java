package com.ssafy.day4.c_polymorphism.usage;

import com.ssafy.day3.a_inheritance.person.Person;
import com.ssafy.day3.a_inheritance.person.SpiderMan;

public class PolymorphismUsage {
    public void useObjectArray() {
        // TODO:Object []을 선언하고 다양한 객체를 저장하고 저장된 클래스 타입을 출력하세요.

        // END
    }

    public void useObjectParam() {
        System.out.println(1);
        System.out.println("Hello");
        System.out.println(new Person());
        System.out.println(new SpiderMan());
    }

    public static void main(String[] args) {
        PolymorphismUsage usage = new PolymorphismUsage();
        usage.useObjectArray();
        usage.useObjectParam();
    }
}
