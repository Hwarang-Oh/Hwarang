package com.ssafy.person.test;

public class Person {
	String name;
	int age;
	int order;
	static int totalCount;
	
	static {
		System.out.println("static initializer......");
	}
	{
		System.out.println("instance initializer....");
	}
	
	Person() {
		this("김싸피",1);
//		this.name = "김싸피";
//		this.age = 1;
	}
	Person(String name){
		this(name,1);
//		this.name = name;
//		this.age = 1;
	}
	Person(String name,int age){
		this.name = name;
		this.age = age;
		order = ++totalCount;
	}
	
	String getInfo() {
		return order+"/"+totalCount+" : "+name+","+age;
	}
}
