package com.ssafy.generic;

public class Dog extends Animal {

	Dog(String name){
		super(name);
	}
	Dog(){
		this("강아지");
	}
	void wagTail() {
		System.out.println(name+"이 꼬리를 흔들다.");
	}
	@Override
	void speak() {
		System.out.println(name+"는 멍멍");
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}


	
}
