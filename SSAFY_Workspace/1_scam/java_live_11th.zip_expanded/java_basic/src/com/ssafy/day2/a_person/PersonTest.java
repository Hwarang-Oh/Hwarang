package com.ssafy.day2.a_person;

public class PersonTest {
	public static void main(String[] args) {
		int a = 10;
		Person p1 = new Person();
		p1.name = "홍길동";
		p1.isHungry = true;
		System.out.println(p1.name + " : " + p1.isHungry);
		p1.eat();
		System.out.println(p1.name + " : " + p1.isHungry);
	
		Person p2 = new Person();
		p2.name = "임꺽정";
		System.out.println(p2.name + " : " + p2.age + " : " + p2.isHungry);
	}
}
