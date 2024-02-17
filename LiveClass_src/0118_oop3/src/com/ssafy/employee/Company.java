package com.ssafy.employee;

// Eager Initialization
public class Company {
	
//	Employee[] employees;
	
	
	private Company() {}
	private static final Company instance;
	
	static {
		instance = new Company();
	}
	
	public static Company getInstance() {
		return instance;
	}


	public void increaseSalary(Employee e) {
		System.out.println("연봉 인상 전 정보 : "+e.toString()); // Object
		e.setSalary((int)(e.getSalary()*1.1)); // Employee
		System.out.println("연봉 인상 후 정보 : "+e.toString());
	}
}
