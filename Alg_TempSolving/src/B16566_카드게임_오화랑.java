import java.io.*;
import java.util.*;

/*
 * 10 7 5
 * 2 5 3 7 8 4 9
 * 4 1 1 3 8
 * 첫째 줄에 세 개의 자연수 N, M, K가 주어진다. (1 ≤ M ≤ N ≤ 4,000,000, 1 ≤ K ≤ min(M, 10,000))
 * K번 중에 더 많이 이긴 사람이 승리한다.
 * 민수는 뛰어난 심리학자 -> 철수가 어떤 카드를 낼 지 알 수 있음 => 철수의 카드보다 큰 수가 있다면?
 * => 가진 카드 중 가장 작은 카드를 내기로 함. -> 철수의 카드보다 큰 수가 없다면?? => 가장 작은 카드를 내는 것이 이득임.
 * => smallest ~ ~ ~ ~ ~ target T_Smallest ~ ~ ~ ~ ~ ~ ~ => smallest 와 T_Smallest 둘 중 하나의 Case만 없어짐.
 * Poss 1 : Binary Search -> 이렇게 하면, 고른 숫자가 사라져야 한다는 단점이 있음 -> 고른 숫자는 카드에서 사라져야 하기 때문이다. => 이진 탐색이 어려워짐
 * Poss 2 : TreeSet으로 저장하고 Search => 시간 초과가 발생한다.
 */

// https://www.acmicpc.net/problem/16566
public class B16566_카드게임_오화랑 {
    static class pair {
        int idx, val;

        public pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    static class Solution {
        int N, M, K;
        TreeSet<Integer> cardList = new TreeSet<>();

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(input.readLine());
            this.N = Integer.parseInt(st.nextToken());
            this.M = Integer.parseInt(st.nextToken());
            this.K = Integer.parseInt(st.nextToken());
            pair upperB = new pair(0, 0);

            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < this.M; i++)
                cardList.add(Integer.parseInt(st.nextToken()));

            int target, choose;
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < this.K; i++) {
                target = Integer.parseInt(st.nextToken());
                if (target > upperB)

                    if (cardList.last() > target) {
                        choose = cardList.higher(target);

                        sb.append(choose).append("\n");
                    } else {
                        choose = cardList.pollFirst();
                        sb.append(choose).append("\n");
                    }
            }
            System.out.print(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}