package com.ssafy.day1.b_array;

public class ArrayTest_09 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int[] scores = { 90, 80, 100 };

        // TODO: 95점을 추가로 관리하기 부적절한 코드는?
        // scores[3] = 95; // #1 => 부적절 

        // scores = new int[] {90, 80, 100, 95}; // #2 => 재할당

        // scores = {90, 80,100, 95 }; // #3 => 부적절 ( -> new int[] {} )

        // scores = Arrays.copyOf(scores, 5); // #4 ( -> 5개의 배열로 Copy )
        // scores[3]=95;

        // int[] scores2 = new int[4]; // #5 
        // System.arraycopy(scores, 0, scores2, 0, scores.length);
        // scores2[3] = 95;

    }
}
