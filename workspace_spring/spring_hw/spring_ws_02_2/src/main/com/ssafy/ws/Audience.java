package main.com.ssafy.ws;

public class Audience implements Person {
	@Override
	public void watch(String msg) throws CallException {
		System.out.println("영화를 봅니다.");
		// throw new CallException();
	}
}
