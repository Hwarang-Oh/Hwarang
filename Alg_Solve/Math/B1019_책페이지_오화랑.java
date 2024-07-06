import java.util.*;

// 현재 Code는 1 ~ 9 개의 개수만 파악할 수 있음 => 방법이 있긴 함 => 전체 개수에서 1 ~ 9개를 더한 것을 빼기!!
// https://www.acmicpc.net/problem/1019
public class B1019_책페이지_오화랑 {
    static class Solution {
        String target;
        long[] result = new long[10];

        void run() {
            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            this.target = sc.nextLine();
            this.result = getNumberCnt(this.target);
            long notZeroCnt = 0;
            long totalCnt = getTotalCnt();
            for (int i = 1; i < 10; i++) {
                notZeroCnt += this.result[i];
            }
            this.result[0] = totalCnt - notZeroCnt;

            for (int i = 0; i < 10; i++) {
                sb.append(this.result[i]).append(" ");
            }
            System.out.println(sb);
        }

        long[] getNumberCnt(String target) {
            long len = target.length();
            int firstNum = Character.getNumericValue(target.charAt(0));
            long numberCnt[] = new long[10];
            if (len == 1) {
                for (int i = 1; i <= firstNum; i++)
                    numberCnt[i]++;
                return numberCnt;
            }
            long nextNum1, nextNum2;
            String nextTarget1, nextTarget2;
            long c1[], c2[], c3[];

            nextNum1 = getPower10(len - 1) - 1;
            nextNum2 = Integer.parseInt(target) - getPower10(len - 1) * firstNum;
            nextTarget1 = String.valueOf(nextNum1);
            nextTarget2 = String.valueOf(nextNum2);

            c1 = getNumberCnt(nextTarget1);
            c2 = getFirstDigitCnt(firstNum, nextNum2, len);
            c3 = getNumberCnt(nextTarget2);
            for (int i = 0; i < 10; i++)
                numberCnt[i] += (c1[i] * firstNum + c2[i] + c3[i]);
            return numberCnt;
        }

        int getPower10(long len) {
            return (int) Math.pow(10, len);
        }

        long[] getFirstDigitCnt(int firstNum, long nextNum2, long len) {
            long[] temp = new long[10];
            for (int i = 1; i < firstNum; i++) {
                temp[i] = getPower10(len - 1);
            }
            temp[firstNum] += nextNum2 + 1;
            return temp;
        }

        long getTotalCnt() {
            long len = target.length();
            long end = Integer.parseInt(target);
            long result = (end - getPower10(len - 1) + 1) * len; // 해당 계산식이 long에 담기기 위해 end를 long으로 형변환을 미리 해놓아야 한다.
            long rest = 0;
            while (len > 1) {
                rest += (getPower10(len - 1) - getPower10(len - 2)) * (len - 1);
                len--;
            }
            return result + rest;
        }
    }

    public static void main(String[] args) {
        Solution Solution = new Solution();
        Solution.run();
    }
}