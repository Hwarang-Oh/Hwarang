package com.ssafy.day4.d_object;

public class EqualsTest {

    public static void main(String[] args) {
        Integer [] is = {1, 1, 128, 128};

        for(int i=0; i<is.length; i+=2) {
            System.out.printf("%d, ==? %b, equals? %b%n", i, is[i]==is[i+1], is[i].equals(is[i+1]));
        }
    }
}
