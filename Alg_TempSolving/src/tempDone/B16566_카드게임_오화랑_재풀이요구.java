package tempDone;

import java.io.*;
import java.util.*;

/*
 * 10 7 5
 * 2 5 3 7 8 4 9 -> 2 3 4 5 7 8 9
 * 4 1 1 3 8 -> 4 1 2 3 8
 * 
 * 0 1 2 3 4 5 6 
 * 2 3 4 5 7 8 9
 * 
 * 0 1 2 3 4 5 6 7
 * 0 1 2 3 4 5 6 7
 * 
 * 4 -> idx : 3, val : 5;
 * => 다음부터 idx 3으로 찾아오게 되면, idx 4로 보내야 한다. => Union(3, 4);
 * 
 * 1 -> idx : 0, val : 2;
 * => 다음부터 idx 0으로 찾아오게 되면, idx 1로 보내야 한다. => Union(0, 1);
 * 
 * 1 -> idx : 0 
 * => 이미 방문한 idx 0으로 왔기에 idx 1로 보내진다. => Find(1) -> val : 3 , Union(1, 2)
 * 
 * 3 -> idx : 2
 * => 다음부터 idx 2로 찾아오게 되면, idx 3으로 보내져야 한다. => Union(2,3) -> 이때 선행된 Union(3,4)로 인해 Path Compression이 일어날 것이다.
 * 
 * 8 -> idx : 6
 * => 다음부터 idx 6으로 찾아오게 되면, idx 7로 보내져야 한다.( 이것은 코드의 통일성을 위한 설정 -> 실제로는 발생하지 않는 일 )
 * => Union(6, 7);
 * 
 * */

// https://www.acmicpc.net/problem/16566
public class B16566_카드게임_오화랑_재풀이요구 {
    static class Solution {
        int N, M, K;
        int[] parents;
        int[] cardList;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(input.readLine());
            this.N = Integer.parseInt(st.nextToken());
            this.M = Integer.parseInt(st.nextToken());
            this.K = Integer.parseInt(st.nextToken());
            this.cardList = new int[this.M];
            this.parents = new int[this.M + 1];

            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < this.M; i++) {
                cardList[i] = Integer.parseInt(st.nextToken());
                parents[i] = i;
            }
            parents[this.M] = this.M;
            Arrays.sort(cardList);

            st = new StringTokenizer(input.readLine());
            int target, idx;
            for (int i = 0; i < this.K; i++) {
                target = Integer.parseInt(st.nextToken());
                idx = binarySearch(target);
                idx = find(idx);
                // System.out.println("find_value in idx : " + idx);
                sb.append(cardList[idx]).append("\n");
                union(idx, idx + 1);
                // System.out.println(Arrays.toString(parents));
            }
            System.out.println(sb);
        }

        int binarySearch(int target) { // Higher를 구하는 Binary Search
            int left = 0;
            int right = cardList.length - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (target >= cardList[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        void makeSet() {
            for (int i = 0; i <= this.M; i++)
                parents[i] = i;
        }

        int find(int idx) {
            if (parents[idx] == idx)
                return idx;
            return parents[idx] = find(parents[idx]);
        }

        boolean union(int idx1, int idx2) {
            int root1 = find(idx1);
            int root2 = find(idx2);
            if (root1 == root2)
                return false;
            else if (root1 > root2)
                parents[root2] = root1;
            else
                parents[root1] = root2;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}