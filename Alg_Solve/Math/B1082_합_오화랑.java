import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1081
 * Main
 * L <= x <= U보다 작거나 같은 모든 정수의 각 자리의 합을 구한느 Programm
 * 두 정수 L과 U가 주어진다.
 * 0 <= L <= U <= 2_000_000_000
 */
public class B1082_합_오화랑 {
    static class Solution {
        String L, U;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            this.L = st.nextToken();
            this.U = st.nextToken();
            long result1 = getDigitSum(this.L);
            long result2 = getDigitSum(this.U);
            for (int i = 0; i < this.L.length(); i++)
                result1 -= Character.getNumericValue(this.L.charAt(i));
            System.out.println(result2 - result1);

        }

        long getDigitSum(String target) {
            int len = target.length();
            int frontNum = Character.getNumericValue(target.charAt(0));
            if (len <= 1)
                return frontNum * (frontNum + 1) / 2;
            long nextNum1 = getPower10(len - 1) - 1;
            long nextNum2 = Integer.parseInt(target) - frontNum * getPower10(len - 1);
            String nextTarget1 = String.valueOf(nextNum1);
            String nextTarget2 = String.valueOf(nextNum2);

            long component1 = getDigitSum(nextTarget1) * frontNum;
            long component2 = getFrontDigitSum(len, frontNum, nextNum2);
            long component3 = getDigitSum(nextTarget2);

            return component1 + component2 + component3;
        }

        long getFrontDigitSum(int len, int frontNum, long nextNum2) {
            return frontNum * (frontNum - 1) / 2 * getPower10(len - 1) + frontNum * (nextNum2 + 1);
        }

        long getPower10(int len) {
            return (int) Math.pow(10, len);
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}