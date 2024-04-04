import java.io.*;
import java.util.*;

public class B4485_녹색옷입은애가젤다지_오화랑 {
    static class pair {
        int x, y, cost;

        public pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    static int[][] Map;
    static boolean[][] visited;
    static int[][] costVisited;
    static int minCost = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int size;
        int pNum = 1;
        while (true) {
            size = Integer.parseInt(input.readLine());
            if (size == 0) break;
            Map = new int[size][size];
            visited = new boolean[size][size];
            costVisited = new int[size][size];
            for (int i = 0 ; i < size ; i++) {
                st = new StringTokenizer(input.readLine());
                for (int j = 0 ; j < size ; j++) {
                    Map[i][j] = Integer.parseInt(st.nextToken());
                    costVisited[i][j] = Integer.MAX_VALUE;
                }
            }
            minCost = Integer.MAX_VALUE;
            getCost(size);
            sb.append("Problem ").append(pNum++).append(": ").append(minCost).append("\n");
        }
        System.out.print(sb);
    }
    public static void getCost(int size) {
        int[][] move = { {1, 0}, {0, -1}, {-1, 0}, {0, 1} };
        Queue<pair> queue = new ArrayDeque<>();
        visited[0][0] = true;
        costVisited[0][0] = Map[0][0];
        queue.offer(new pair(0, 0, Map[0][0]));
        pair tempPair;
        int cX, cY, cCost, nX, nY;
        while (!queue.isEmpty()) {
            tempPair = queue.poll();
            cX = tempPair.x;
            cY = tempPair.y;
            cCost = tempPair.cost;

            if (cX == size - 1 && cY == size - 1) {
                minCost = Math.min(minCost, cCost);
            }

            for (int[] eachM : move) {
                nX = cX + eachM[0];
                nY = cY + eachM[1];
                if (nX < 0 || nY < 0 || nX >= size || nY >= size) continue;
                if (visited[nX][nY] && costVisited[nX][nY] <= cCost + Map[nX][nY]) continue;
                visited[nX][nY] = true;
                costVisited[nX][nY] = cCost + Map[nX][nY];
                queue.offer(new pair(nX, nY, costVisited[nX][nY]));
            }
        }
    }
}


// DFS -> 모든 경로를 찾을 때 마다 Cost 최적화? => 매우 많은 연산량이 요구되어, N이 7만 되어도 시간 초과 발생

    /* DFS Implementation
    public static void getCost(int x, int y, int size, int cost) {
        int[][] move = { {1, 0}, {0, -1}, {-1, 0}, {0, 1} };
        if (x == size - 1 && y == size - 1) {
            minCost = Math.min(minCost, cost);
            return;
        }
        int nextX, nextY;
        for (int[] eachM : move) {
            nextX = x + eachM[0];
            nextY = y + eachM[1];
            if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size) continue;
            if (visited[nextX][nextY]) continue;
            visited[nextX][nextY] = true;
            getCost(nextX, nextY, size, cost + Map[nextX][nextY]);
            visited[nextX][nextY] = false;
        }
    }
    */

// BFS -> 최단 이동 경로를 찾을 때 마다 Cost 최적화?
/* BFS Implementation 724ms
public static void getCost(int size) {
        int[][] move = { {1, 0}, {0, -1}, {-1, 0}, {0, 1} };
        Queue<pair> queue = new ArrayDeque<>();
        visited[0][0] = true;
        costVisited[0][0] = Map[0][0];
        queue.offer(new pair(0, 0, Map[0][0]));
        pair tempPair;
        int cX, cY, cCost, nX, nY;
        while (!queue.isEmpty()) {
            tempPair = queue.poll();
            cX = tempPair.x;
            cY = tempPair.y;
            cCost = tempPair.cost;

            if (cX == size - 1 && cY == size - 1) {
                minCost = Math.min(minCost, cCost);
            }

            for (int[] eachM : move) {
                nX = cX + eachM[0];
                nY = cY + eachM[1];
                if (nX < 0 || nY < 0 || nX >= size || nY >= size) continue;
                if (visited[nX][nY] && costVisited[nX][nY] <= cCost + Map[nX][nY]) continue;
                visited[nX][nY] = true;
                costVisited[nX][nY] = cCost + Map[nX][nY];
                queue.offer(new pair(nX, nY, costVisited[nX][nY]));
            }
        }
    }
 */

/* Check the elapsedTime
        long startTime = System.currentTimeMillis();
        Map = new int[125][125];
        visited = new boolean[125][125];
        costVisited = new int[125][125];
        Random random = new Random();
        for (int i = 0; i < 125; i++) {
            for (int j = 0; j < 125; j++) {
                Map[i][j] = random.nextInt(10);
                costVisited[i][j] = Integer.MAX_VALUE;
            }
        }
        minCost = Integer.MAX_VALUE;
        getCost(125);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed Time in milliseconds: " + elapsedTime);
        System.out.println(minCost);
 */


// Dijkstra Algorithm -> 생각되는 가장 빠른 Method!


// Dynamic Programming => Graph가 DAG가 아니면 DP로 풀 수 없다?