package com.ssafy.generic;

public class Animal {

	String name;
	
	Animal(String name){
		this.name = name;
	}
	Animal(){
		this("동물");
	}
	void speak(){
		System.out.println(name+"이 짖습니다.");
	}
	void play() {
		System.out.println("play...");
	}
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
	
}
