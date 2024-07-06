package tempDone;

import java.io.*;
import java.util.*;

// 산책 지점은 Tree 형태
// 출발지와 도착지가 정해져 있다면, 단순 경로는 오직 1가지
// 시작점과 끝점은 모두 실내 + 중간에 실내가 있으면, 그만두는 욕구가 생기기에 X
// 매일 다른 산책 경로를 걷고자 함 -> 다른 산책 경로 몇 가지 있는지 구하기
// 산책 지점은 1000개 이하, 간선은 999개 -> 완전 탐색으로는 해결하기 어려울 가능성이 높음
// 실내 1 , 실외 0

// Two Case 존재
// 1. 내 - 내 2 경로만 구성되어 있는 경우 바로 계산해주면 된다.
// 2. 내 (외 외 외 외 외 외 외...) 내의 경우 => 각 외에서 실내와 연결되어 있는 개수 모두 합함
// 거기서 2개만 고르면 자동으로 경로가 생성된다.
// 이때 외부 list는 반드시 이어져 있는 외부끼리만 모아 놓아야 한다.

// https://www.acmicpc.net/problem/21606
public class B21606_아침산책_오화랑_Fast풀이_최적화요구됨 {
    static class Solution {
        int N;
        char[] list;
        boolean[] visited;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayDeque<Integer> Queue = new ArrayDeque<>();

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = null;

            this.N = Integer.parseInt(input.readLine());
            this.list = new char[this.N + 1];
            this.visited = new boolean[this.N + 1];
            this.graph.add(new ArrayList<>());
            String line = input.readLine();
            for (int i = 1; i <= this.N; i++) {
                this.list[i] = line.charAt(i - 1);
                this.graph.add(new ArrayList<>());
            }
            // 1. Make a graph and get Route 1
            int from, to;
            int routeCnt1 = 0;
            for (int i = 0; i < this.N - 1; i++) {
                st = new StringTokenizer(input.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                this.graph.get(from).add(to);
                this.graph.get(to).add(from);
                if (this.list[from] == '1' && this.list[to] == '1')
                    routeCnt1 += 2;
            }

            // 2. get Route 2
            int routeCnt2 = 0;
            for (int i = 1; i <= this.N; i++) {
                if (list[i] == '0' && !visited[i]) {
                    visited[i] = true;
                    Queue.offer(i);
                    routeCnt2 += getRoute2();
                }
            }

            // 3. get Totle Route
            System.out.println(routeCnt1 + routeCnt2);
        }

        int getRoute2() {
            int eachCnt = 0;
            int temp;
            while (!Queue.isEmpty()) {
                temp = Queue.poll();
                for (int next : graph.get(temp)) {
                    if (list[next] == '1')
                        eachCnt++;
                    else {
                        if (visited[next])
                            continue;
                        else {
                            visited[next] = true;
                            Queue.offer(next);
                        }
                    }
                }
            }
            return eachCnt * (eachCnt - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}