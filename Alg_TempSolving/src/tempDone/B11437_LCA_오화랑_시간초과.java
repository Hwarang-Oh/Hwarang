package tempDone;

import java.io.*;
import java.util.*;

public class B11437_LCA_오화랑_시간초과 {
    static class Edge {
        int a, b;

        public Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static class Solution {
        int N, Q;
        ArrayDeque<Edge> remain = new ArrayDeque<>();
        int[] haveParent;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = null;

            this.N = Integer.parseInt(input.readLine());
            this.haveParent = new int[this.N + 1];

            int a, b;
            this.haveParent[1] = 1; // Root의 Parent 표시
            for (int i = 1; i < this.N; i++) {
                st = new StringTokenizer(input.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                addTree(a, b);
            }

            Edge temp;
            while (!remain.isEmpty()) {
                temp = remain.poll();
                a = temp.a;
                b = temp.b;
                addTree(a, b);
            }

            this.Q = Integer.parseInt(input.readLine());
            for (int i = 0; i < this.Q; i++) {
                st = new StringTokenizer(input.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                sb.append(checkParents(a, b)).append("\n");
            }
            System.out.print(sb);
        }

        void addTree(int a, int b) {
            if (this.haveParent[a] == 0 && this.haveParent[b] == 0) {
                // 모두 Parent가 존재하지 않아 판단이 어려운 Case
                this.remain.offer(new Edge(a, b));
            } else if (this.haveParent[a] == 0) {
                // B는 이미 Parent가 존재하는 Case
                this.haveParent[a] = b;
            } else {
                // A가 이미 Parent가 존재하는 Case
                this.haveParent[b] = a;
            }
        }

        int checkParents(int a, int b) {
            LinkedHashSet<Integer> parentA = getParents(a);
            LinkedHashSet<Integer> parentB = getParents(b);
            int minParent = 1; // Root

            for (int eachA : parentA) {
                if (parentB.contains(eachA)) {
                    minParent = eachA;
                    break;
                }
            }
            return minParent;
        }

        LinkedHashSet<Integer> getParents(int a) {
            LinkedHashSet<Integer> parents = new LinkedHashSet<>();
            parents.add(a);
            int current = a;
            int temp;
            while (true) {
                temp = this.haveParent[current];
                current = temp;
                parents.add(temp);
                if (temp == 1)
                    break;
            }
            return parents;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}