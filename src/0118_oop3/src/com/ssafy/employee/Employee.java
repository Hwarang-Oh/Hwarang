package com.ssafy.employee;

import java.util.Objects;

public class Employee {

	private String name;
	private int salary;
	
	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public Employee(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
//		if(salary<=0) return;
		if(salary<=0) throw new IllegalArgumentException("연봉은 음수일수 없습니다.");
		this.salary = salary;
	}
	
	public String getInfo() {
		return "name:"+name+",salary:"+salary+"원";
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name) && salary == other.salary;
	}
}







