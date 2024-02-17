package com.ssafy.person.test;

public class PersonTest {

	// 이름(name), 나이(age)정보와 그 정보를 하나의 문자열로 반환해주는 메소드(getInfo)를 갖고 있는 Person 클래스 하나를 정의하자.
	// 다양한 객체 생성을 지원하기 위해 생성자 오버로딩을 적용하자! ( 아무정보 없이, 이름/나이 이용, 이름만 )
	//  : 초기값이 지정되지 않은 경우 이름은 김싸피, 나이는 1살로 초기화하자!
	// 	: 객체 초기화 로직을 재사용하는 설계할것!
	
	// 사람객체를 생성할때마다 총 몇명의 사람이 만들어졌는지 알수 있도록 해보자
	// 또한, 사람들이 생성될때마다 자신이 몇번째로 생성되었는지 알수 있도록 하자
	
	public static void main(String[] args) {
		// 2명의 사람 객체를 만들어 각 사람의 정보를 출력해보자!
		
		System.out.println(Person_HR.totalCount);
		Person_HR p1 = new Person_HR("김경호");
		System.out.println(Person_HR.totalCount);
		Person_HR p2 = new Person_HR("소수빈",27);
		System.out.println(p1.getInfo());
		System.out.println(p2.getInfo());
	}
}





