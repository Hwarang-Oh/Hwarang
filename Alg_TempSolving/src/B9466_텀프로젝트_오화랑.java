import java.io.*;
import java.util.*;

/**
 * IMP : https://www.acmicpc.net/problem/9466
 * * 텀 프로젝트 수행 => 프로젝트의 팀원 수에는 제한이 없음 => 1팀만 생길 수 있고, 각 팀으로 찢어질 수도 있음
 * * 모든 학생들은 함께하고 싶은 학생을 선택함 => 혼자 하고 싶다면, 자기 자신을 선택할 수 있음
 * * 결국, 탐색을 진행했을 때, 다시 본인들에게 갈 수 있게 해야 함
 * * 잘해야 함 ㅇㅇ
 */

public class B9466_텀프로젝트_오화랑 {

    static class Pair {
        int count, num;

        public Pair(int count, int num) {
            this.count = count;
            this.num = num;
        }
    }

    static class Solution {
        int T, N;
        int[] wantTeam;
        boolean[] visited;
        Queue<Integer> notTeamQueue = new ArrayDeque<>();
        Queue<Integer> findTeamQueue = new ArrayDeque<>();

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st;
            T = Integer.parseInt(input.readLine());
            for (int t = 1; t <= T; t++) {
                N = Integer.parseInt(input.readLine());
                st = new StringTokenizer(input.readLine());
                wantTeam = new int[N + 1];
                for (int i = 1; i <= N; i++)
                    wantTeam[i] = Integer.parseInt(st.nextToken());
                for (int i = 1; i <= N; i++) {
                    if (visited[i])
                        continue;
                    dfs(i);
                }

            }
        }

        void dfs(int current) {
            int next = wantTeam[current];
            visited[current] = true;
            if (!visited[next]) {
                findTeamQueue.offer(next);
                dfs(next);
            } else {
                while (!findTeamQueue.isEmpty()) {

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }

}
