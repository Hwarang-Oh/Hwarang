package com.SSAFY_1.day2.a_person;

public class Person {
    // 객체의 속성, 데이터
    String name;
    int age;
    boolean isHungry;

    public Person() {
        this("익명", 30, true);
    }
    public Person(String name , int age, boolean isHungry) { //  파라미터 생성자
        this.name = name;
        this.age = age;
        this.isHungry = isHungry;
    }
    public void eat(){
        isHungry = false;
    }
    public void work(){
        isHungry = true;
    }
    public void printInfo() {
        System.out.println("name : " + name +
                "\tage : " + age +
                "\tisHungry : " + isHungry);
    }
}
