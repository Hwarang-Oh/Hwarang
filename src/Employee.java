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
		this(name, 1000000000);
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		if (salary <= 0) throw new IllegalArgumentException("연봉은 음수X");
		this.salary = salary;
	}
	
	public String getInfo() {
		return "name : " + name + ", salary : " + salary + "원";
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
	public boolean equals(Object obj) { // 예외를 던지고 싶어도 못던지는 상황 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj; // Type Casting 
		return Objects.equals(name, other.name) && salary == other.salary;
	}
}


// private으로 접근을 막아놔서, 관려된 메소드를 설정해서 접근할 수 있게 설정함.
// 내부 동작을 생각해서, 메소드를 만들어줘야 한다.
