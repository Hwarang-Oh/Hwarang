
public class PolymorphismTest1 {

	public static void main(String[] args) {
		
		Employee e = new Engineer("오화랑", 1_000_000_000, "Java");
		Employee e2 = new Manager("오화랑", 1_000_000_000);
		System.out.println(e.getInfo());
		System.out.println(e2.getInfo());
		
		System.out.println(e.toString()); // e.toString()
		System.out.println(e2.toString());
	}
}
// '==' 왜 Object는 이런것만 가지고 있을까? -> Object Class는 하위에 어떤게 나올지 모르기 때문에 참조값 비교만 가능하다.
// String.equals - Object.equals - Employ.equals() => 모두 역할이 다름.
// Hashing => 비정형화된 데이터를 정형화된 데이터로 바꾸는 것이 해싱 
// 해시테이블을 이용해서 -> 객체가 가지고 있는 값을 이용해서 해시코드를 만듬.
// Hashcode -> 이것도 재정의하는 것도 매우 좋다. (int형)
// Collection API -> Set에서 유효성을 체크할 때 hashcode와 equals 모두 
// equals를 재정의할 때는 Hashcode도 함께 재정의하라는 것이 권고사항
// 
