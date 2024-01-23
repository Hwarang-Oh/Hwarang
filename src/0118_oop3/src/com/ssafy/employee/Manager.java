package com.ssafy.employee;

public class Manager extends  Employee{

	private String department;

	public Manager(String name, int salary, String department) {
		super(name, salary);
		this.department = department;
	}

	public Manager(String name, String department) {
		super(name);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
}
