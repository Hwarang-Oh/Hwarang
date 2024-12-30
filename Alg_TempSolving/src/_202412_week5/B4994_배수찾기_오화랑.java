package _202412_week5;

import java.io.*;
import java.util.*;

/**
 * IMP : https://www.acmicpc.net/problem/4994
 * IMP : 2024.12.30
 * Type : 정확하게 Naive하게 푸는 문제는 아닌 것 같다.
 * Type : 아마 더 제대로 된 방법은 존재할 것 같음 => 상태를 관리하면서 나머지가 0이될 때를 체크해야 함.
 */

public class B4994_배수찾기_오화랑 {
    static class OtherSolution {
        void run() throws IOException {
            Scanner sc = new Scanner(System.in);
            String
        }
    }

    static class Solution {
        void run() throws IOException {
            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();

            int target;
            Queue<Long> numberList;
            while (true) {
                target = sc.nextInt();
                if (target == 0)
                    break;

                numberList = new ArrayDeque<>();
                numberList.offer(1L);
                while (!numberList.isEmpty()) {
                    long current = numberList.poll();

                    current *= 10;
                    if (current % target == 0) {
                        sb.append(current).append("\n");
                        break;
                    }

                    numberList.offer(current);

                    current += 1;
                    if (current % target == 0) {
                        sb.append(current).append("\n");
                        break;
                    }
                    numberList.offer(current);
                }
            }
            System.out.print(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
