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
 * => 내가 갔던 경로는 기억하는 것이 좋을 것 같긴 한데... 이미 연결된 Graph에서 => 특정 친구를 Visited할 때 => 내가
 * 그 장소를 더 많은 것을 들린 채로 왔는가? 판단이 중요하지 않을까?
 */

public class B1325_효율적인해킹_오화랑 {
    static class Solution {
        int N, M, MAX;
        boolean[] visited;
        Queue<Integer> result = new ArrayDeque<>();
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer>[] network;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            network = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++)
                network[i] = new ArrayList<>();

            int from, to;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(input.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                network[to].add(from);
            }

            for (int i = 1; i <= N; i++) {
                visited = new boolean[N + 1];
                int eachResult = 1;
                visited[i] = true;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    for (int next : network[current]) {
                        if (visited[next])
                            continue;
                        eachResult++;
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
                if (eachResult == MAX)
                    result.offer(i);
                else if (eachResult > MAX) {
                    MAX = eachResult;
                    result.clear();
                    result.offer(i);
                }
            }
            while (!result.isEmpty())
                sb.append(result.poll() + " ");
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}
