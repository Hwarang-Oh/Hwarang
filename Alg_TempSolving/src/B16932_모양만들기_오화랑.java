import java.io.*;
import java.util.*;

// IMP : https://www.acmicpc.net/problem/16932
// IMP : 2024.12.24 

/**
 * IMP : 모든 칸에 대한 탐색? -> 1 주변의 0에 대한 탐색 위주
 * TODO : '1' 주위의 0에 다른, '1'이 존재하지 않는다면.. 굳이? 어차피 + 1 말고는 의미 X
 * TODO : 이런 느낌으로 최적화해서 탐색하는 0의 개수를 줄일 수 있을까?
 * 
 * IMP : 주변에 1이 많은 0 ? -> 절대 안됨 ( 반례 존재 )
 * 
 * IMP : 기존의 1 모양의 가능성을 계산하고, 이를 토대로 0 기준으로 합하여, 최대치를 계산한다.
 */

public class B16932_모양만들기_오화랑 {

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "Pair{" + "x=" + x + ", y=" + y + '}';

        }
    }

    static class Solution {
        int N, M, MAX;
        int[][] Map;
        Pair[][] sumMap;
        boolean[][] visited;
        Queue<Pair> queue = new ArrayDeque<>();
        Queue<Pair> oneSumCheck = new ArrayDeque<>();
        Queue<Pair> zeroCheck = new ArrayDeque<>();
        int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Map = new int[N][M];
            sumMap = new Pair[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(input.readLine());
                for (int j = 0; j < M; j++) {
                    Map[i][j] = Integer.parseInt(st.nextToken());
                    sumMap[i][j] = new Pair(0, 0);
                }
            }

            int typeCount = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j])
                        continue;

                    if (Map[i][j] == 0) {
                        for (int[] eachSearch : search) {
                            int nextX = i + eachSearch[0];
                            int nextY = j + eachSearch[1];
                            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                                continue;
                            if (Map[nextX][nextY] == 1) {
                                zeroCheck.offer(new Pair(i, j));
                                break;
                            }
                        }
                    } else {
                        int sumCount = 0;
                        queue.offer(new Pair(i, j));
                        visited[i][j] = true;

                        while (!queue.isEmpty()) {
                            Pair current = queue.poll();
                            sumCount++;
                            for (int[] eachSearch : search) {
                                int nextX = current.x + eachSearch[0];
                                int nextY = current.y + eachSearch[1];
                                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                                    continue;
                                if (visited[nextX][nextY])
                                    continue;
                                if (Map[nextX][nextY] == 1) {
                                    queue.offer(new Pair(nextX, nextY));
                                    visited[nextX][nextY] = true;
                                }
                            }
                            oneSumCheck.offer(new Pair(current.x, current.y));
                        }
                        while (!oneSumCheck.isEmpty()) {
                            Pair eachPair = oneSumCheck.poll();
                            sumMap[eachPair.x][eachPair.y] = new Pair(typeCount, sumCount);
                        }
                        typeCount++;
                    }
                }
            }

            // for (int i = 0; i < N; i++) {
            // System.out.println(Arrays.toString(sumMap[i]));
            // }

            while (!zeroCheck.isEmpty()) {
                HashSet<Integer> typeSet = new HashSet<>();
                Pair current = zeroCheck.poll();
                int currentMax = 0;
                for (int[] eachSearch : search) {
                    int nextX = current.x + eachSearch[0];
                    int nextY = current.y + eachSearch[1];
                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                        continue;

                    if (typeSet.contains(sumMap[nextX][nextY].x))
                        continue;

                    if (sumMap[nextX][nextY].x >= 0) {
                        typeSet.add(sumMap[nextX][nextY].x);
                        currentMax += sumMap[nextX][nextY].y;
                    }
                }
                MAX = Math.max(MAX, currentMax + 1);
            }
            System.out.println(MAX);
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}