package com.ssafy.day6.c_throws;

public class ThrowsTest {
    // TODO: 1. methodCall2()에서 uncheckedExceptionMethod()를 호출할 때 발생하는 예외를
    // throws로 처리하세요.
    // TODO: 2. methodCall2()에서 checkedExceptionMethod()를 호출할 때 발생하는 예외를
    // throws로 처리하세요.
     public static void main(String[] args) {
        try {
			methodCall1();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
        System.out.println("done");
    }

     private static void methodCall1() throws ClassNotFoundException {
        methodCall2();
    }

     private static void methodCall2() throws ClassNotFoundException {
//        uncheckedExceptionMethod();
         checkedExceptionMethod();
    }

    @SuppressWarnings("unused")
     private static void checkedExceptionMethod() throws ClassNotFoundException {
        Class.forName("Hello"); // 처리 방법 2가지 -> try ~ catch or throws
    }

    @SuppressWarnings("unused")
    private static void uncheckedExceptionMethod() {
        int i = 1 / 0;
    }
}
// result : 계속 넘기면, 결국 Compile도 안되고 JDK 선에서 오류가 나옴.
