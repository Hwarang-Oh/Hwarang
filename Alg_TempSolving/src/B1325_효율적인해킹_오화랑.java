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
        int N, M, MAXHACK;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int[] howMuch, result;
        boolean[] visited;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            howMuch = new int[N + 1];
            result = new int[N + 1];
            visited = new boolean[N + 1];

            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            int from, to;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(input.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                graph.get(to).add(from);
            }

            for (int i = 1; i <= N; i++) {
                if (visited[i])
                    continue;
                int count = 0;
                queue.offer(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    count++;
                    for (int next : graph.get(current)) {
                        if (visited[next] && howMuch[next] > howMuch[current])
                            continue;
                        queue.offer(next);
                        howMuch[next] = howMuch[current] + 1;
                        visited[next] = true;
                    }
                }
                result[i] = count;
            }
            for (int i = 0; i <= N; i++) {
                System.out.println("i : " + i + " , result :" + result[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.run();
    }
}
