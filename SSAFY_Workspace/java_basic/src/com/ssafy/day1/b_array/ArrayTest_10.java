package com.ssafy.day1.b_array;

public class ArrayTest_10 {
    public static void main(String[] args) {
        int[] intArray = { 3, 27, 13, 8, 235, 7, 22, 9, 435, 31, 54 };
        int max = Integer.MIN_VALUE; // 가장 최소를 max로
        int min = Integer.MAX_VALUE; // 가장 최대를 min으로 
        
        for (int num : intArray) {
        	if (num > max) {
        		max = num;
        	}
        	if (num < min) {
        		min = num;
        	}
        }
        System.out.printf("min : %d, max : %d%n", min, max);
        // TODO: int로 구성된 배열에서 최대값과 최소값을 출력하시오.
        // END
    }
}
