package com.ssafy.employee;

// Lazy Holder
public class Company4 {
	
//	Employee[] employees;
	
	private static class CompanyHolder{
		private static final Company4 instance = new Company4();		
	}	
	private Company4() {}
	
	public static Company4 getInstance() {
		return CompanyHolder.instance;
	}


	public void increaseSalary(Employee e) {
		System.out.println("연봉 인상 전 정보 : "+e.toString()); // Object
		e.setSalary((int)(e.getSalary()*1.1)); // Employee
		System.out.println("연봉 인상 후 정보 : "+e.toString());
	}
	
	public static void xxxx() {
		
	}
	
}
