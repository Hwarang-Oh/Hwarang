package com.ssafy.day1.a_basic;

public class Lang_03 {
    public static void main(String[] args) {
        int i1 = Integer.MAX_VALUE;
        int i2 = i1 + 1;
        System.out.println(i2);

        long l1 = i1 + 1;
        System.out.println(l1);

        long l2 = (long) (i1 + 1);
        System.out.println(l2);

        long l3 = (long) i1 + 1;
        System.out.println(l3);

        int i3 = 1000000 * 1000000 / 100000;
        int i4 = 1000000 / 100000 * 100000;
        System.out.println(i3 + " : " + i4);
        
        int x = 8;
        int y = 8 >> 9 % 2 / 3 * 2 == 2 ? 0 : 1;  
        System.out.println(8 >> 1 / 6);
    }
}
