package _202412_week4;

/**
 * IMP : https://www.acmicpc.net/problem/1430
 * IMP : 2024.12.28
 */

/**
 * IMP : 도시에 N개의 탑이 있음 ( x, y 좌표공간 )
 * => D의 에너지 존재, 탑의 사정거리는 R
 * => 탑의 에너지는 재분배가 가능함 => R 거리 내에 있다면
 * => 탑의 에너지는 재분배할 때 1/2이 됨 ( 10 -> 5 전송됨 )
 * => 탑이 적을 공격할 때는, 자신의 모든 에너지를 소요해서 공격함
 * => 이때 공격은 그대로 전달됨. => 적이 받을 수 있는 데미지의 최대값값
 * IMP : vistited -> 몇번에 걸쳐서 해당 tower에 도달할 수 있는가? 의 문제 
 * IMP : 이렇게 되면, 굳이 뭔가 더 복잡하게 처리할 필요가 없어짐. 
 */

import java.io.*;
import java.util.*;

public class B1430_공격_오화랑 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }

    static class Solution {
        int N, R, D;
        Pair target;
        double totalDamage;
        boolean[] visited;
        ArrayList<Pair> towerList = new ArrayList<>();
        Queue<Pair> nearTowers = new ArrayDeque<>();

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());
            target = new Pair(tx, ty);
            visited = new boolean[N];

            Pair cT;
            int cX, cY;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(input.readLine());
                cX = Integer.parseInt(st.nextToken());
                cY = Integer.parseInt(st.nextToken());
                cT = new Pair(cX, cY);

                if (checkRange(cT, target)) {
                    nearTowers.offer(cT);
                    visited[i] = true;
                }
                towerList.add(cT);
            }

            int qSize;
            int loopCount = 0;
            Pair current, next;
            while (!nearTowers.isEmpty()) {
                qSize = nearTowers.size();
                while (qSize-- > 0) {
                    current = nearTowers.poll();
                    totalDamage += (D / Math.pow(2, loopCount));
                    for (int i = 0; i < N; i++) {
                        next = towerList.get(i);
                        if (visited[i])
                            continue;
                        if (checkRange(current, next)) {
                            nearTowers.offer(next);
                            visited[i] = true;
                        }
                    }
                }
                loopCount++;
            }
            System.out.println(totalDamage);
        }

        boolean checkRange(Pair p1, Pair p2) {
            return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2)) <= R;
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
