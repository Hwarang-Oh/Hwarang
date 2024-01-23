package com.ssafy.lambda;

public class LambdaBasicTest {
	public static void main(String[] args) {
		
		System.out.println("main start.....");
		
		new Thread(new Runnable() { // 람다화 가능 

			@Override
			public void run() {
				for(int i = 1 ; i < 10 ; ++i) {
					System.out.println(i);
				}
				// TODO Auto-generated method stub
			}
		}).start(); // Thread() -> 일꾼 // th
		
		// 람다화 가능 -> 메소드 하나만 표현 
		new Thread( () -> {
				for(int i = 11 ; i < 20 ; ++i) {
					System.out.println(i);
				}
				// TODO Auto-generated method stub
		}).start(); // Thread() -> 일꾼 // th
		
		
		
		
		System.out.println("main end....");
	}
}