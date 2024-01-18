package com.ssafy.day1.a_basic;

public class Lang_05 {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        System.out.println((a > b) & (b > 0)); // false

        System.out.println((a += 10) > 15 | (b -= 10) > 15); // true
        System.out.println("a = " + a + ", b = " + b); // a -> 20, b -> 10

        a = 10;
        b = 20;
        System.out.println((a += 10) > 15 || (b -= 10) > 15); // true
        System.out.println("a = " + a + ", b = " + b); // a -> 20. b -> 20
    }
}
