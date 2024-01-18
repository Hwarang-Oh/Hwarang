
public class Company2 {
	
	private Company2() {}
	private static Company2 instance = new Company2();

	public static synchronized Company2 getInstance() { // 점유 / 대기가 원활함. by //synchronized
		if(instance == null) { // 메
			instance = new Company2();
		}
		return instance;
	} // 멀티스레딩 환경이 아니면 이 코드는 적절하다.


	public void increaseSalary(Employee e) { // 받을 수 있는 매개변수의 특성은 Emplyoee
		System.out.println("연봉 인상 전 정보 : " + e.toString());
		e.setSalary(e.getSalary() + (int)(e.getSalary()*0.1));
		System.out.println("연봉 인상 후 정보 : " + e.toString());
	}
}

// Singletone -> 클래스의 객체를 1개를 만들고자 하는... Design Pattern => Spring FrameWork 
// lazy Initialization 
