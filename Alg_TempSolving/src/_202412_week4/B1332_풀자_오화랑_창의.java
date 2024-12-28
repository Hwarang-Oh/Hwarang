package _202412_week4;

import java.io.*;
import java.util.*;

// IMP : https://www.acmicpc.net/problem/1332
// IMP : 2024.12.26
// IMP : 해당 방법의 반례는 무엇일까? ( 왜 안될까?? )

/**
 * * 몇개의 문제를 풀어야 한다.
 * IMP : A번 문제를 풀었을 때 => A + 1 or A + 2번 문제를 풀 수 있음
 * IMP : 반드시 1번 문제부터 풀어야 하는 것은 변하지 않음
 * ? 흥미도가 특정 범위 안에 들면, 문제를 푸는 것을 중지함 => "흥미 최대 - 최소 >= V "
 * ? 어떻게 해야 How 최소 문제 수를 달성하는가? ( 최소 문제 수 출력 )
 * IMP : 문제의 개수 N (50보다 작음), V ( 차이 기준, 1000보다 작음 )
 * IMP : 각 문제의 흥미도는 0 ~ 1000
 * ! 일단 문제는 DP 계열인 것 같긴 하다. => 하지만, 문제를 풀다보니 피보나치 만큼 경우의 수가 증가하게 됨...
 * Type : 조금은 Idea 느낌으로 풀어보자!
 */

/**
 * IMP : DP의 연산 횟수를 조금 더 줄여야 한다!!
 * ? ArrayList<ArrayList<State>>
 */

/**
 * IMP : 어차피 min / max의 흥미도 차이에 계산되는 숫자는 결국 2개다
 * IMP : 그 2개의 위치를 파악하고 ( a, b ) => (시작 to a , a to b ) 까지의 필요 개수를 구하면 될 것 같다.
 */

public class B1332_풀자_오화랑_창의 {

    static class Solution {
        int N, V;
        int minCount;
        ArrayList<Integer> numberList = new ArrayList<>();

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            minCount = N;

            int eachValue;
            int low, high;
            low = high = 0;
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < N; i++) {
                eachValue = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    low = eachValue;
                    high = eachValue;
                } else {
                    if (eachValue < low)
                        low = eachValue;
                    else if (eachValue > high)
                        high = eachValue;
                }
                numberList.add(eachValue);
                if (checkValid(low, high)) {
                    getCount(high, i);
                    break;
                }
            }
            System.out.println(minCount);
        }

        boolean checkValid(int minV, int maxV) {
            return maxV - minV >= V;
        }

        void getCount(int maxV, int maxL) {
            int canBeMinValue = maxV - V; // IMP : minV는 "maxV - V" 보다 작거나 같아야 함.
            for (int i = 0; i <= maxL; i++) {
                if (numberList.get(i) <= canBeMinValue) {
                    calculateCount(i, maxL);
                }
            }
        }

        void calculateCount(int minL, int maxL) {
            int firstC, secondC;
            if (minL < maxL) {
                firstC = minL % 2 == 0 ? minL / 2 + 1 : minL / 2 + 2;
                secondC = (maxL - minL) % 2 == 0 ? (maxL - minL) / 2 : (maxL - minL) / 2 + 1;
            } else {
                firstC = maxL % 2 == 0 ? maxL / 2 + 1 : maxL / 2 + 2;
                secondC = (minL - maxL) % 2 == 0 ? (minL - maxL) / 2 : (minL - maxL) / 2 + 1;
            }
            minCount = Math.min(minCount, firstC + secondC);
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
