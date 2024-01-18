package com.ssafy.day3.a_inheritance;

public class Person {
	String name;
	final String bloodType;
	
	public Person(String name) { // 이걸 해버려서, SpiderMan의 생성자가 영향이 있음. 
		super(); // 항상 생략되어 있는, this(); super(); 없으면 super(); 삽입해줌.
		bloodType = "B";
		this.name = name;
	}
	
	@Deprecated // 없어질 수도 있음. ( 언제가는 없어질 수도 있음 )
	void eat() { // 먹는게 싫다고 없애나? -> 재사용성 떨어지고, 오류 가능성 많아짐.
		System.out.println("냠냠");
	}
	void jump() {
		System.out.println("폴짝");
	}
}
