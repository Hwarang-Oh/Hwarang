package com.ssafy.day1.a_basic;

public class Lang_04 {

    public static void main(String[] args) {
        byte b1 = 10;
        byte b2 = 20;
        // byte b3 = b1 + b2;
        byte b3 = (byte) (b1 + b2);

        int i1 = 10;
        long l1 = 20;
        //int i2 = i1 + l1;
        long i2 = i1 + l1;
        int i3 = i1 + (int) l1;

        // float f1 = 10.0;
        // float f2 = f1 + 20.0;
        float f1 = 10.0f;
        float f2 = f1 + 20.0f;
    }
}
