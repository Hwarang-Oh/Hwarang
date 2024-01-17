package com.ssafy.day2.a_person;

public class Person {
	String name;
	int age;
	boolean isHungry;

	public void eat() {
		isHungry = false;
	}
	public void work() {
		isHungry = true;
	}
}