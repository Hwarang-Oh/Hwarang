package com.ssafy.day3.a_inheritance;

class Parent2 {
    static void method() {
        System.out.println("parent method");
    }
}

class Child2 extends Parent2 {
    // TODO: Parent2의 메서드를 재정의 해보자.

    // END
}

public class StaticOverride {
    public static void main(String[] args) {
        Child2 child = new Child2();
        child.method();
        // static method는 정적 바인딩 대상이다.
        Parent2 parent = new Child2();
        parent.method();
    }
}
