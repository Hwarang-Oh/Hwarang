package com.ssafy.lambda;

import java.util.ArrayList;

public class CollectionLambdaTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1 ; i <= 10 ; ++i) list.add(i);
//		list.forEach((e) -> {System.out.println(e);}); // Consumer Interface3
//		list.forEach(e -> System.out.println(e)); // Consumer Interface3
		// Lambda에서 하나의 문장에서  하나의 매개변수를 참조하는 형태 => 메서트 참조로 표현할 수 있음.  
		list.forEach(System.out::println); // Consumer Interface3
		
		list.removeIf(e -> e%2 == 0); // 지우는 조건에 대한 구현을 넘겨줘야 한다. Predicate =>
		// 자동 리턴의 조건 
		
		list.forEach(System.out::println); // Consumer Interface3
		// 하나씩하나씩 바꿔서 -> UnaryOperator<T> extends Function<T, T> => 범용적인 function Interface를 더 제한시킴. T to T
		list.replaceAll(e -> e + 10); 
		list.forEach(System.out::println);
		
	}

}



//ArrayList<? extends Cat> list = new ArrayList<Cat>();
//ArrayList<? extends Cat> list = new ArrayList<Tiger>(); -> 이거 때문에, cat을 추가하는 그런 코드는 안됨. 
//list.add(new Cat())

//ArrayList<? super Cat> list2 = null;
//list2.add(new Cat()) => 내보내고 저장의 목적 Out 으로 가능 
