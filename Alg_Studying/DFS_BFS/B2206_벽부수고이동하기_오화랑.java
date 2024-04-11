import java.io.*;
import java.util.*;

public class B2206_벽부수고이동하기_오화랑 {
    static class state {
        int x, y, route, hurt;
        public state(int x, int y, int route, int hurt) {
            this.x = x;
            this.y = y;
            this.route = route;
            this.hurt = hurt;
        }
    }
    static int[][] Map;
    static boolean[][] visited;
    static boolean[][] hurtVisited;
    static Queue<state> stateList = new ArrayDeque<>();
    static int minRoute;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        visited = new boolean[N][M];
        hurtVisited = new boolean[N][M];
        String temp;
        for (int i = 0 ; i < N ; i++) {
            temp = input.readLine();
            for (int j = 0 ; j < M ; j++) {
                Map[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }
        getRoute(N, M);
        if (minRoute > 0) System.out.println(minRoute);
        else System.out.println(-1);
    }
    public static void getRoute(int N, int M) {
        int[][] move = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
        stateList.offer(new state(0, 0, 1, 0));
        visited[0][0] = true;
        state tempState;
        while (!stateList.isEmpty()) {
            tempState = stateList.poll();
            int currX = tempState.x;
            int currY = tempState.y;
            int currR = tempState.route;
            int currH = tempState.hurt;
            if (currX == N - 1 && currY == M - 1) {
                minRoute = currR;
                return;
            }
            for (int[] eachM : move) {
                int nextX = currX + eachM[0];
                int nextY = currY + eachM[1];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (currH == 1) { // 벽을 부수고 아픈 상태로 왔다면
                    if (hurtVisited[nextX][nextY] || visited[nextX][nextY] || Map[nextX][nextY] == 1) continue;
                    stateList.offer(new state(nextX, nextY, currR + 1, currH));
                    hurtVisited[nextX][nextY] = true;
                }
                else { // 벽을 부수지 않은 건강한 상태라면
                    if (Map[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                        stateList.offer(new state(nextX, nextY, currR + 1, currH));
                        visited[nextX][nextY] = true;
                    }
                    else if (Map[nextX][nextY] == 1) {
                        if (nextX + eachM[0] < 0 || nextY + eachM[1] < 0 || nextX + eachM[0] >= N || nextY + eachM[1] >= M) continue;
                        if (Map[nextX + eachM[0]][nextY + eachM[1]] == 1) continue; // 건너편도 벽이라면 포기
                        if (visited[nextX][nextY] || hurtVisited[nextX][nextY]) continue; // visited[]
                        stateList.offer(new state(nextX + eachM[0], nextY + eachM[1], currR + 2, currH + 1));
                        hurtVisited[nextX + eachM[0]][nextY + eachM[1]] = true;
                    }
                }
            }
        }
    }
}
