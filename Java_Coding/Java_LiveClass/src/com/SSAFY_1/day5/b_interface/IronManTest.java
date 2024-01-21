package com.SSAFY_1.day5.b_interface;

public class IronManTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IronMan iman = new IronMan();
		Object obj = iman; // class 참조

		Fightable f = iman; // interface 참조
		Transformable t = iman;
		Heroable h = iman;
	}
}

// 일반 메서드를 가질 수 있나요? -> 기본적인 Interface는 일반 Method 사용 불가 ( default, static은 제외 )
// 상속의 비용이 드나요? -> extends라는 비용을 쓰는가? ( Abstract class 는 비용) ( Interface는 X )
