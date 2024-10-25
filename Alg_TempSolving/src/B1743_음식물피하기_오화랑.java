import java.io.*;
import java.util.*;

/**
 * IMP : https://www.acmicpc.net/problem/1743 ( 음식물 피하기 )
 * * 통로를 이동할 때, 음식물을 피해가야 하는데, 떨어진 음식물 중 제일 큰 음식물 만을 피해가야 함
 * * => 선생님을 도와, 제일 큰 음식물의 크기를 구하라
 * IMP : N -> 통로의 세로 길이, M -> 통로의 가로 길이, K : 음식물 쓰레기의 개수 ( 1 <= K <= N * M )
 */

public class B1743_음식물피하기_오화랑 {

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Solution {
        int N, M, K, MAX;
        int[][] map;
        boolean[][] visited;
        Queue<Pair> queue = new ArrayDeque<>();
        int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N + 1][M + 1];
            visited = new boolean[N + 1][M + 1];

            int eachX, eachY;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(input.readLine());
                eachX = Integer.parseInt(st.nextToken());
                eachY = Integer.parseInt(st.nextToken());
                map[eachX][eachY] = 1;
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j] == 0)
                        continue;
                    if (visited[i][j])
                        continue;

                    Pair current;
                    int nX, nY;
                    int currentNum = 1;
                    visited[i][j] = true;
                    queue.add(new Pair(i, j));

                    while (!queue.isEmpty()) {
                        current = queue.poll();
                        for (int[] eachMove : move) {
                            nX = current.x + eachMove[0];
                            nY = current.y + eachMove[1];
                            if (nX <= 0 || nY <= 0 || nX > N || nY > M)
                                continue;
                            if (map[nX][nY] == 0)
                                continue;
                            if (visited[nX][nY])
                                continue;
                            visited[nX][nY] = true;
                            queue.add(new Pair(nX, nY));
                            currentNum++;
                        }
                    }
                    MAX = Math.max(MAX, currentNum);
                }
            }
            System.out.println(MAX);
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}
