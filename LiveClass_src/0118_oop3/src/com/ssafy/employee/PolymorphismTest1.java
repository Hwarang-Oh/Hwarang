package com.ssafy.employee;

public class PolymorphismTest1 {

	public static void main(String[] args) {

		Employee e = new Engineer("소수빈", 1_000_000_000, "자바");
		Employee m = new Manager("김태희", 1_000_000_000, "자바");
		System.out.println(e.getInfo());
		System.out.println(m.getInfo());
		
		System.out.println(e); // e.toString()
		System.out.println(m.toString());
		
		
		
		
	}

}
