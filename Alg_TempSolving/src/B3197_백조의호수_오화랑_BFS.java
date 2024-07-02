import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/3197
public class B3197_백조의호수_오화랑_BFS {
    static class pair {
        int x, y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Solution {
        int R, C;
        boolean canMeet;
        int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        char[][] Map;
        boolean[][] visited;
        pair[] Duck = new pair[2];
        Queue<pair> waterList = new ArrayDeque<>();
        Queue<pair> nextWaterList = new ArrayDeque<>();
        Queue<pair> swanList = new ArrayDeque<>();
        Queue<pair> nextSwanList = new ArrayDeque<>();

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            this.R = Integer.parseInt(st.nextToken());
            this.C = Integer.parseInt(st.nextToken());
            this.Map = new char[this.R][this.C];
            this.visited = new boolean[this.R][this.C];
            int duckIndex = 0;
            for (int i = 0; i < this.R; i++) {
                String line = input.readLine();
                for (int j = 0; j < this.C; j++) {
                    Map[i][j] = line.charAt(j);
                    if (Map[i][j] != 'X')
                        waterList.offer(new pair(i, j));
                    if (Map[i][j] == 'L') {
                        Duck[duckIndex++] = new pair(i, j);
                    }
                }
            }
            int day = 0;
            getSwanRoute(Duck[0].x, Duck[0].y);
            while (!canMeet) {
                melt();
                swanMove();
                day++;
            }
            System.out.println(day);
        }

        void getSwanRoute(int sX, int sY) {
            swanList.offer(new pair(sX, sY));
            visited[sX][sY] = true;
            swanMove();
        }

        void swanMove() {
            int nX, nY;
            pair temp;
            while (!swanList.isEmpty()) {
                temp = swanList.poll();
                for (int[] eachM : move) {
                    nX = temp.x + eachM[0];
                    nY = temp.y + eachM[1];
                    if (nX < 0 || nY < 0 || nX >= R || nY >= C)
                        continue;
                    if (visited[nX][nY])
                        continue;

                    visited[nX][nY] = true;
                    if (Map[nX][nY] == '.')
                        swanList.offer(new pair(nX, nY));
                    if (Map[nX][nY] == 'X')
                        nextSwanList.offer(new pair(nX, nY));
                    if (Map[nX][nY] == 'L') {
                        canMeet = true;
                        return;
                    }
                }
            }
            while (!nextSwanList.isEmpty()) {
                swanList.offer(nextSwanList.poll());
            }
        }

        void melt() {
            int nX, nY;
            pair temp;
            while (!waterList.isEmpty()) {
                temp = waterList.poll();
                for (int[] eachM : move) {
                    nX = temp.x + eachM[0];
                    nY = temp.y + eachM[1];
                    if (nX < 0 || nY < 0 || nX >= R || nY >= C)
                        continue;
                    if (Map[nX][nY] == 'X') {
                        nextWaterList.offer(new pair(nX, nY));
                        Map[nX][nY] = '.';
                    }
                }
            }
            while (!nextWaterList.isEmpty()) {
                waterList.add(nextWaterList.poll());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}
