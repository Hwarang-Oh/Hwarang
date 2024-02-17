package com.ssafy.employee;

// Lazy Initialization
public class Company2 {
	
//	Employee[] employees;
	
	
	private Company2() {}
	private static Company2 instance;

	
	public static synchronized Company2 getInstance() {
		if(instance==null) {
			instance = new Company2();
		}
		return instance;
	}


	public void increaseSalary(Employee e) {
		System.out.println("연봉 인상 전 정보 : "+e.toString()); // Object
		e.setSalary((int)(e.getSalary()*1.1)); // Employee
		System.out.println("연봉 인상 후 정보 : "+e.toString());
	}
}
