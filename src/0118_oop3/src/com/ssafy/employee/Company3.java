package com.ssafy.employee;

// Double-checked locking 
public class Company3 {
	
//	Employee[] employees;
	
	
	private Company3() {}
	private static Company3 instance;

	
	public static Company3 getInstance() {
		if(instance==null) {
			synchronized (Company3.class) {
				if (instance == null) {
					instance = new Company3();
				}
			}
		}
		return instance;
	}


	public void increaseSalary(Employee e) {
		System.out.println("연봉 인상 전 정보 : "+e.toString()); // Object
		e.setSalary((int)(e.getSalary()*1.1)); // Employee
		System.out.println("연봉 인상 후 정보 : "+e.toString());
	}
}
