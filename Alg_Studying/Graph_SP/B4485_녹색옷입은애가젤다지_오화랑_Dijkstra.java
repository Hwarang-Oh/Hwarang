import java.io.*;
import java.util.*;

public class B4485_녹색옷입은애가젤다지_오화랑_Dijkstra {
    static class pair {
        int x, y, cost;
        public pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    static int[][] Map;
    static int[][] dist;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(input.readLine());
        int TC = 1;
        while(size != 0) {
            Map = new int[size][size];
            dist = new int[size][size];
            visited = new boolean[size][size];
            for (int i = 0 ; i < size ; i++) {
                st = new StringTokenizer(input.readLine());
                for (int j = 0 ; j < size; j++) {
                    Map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = 160_000; // maxDist : 156_250 = 125 * 125 * 10
                }
            }
            Dijkstra(size);
            sb.append("Problem ").append(TC++).append(": ").append(dist[size - 1][size - 1]).append("\n");
            // nextSize 갱신
            size = Integer.parseInt(input.readLine());
        }
        System.out.println(sb);
    }
    public static void Dijkstra(int size) {
        int move[][] = { {1, 0}, {0, -1}, {-1, 0}, {0, 1} };
        dist[0][0] = Map[0][0];
        PriorityQueue<pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new pair(0, 0, dist[0][0]));

        pair temp;
        int nX, nY;
        while (!pq.isEmpty()) {
            temp = pq.poll();
            if (visited[temp.x][temp.y]) continue;
            visited[temp.x][temp.y] = true;

            if (temp.x == size - 1 && temp.y == size - 1) break;

            for (int[] eachM : move) {
                nX = temp.x + eachM[0];
                nY = temp.y + eachM[1];
                if (nX < 0 || nY < 0 || nX >= size || nY >= size) continue;
                if (visited[nX][nY]) continue;
                if (dist[nX][nY] <= dist[temp.x][temp.y] + Map[nX][nY]) continue;
                dist[nX][nY] = dist[temp.x][temp.y] + Map[nX][nY];
                pq.offer(new pair(nX, nY, dist[nX][nY]));
            }
        }
    }
}