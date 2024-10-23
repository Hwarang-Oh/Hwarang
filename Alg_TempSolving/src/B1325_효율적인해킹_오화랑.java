import java.io.*;
import java.util.*;

/**
 * IMP : https://www.acmicpc.net/problem/1325
 * * 한 번의 해킹으로 여러 개의 컴퓨터를 해킹할 수 있음
 * * A CPU -> B CPU를 신뢰한다 => B를 해킹하면 A를 해킹할 수 있음
 * * N : 10,000이하의 자연수, M : 100,000 이하의 자연수 (CPU, 관계)
 * * 3, 1
 * * 3, 2
 * * 4, 3
 * * 5, 3
 * => 1 : (1, 1) , 2 : (2, 1), 3 : (3, 1), 4 : (4, 1), 5 : (5, 1)
 * => 1 : (1, 2) , 2 : (2, 2), 3 : (1, 1), 4 : (4, 1), 5 : (5, 1)
 * => 1 : ()
 * => 일단 내가 알던 위상 정렬 느낌이 아니긴 함 => 약간 Set으로 나를 믿는 사람들과 내가 믿는 사람들을 관리하는 느낌
 * => BFS로 하고 다시 그냥 최적해 구하는 것을 다시 해보자!!
 */

public class B1325_효율적인해킹_오화랑 {
    static class relationState {
        HashSet<Integer> trustToList;
        HashSet<Integer> trustFromList;

        public relationState(int i) {
            this.trustToList = new HashSet<>();
            this.trustToList.add(i);
            this.trustFromList = new HashSet<>();
        }

        public String toString() {
            return "trustToList : " + trustToList.toString() + ", trustFromList : " + trustFromList.toString();
        }
    }

    static class Solution {
        int N, M, MAX;
        ArrayList<Integer> resultList = new ArrayList<>();
        ArrayList<relationState> network = new ArrayList<>();

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            for (int i = 0; i <= N; i++)
                network.add(new relationState(i));

            int from, to, currentSize;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(input.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                if (!network.get(to).trustFromList.contains(from)) {
                    // 3 -> 1 ( 3이 1을 신뢰한다 )
                    // x - > 3 ( x가 3을 신뢰한다 => x -> 1을 신뢰하는 셈 )
                    network.get(to).trustFromList.addAll(network.get(from).trustFromList);
                }
            }

            for (relationState each : network)
                System.out.println(each);

            // int from, to;
            // for (int i = 0; i < M; i++) {
            // st = new StringTokenizer(input.readLine());
            // from = Integer.parseInt(st.nextToken());
            // to = Integer.parseInt(st.nextToken());
            // if (!network.get(to).bList.contains(from)) {
            // network.get(to).bList.add(from);
            // network.get(from).canHackNum += network.get
            // }
            // }
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}
