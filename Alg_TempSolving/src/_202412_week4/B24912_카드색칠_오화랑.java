package _202412_week4;

import java.io.*;
import java.util.*;

// IMP : https://www.acmicpc.net/problem/24912
// IMP : 2024.12.24

/**
 * IMP : 카드 중 몇개느 이미 색칠되어 있는 상태
 * IMP : 단조로움을 피하기 위해, 인접한 카드는 서로 다른 색
 * IMP : 카드의 순서를 바꿀 수 없음.
 * * 1, 2, 3 색깔
 * * 0 : 색깔 미정 상태
 * => 주어진 조건에 맞게 색칠을 칠하라
 * => 색칠이 불가능하다면, -1
 * * 이건 Greedy로 해도 가능한 문제이긴 한데.. 어차피 영향이 양 옆에 국한되어 있기 때문에... => 그리고 아무거나 답을 낼 수
 * 있음!!
 * ! Dynamic Programming으로 풀어내면 어떻게 풀어내야 할까?
 * TODO : 더 좋은 풀이가 존재하지 않을까??
 */

public class B24912_카드색칠_오화랑 {

    static class Solution {
        int N;
        int[] cardList;
        boolean colorMade = true;

        void run() throws IOException {
            StringBuilder sb = new StringBuilder();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(input.readLine());
            cardList = new int[N];
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int i = 0; i < N; i++)
                cardList[i] = Integer.parseInt(st.nextToken());

            if (N == 1) {
                if (cardList[0] == 0)
                    System.out.println(1);
                else
                    System.out.println(cardList[0]);
                return;
            }

            for (int i = 0; i < N; i++) {
                if (i == 0) {
                    if (cardList[i] == 0) {
                        for (int c = 1; c <= 3; c++) {
                            if (c == cardList[i + 1])
                                continue;
                            else {
                                cardList[i] = c;
                                break;
                            }
                        }
                    } else {
                        if (cardList[i] == cardList[i + 1]) {
                            colorMade = false;
                            break;
                        }
                    }
                } else if (i == N - 1) {
                    if (cardList[i] == 0) {
                        for (int c = 1; c <= 3; c++) {
                            if (c == cardList[i - 1])
                                continue;
                            else {
                                cardList[i] = c;
                                break;
                            }
                        }
                    }
                } else {
                    if (cardList[i] == 0) {
                        for (int c = 1; c <= 3; c++) {
                            if (c == cardList[i - 1] || c == cardList[i + 1])
                                continue;
                            else {
                                cardList[i] = c;
                                break;
                            }
                        }
                    } else {
                        if (cardList[i] == cardList[i + 1]) {
                            colorMade = false;
                            break;
                        }
                    }
                }
                sb.append(cardList[i]).append(" ");
            }
            if (colorMade)
                System.out.println(sb);
            else
                System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}

/**
 * 1 0 0 2 0 0 3
 * 
 * 1 2 0 2 0 0 3
 * 1 3 0 2 0 0 3
 * 
 * 1 2 3 2 0 0 3
 * 1 3 1 2 0 0 3
 * 
 */