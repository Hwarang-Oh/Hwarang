
public class Company4 {
	private static class CompanyHolder {
		private static final Company4 instance = new Company4();
	}
	
	private Company4() {}
	public static Company4 getInstance() {
		return CompanyHolder.instance;
	}
	


	public void increaseSalary(Employee e) { // 받을 수 있는 매개변수의 특성은 Emplyoee
		System.out.println("연봉 인상 전 정보 : " + e.toString());
		e.setSalary(e.getSalary() + (int)(e.getSalary()*0.1));
		System.out.println("연봉 인상 후 정보 : " + e.toString());
	}
}
// lazy Holder : 이르게 하지도 않고, 동기화도 해결한 버전
// Singletone 모두 Reflection API의 억까는 버틸수 없긴 함. 