package tempDone;

import java.io.*;
import java.util.*;

// Problem
// N : 500,000 (MAX), Q : 100,000 (MAX)
// 문제를 읽으면, 곧이 곧대로 하면 시간 초과가 날 수 밖에 없는, Query형 문제
// 각각의 건물에 대한 거리 PQ를 만들어 내는 방법 -> 각 건물에 대한 PQ를 관리해야 하는 문제점 ( + 시간 초과 남 )
// 명소에 대한 정보는 1개로 주어지는 것이 좋음
// 규칙을 가지는 Tree를 만드는 것이 합리적임 ( 부모를 기준으로 왼쪽 작은 것 오른쪽 큰 것 )
// 3번 Query는 반드시 시계 방향으로 이동함. -> 예) 7번이 6번 명소로 1로 이동 X 
// 결국 각 출발점을 기준으로 가장 작게 큰 것과, 가장 작은 건물의 거리를 비교해서 최소값을 구해내야 함

public class B23326_홍익투어리스트_오화랑_TreeSet연습 {
    static class Solution {
        int N, Q;
        TreeSet<Integer> Tree = new TreeSet<>();
        // Binary Tree
        // LeftNode -> Smaller
        // RightNode -> Larger

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(input.readLine());
            this.N = Integer.parseInt(st.nextToken());
            this.Q = Integer.parseInt(st.nextToken());

            // Input
            st = new StringTokenizer(input.readLine());
            for (int i = 1; i <= this.N; i++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 1)
                    this.Tree.add(i);
            }

            // Query
            int stand, eachQ, val, Higher, Lowest;
            stand = 1; // First Start : 1
            for (int i = 0; i < this.Q; i++) {
                st = new StringTokenizer(input.readLine());
                eachQ = Integer.parseInt(st.nextToken());
                if (eachQ == 1) { // Add, Remove Operation

                    val = Integer.parseInt(st.nextToken());
                    if (this.Tree.contains(val)) // 이미 Tree에 존재하면, remove
                        this.Tree.remove(val);
                    else // Tree에 없다면, Add
                        this.Tree.add(val);

                } else if (eachQ == 2) { // Move Operation

                    val = Integer.parseInt(st.nextToken());
                    stand = move(stand, val);

                } else if (eachQ == 3) { // Count Operation

                    if (this.Tree.isEmpty()) { // If no Tree Component -> No Famous => -1
                        sb.append(-1).append("\n");
                        continue;
                    }
                    if (this.Tree.ceiling(stand) != null) { // No Higher -> Go Lowest
                        Higher = this.Tree.ceiling(stand);
                        sb.append(distCal(stand, Higher)).append("\n");
                        continue;
                    }
                    Lowest = Tree.first();
                    sb.append(distCal(stand, Lowest)).append("\n");

                }
            }
            // Print
            System.out.print(sb);
        }

        int move(int stand, int val) {
            int realMove = val % this.N;
            return stand = stand + realMove > this.N ? stand + realMove - this.N : stand + realMove;
        }

        int distCal(int stand, int target) {
            if (target >= stand)
                return target - stand;
            else
                return this.N - stand + target;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}
