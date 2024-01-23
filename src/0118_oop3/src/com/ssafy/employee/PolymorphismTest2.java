package com.ssafy.employee;

public class PolymorphismTest2 {

	public static void main(String[] args) {

//		Company c = new Company();
		Company2 c = Company2.getInstance();
		Company2 c2 = Company2.getInstance();
		System.out.println(c==c2);
		
		Engineer eg = new Engineer("소수빈", 100_000_000, "자바");
		Manager m = new Manager("김태희", 1_000_000_000, "자바");
		
		c.increaseSalary(eg); // Employee e = eg 
		c.increaseSalary(m); // Employee e = m
		
		
	}

}
