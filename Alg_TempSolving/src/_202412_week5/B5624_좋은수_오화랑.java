package _202412_week5;

import java.io.*;
import java.util.*;

/**
 * IMP : https://www.acmicpc.net/problem/5624
 * IMP : 2024.12.30
 */

/**
 * IMP : 특정 숫자가, 앞에 숫자들의 3번의 합으로 이루어질 수 있는가? => 채택
 * IMP : 같은 수를 3번 더하는 것도 가능하다.
 * Type : 대표적인 Dynamic Programming의 문제 같긴 하다. NP - Hard로 불리는 Disk 용량 맞추는 문제
 */

public class B5624_좋은수_오화랑 {

    static class Solution {
        int N, count;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(input.readLine());

            int current;
            HashSet<Integer> oneHistory = new HashSet<>();
            HashSet<Integer> twoHistory = new HashSet<>();
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < N; i++) {
                current = Integer.parseInt(st.nextToken());

                for (int eachOne : oneHistory) {
                    if (twoHistory.contains(current - eachOne)) {
                        count++;
                        break;
                    }
                }

                if (oneHistory.contains(current))
                    continue;

                oneHistory.add(current);
                for (int eachOne : oneHistory) {
                    if (!twoHistory.contains(current + eachOne))
                        twoHistory.add(current + eachOne);
                }

            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
