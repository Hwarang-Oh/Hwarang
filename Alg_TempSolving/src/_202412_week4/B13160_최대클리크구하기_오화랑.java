package _202412_week4;

import java.io.*;
import java.util.*;

/**
 * IMP : https://www.acmicpc.net/problem/13160
 * IMP : 2024.12.28
 */

/**
 * IMP : 먼저 정렬을 좀 하는 것이 좋을 것 같다.
 * Type : 출력에 순서의 제한은 없다.
 */

public class B13160_최대클리크구하기_오화랑 {
    static class Pair {
        int start, end, num;

        public Pair(int start, int end, int num) {
            this.start = start;
            this.end = end;
            this.num = num;
        }

        public String toString() {
            return this.start + " " + this.end;
        }
    }

    static class Solution {
        int N;
        int MaxSize, MaxSpot;
        ArrayList<Pair> list = new ArrayList<>();

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st;
            N = Integer.parseInt(input.readLine());

            int s, e;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(input.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                list.add(new Pair(s, e, i + 1));
            }

            list.sort((o1, o2) -> Integer.compare(o1.start, o2.start) != 0
                    ? Integer.compare(o1.start, o2.start)
                    : Integer.compare(o1.end, o2.end));

            int low = 0;
            int high = Integer.MAX_VALUE;
            // IMP : Pair -> Integer로 사용하는 것이 더 좋음
            PriorityQueue<Pair> selectList = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.end, o2.end));

            for (Pair each : list) {
                low = each.start;

                if (each.start > high) {
                    while (true) {
                        if (selectList.peek().end >= low)
                            break;
                        else
                            selectList.poll();
                    }
                }

                if (each.end < high)
                    high = each.end;

                selectList.offer(each);

                if (selectList.size() > MaxSize) {
                    MaxSize = selectList.size();
                    MaxSpot = low;
                }
            }

            for (Pair each : list) {
                if (each.start <= MaxSpot && MaxSpot <= each.end)
                    sb.append(each.num).append(" ");
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
