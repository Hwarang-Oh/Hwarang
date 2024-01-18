package com.ssafy.day1.b_array;

public class ArrayTest_08 {
    public static void main(String[] args) {
        String[] students = { "홍길동", "임꺽정", "장길산", "이몽룡" };
        String temp = students[1];
        students[1] = students[2];
        students[2] = temp;
        
        for (String student : students) {
        	System.out.println(student);
        }
    }
}
