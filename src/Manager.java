
public class Manager extends Employee {
	private String department;

	public Manager(String name, String department) {
		super(name);
		this.department = department;
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, int salary, String department) {
		super(name, salary);
		this.department 
		// TODO Auto-generated constructor stub
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return super.toString() + "Manager [department=" + department + "]";
	}

}
