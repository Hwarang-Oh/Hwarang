package _202412_week5;

import java.io.*;
import java.util.*;

/**
 * IMP : https://www.acmicpc.net/problem/13023
 * IMP : 2025.01.01
 */

/**
 * IMP : 간단한 BFS 형식으로 보이긴 하다만...
 * TYPE : 뭔가 각 탐색마다, 상태를 관리해야 하는 것 처럼 보인다.
 * ? Method 1 : Bit Masking
 * ? Method 2 : 기본적인 BFS -> 뭔가 상태 관리를 위한 선언을 많이 해야 해서, 비효율적
 * ? Method 3 : 사실 DFS로 했으면, 많이 간단한 문제였다... 약간 허무 ( 그래도 비트마스킹은 생각을 좀 해야겠음 )
 */

// int[] visited = new int[N];
// Queue<Pair> queue = new ArrayDeque<>();
// for (int i = 0; i < N; i++) {
// queue.offer(new Pair(i, 0));
// visited[i] |= (1 << 0);
// System.out.println("start :" + i);
// while (!queue.isEmpty()) {
// Pair current = queue.poll();
// System.out.println("current : " + current);
// for (int next : graph.get(current.num)) {
// if ((visited[next] & (1 << current.state + 1)) == 0) {
// queue.offer(new Pair(next, current.state + 1));
// visited[next] |= (1 << current.state + 1);
// }
// }
// }
// }

public class B13023_ABCDE_오화랑 {
    static class State {
        int num;
        HashSet<Integer> comb;

        public State(int num, HashSet<Integer> comb) {
            this.num = num;
            this.comb = comb;
        }

        public String toString() {
            return this.num + " " + this.comb;
        }
    }

    static class Solution {
        int N, M;
        boolean fiveMade;
        boolean[] visited;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            visited = new boolean[N];

            // IMP : Graph 초기화
            for (int i = 0; i < N; i++)
                graph.add(new ArrayList<>());

            // IMP : Graph 연결관계
            int a, b;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(input.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for (int i = 0; i < N; i++) {
                if (fiveMade)
                    break;
                getNext(i, 0);
            }
            System.out.println(fiveMade ? 1 : 0);
        }

        void getNext(int num, int count) {
            visited[num] = true;
            if (count == 4) {
                fiveMade = true;
                return;
            }
            for (int next : graph.get(num)) {
                if (visited[next])
                    continue;
                getNext(next, count + 1);
            }
            visited[num] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
