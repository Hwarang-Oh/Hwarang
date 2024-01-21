package com.SSAFY_1.day3.a_inheritance;

public class Person {
    String name;
    final String bloodType; // default 초기화만 되버림.
    public Person() {
        this("오화랑");
    }
    public Person (String name) {
        // super(); -> Object의 생성자를 거치고 옴
        this.name = name;
        bloodType = "B";
    }
    void eat(){
        System.out.println("냠냠");
    }
    public void jump(){
        System.out.println("폴짝");
    }

    @Override
    public String toString() {
        return "사람 이름 : " + this.name;
    }
}
