package com.ssafy.person.test;

public class Person_HR {
	String name;
	int age;
	static int totalCount;
	
	static {
		System.out.println("Program Start");
	}
	
	{
		System.out.println("당신은 " + ++totalCount + "번째 사람입니다.");
	}
	
	Person_HR(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	Person_HR(String name) {
		this(name, 1);
	}
	Person_HR() {
		this("김싸피", 1);
	}
	
	String getInfo() {
		return "이름 : " + name + ", 나이 : " + age;
	}
}
