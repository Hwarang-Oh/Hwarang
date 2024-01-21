package com.SSAFY_1.day2.c_constructor;

public class SmartPhone {
    static String osName = "iOS"; // Static변수 객체 선언과 무관하게 Heap에 메모리 생성
    String number;

    void call(String to) {// 파라미터 변수
        String msg = "띠";// 로컬 변수
        for (int i = 0; i < 3; i++) {// 로컬 변수
            System.out.println(msg);
        }
    }
}
