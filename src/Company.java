
public class Company {
	
	private Company() {}
	private static final Company instance = new Company();
	static {
		instance = new Company();
		// 예외처리가 가능하긴 함.
	}
	public static Company getInstance() {
		return instance;
	}


	public void increaseSalary(Employee e) { // 받을 수 있는 매개변수의 특성은 Emplyoee
		System.out.println("연봉 인상 전 정보 : " + e.toString());
		e.setSalary(e.getSalary() + (int)(e.getSalary()*0.1));
		System.out.println("연봉 인상 후 정보 : " + e.toString());
	}
}

// Singletone -> 클래스의 객체를 1개를 만들고자 하는... Design Pattern => Spring FrameWork 
// Eager Initialization => 열심히 초기화한다. 내부적으로 인스턴스를 1번만 만들어서 Reference를 계속 준다. 
