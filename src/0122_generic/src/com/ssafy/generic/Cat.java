package com.ssafy.generic;

public class Cat extends Animal {

	Cat(String name){
		super(name);
	}
	Cat(){
		this("고양이");
	}
	void washFace() {
		System.out.println(name+"이(가) 세수해요~");
	}
	@Override
	void speak() {
		System.out.println(name+"는 야옹야옹");
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + "]";
	}
}
