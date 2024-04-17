package main.com.ssafy.ws;

import org.aspectj.lang.JoinPoint;

public class MovieAspect {

	public void Before(JoinPoint joinPoint) {
		System.out.println("영화관을 갑니다");
	}

	public void After_Return(JoinPoint joinPoint) {
		System.out.println("영화가 끝나고 나옵니다");
	}

	public void After_Throw(JoinPoint joinPoint) {
		System.out.println("전화를 받습니다.");
	}

	public void After(JoinPoint joinPoint) {
		System.out.println("집에 갑니다");
	}
}
