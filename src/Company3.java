public class Company3 {
	
	private Company3() {}
	private static Company3 instance = new Company3();

	public static Company3 getInstance() { // 점유 / 대기가 원활함. by //synchronized
		if(instance == null) { // OverHead는 적절하다 -> null일때만, double Checking이 일어나기 때문이다. 
			synchronized (instance) {
				if (instance == null) {
					instance = new Company3();
				}
			}
		}
		return instance;
	} // 멀티스레딩 환경이 아니면 이 코드는 적절하다.


	public void increaseSalary(Employee e) { // 받을 수 있는 매개변수의 특성은 Emplyoee
		System.out.println("연봉 인상 전 정보 : " + e.toString());
		e.setSalary(e.getSalary() + (int)(e.getSalary()*0.1));
		System.out.println("연봉 인상 후 정보 : " + e.toString());
	}
}
// doubleChecked Rocking

