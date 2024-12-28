package _202412_week4;

import java.io.*;
import java.util.*;

public class B1332_풀자_오화랑 {

    static class Solution {
        int N, V;
        int[] numberList;
        int minCount;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            minCount = N;
            numberList = new int[N + 1];

            st = new StringTokenizer(input.readLine());
            int low, high, eachValue;
            low = 1000;
            high = 0;
            for (int i = 1; i <= N; i++) {
                eachValue = Integer.parseInt(st.nextToken());
                numberList[i] = eachValue;
                low = Math.min(low, eachValue);
                high = Math.max(high, eachValue);
            }
            if (high - low >= V)
                getNextProblem(1, 1000, 0, 1);
            System.out.println(minCount);
        }

        void getNextProblem(int idx, int min, int max, int count) {
            if (count >= minCount)
                return;

            if (idx > N)
                return;

            min = Math.min(min, numberList[idx]);
            max = Math.max(max, numberList[idx]);

            if (max - min >= V) {
                minCount = Math.min(minCount, count);
                return;
            }

            getNextProblem(idx + 1, min, max, count + 1);
            getNextProblem(idx + 2, min, max, count + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
