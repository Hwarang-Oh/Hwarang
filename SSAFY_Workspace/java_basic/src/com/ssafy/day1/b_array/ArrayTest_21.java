package com.ssafy.day1.b_array;

public class ArrayTest_21 {
    private static int R = 4, C = 5;
    private static char[][] map;
    private static StringBuilder output = new StringBuilder();

    private static void setup() {
        map = new char[R][C];
        // TODO: 위 배열을 알파벳 대문자 A ~ T로 초기화 하시오.

        // END
    }

    public static void main(String[] args) {
        setup();
        //rowFirst();
        //colFirst();
        //zigzag();
       snail();
    }

    private static void rowFirst() {
        // TODO: 행우선 탐색을 작성하시오.

        // END
        System.out.println(output.toString().equals("ABCDEFGHIJKLMNOPQRST"));
    }

    private static void colFirst() {
        // TODO: 열우선 탐색을 작성하시오.

        // END
        System.out.println(output.toString().equals("AFKPBGLQCHMRDINSEJOT"));
    }

    private static void zigzag() {
        // TODO: zigzag 탐색을 작성하시오.

        // END
        System.out.println(output.toString().equals("ABCDEJIHGFKLMNOTSRQP"));
    }
    
    private static void snail() {
     // TODO: 달팽이 탐색을 작성하시오.

        // END
        System.out.println(output.toString().equals("ABCDEJOTSRQPKFGHINML"));
    }
    
    private static boolean isIn(int r, int c) {
        return 0<=r && r<R && 0<=c && c<C;
    }
    
}
