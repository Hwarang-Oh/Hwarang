package com.ssafy.person.test;

public class JavaThisQuiz {

	public static void main(String[] args) {
		A a1 = new B(); // B 객체가 A type 참조 변수 a1에 담겨 있음.
		a1.run(); // a1 -> run();
		a1.test(); // a1 -> test(); 
	}	
}

class A {
	void test() {
		this.run();
	}
	
	void run() {
		System.out.println("A is Run");
	}
}

class B extends A {
	void run() {
		System.out.println("SSAFY");
	}
}
