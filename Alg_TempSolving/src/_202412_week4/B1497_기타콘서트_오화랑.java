package _202412_week4;

import java.io.*;
import java.util.*;

// IMP : https://www.acmicpc.net/problem/1497
// IMP : 2024.12.24

// 123, 125, 45, 1
// 134, 45, 12345
// 10, 10, 00
// 125, 1235, 67, 3, 4

/**
 * IMP : N <= 10 ( 기타의 개수 ), M <= 50 ( 곡의 개수 )
 * * 기타의 이름 + Y ( 연주 가능 ) + N ( 연주 불가 )
 * * 조합 혹은 부분 집합을 통해서, 기타의 N 개중 몇 개에서 => 최대로 커버하는 곡의 개수가 나타날 때 의 기타 개수를 체크해주면
 * 된다.
 * * 최대 곡 개수가 M에 도달하면, 바로 End
 * * 최대 곡 개수가 변경되지 않으면, 그 전이 최대
 * * 최대 곡의 개수가 0이라면, -1
 * ! Refactoring 여지가 남아 있는 Code이긴 하다.
 */

public class B1497_기타콘서트_오화랑 {

    static class Solution {
        int N, M;
        boolean[] selected;
        ArrayList<ArrayList<Integer>> canMakeList = new ArrayList<>();
        int totalMaxMade;
        int totalMinUsed = 11;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            selected = new boolean[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(input.readLine());
                st.nextToken();
                String canMake = st.nextToken();
                ArrayList<Integer> eachCanMake = new ArrayList<>();
                for (int j = 0; j < M; j++) {
                    if (canMake.charAt(j) == 'Y')
                        eachCanMake.add(j);
                }
                canMakeList.add(eachCanMake);
            }
            choose(0, 0);
            if (totalMaxMade == 0)
                System.out.println(-1);
            else
                System.out.println(totalMinUsed);
        }

        void choose(int start, int count) {
            if (count == N) {
                getEachCanMake();
                return;
            }
            for (int i = start; i < N; i++) {
                selected[i] = true;
                choose(i + 1, count + 1);
                selected[i] = false;
                choose(i + 1, count + 1);
            }
        }

        void getEachCanMake() {
            int usedCount = 0;
            HashSet<Integer> madeList = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    usedCount++;
                    madeList.addAll(canMakeList.get(i));
                }
            }
            if (madeList.size() > totalMaxMade) {
                totalMinUsed = usedCount;
                totalMaxMade = madeList.size();
            } else if (madeList.size() == totalMaxMade) {
                totalMinUsed = Math.min(totalMinUsed, usedCount);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}