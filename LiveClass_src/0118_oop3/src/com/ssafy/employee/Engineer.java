package com.ssafy.employee;

public class Engineer extends Employee {

	private String skill;

	public Engineer(String name, int salary, String skill) {
		super(name, salary);
		this.skill = skill;
	}

	public Engineer(String name, String skill) {
		super(name);
		this.skill = skill;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		if(skill == null) return;
		this.skill = skill;
	}
	
	public String getInfo() {
//		return "name:"+getName()+",salary:"+getSalary()+"원,skill:"+skill;
		return super.getInfo()+",skill:"+skill;
	}

	@Override
	public String toString() {
		return "Engineer [skill=" + skill + ", toString()="
					+ super.toString() + "]";
	}
	
	
}







