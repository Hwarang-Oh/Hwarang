
/*
 * 사실 문제를 읽다보면 풀이 방식이 보이는 문제
 * 주어진 문제 조건 + 제약 조건 (V <= 100, E <= 100)을 고려하면 Floyd-Warshall Algorithm이 가장 적합한 풀이
 * 
 */
import java.io.*;
import java.util.*;

public class B14938_서강그라운드_오화랑 {
    static int[][] graph;
    static int MAX = 1500;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] itemList = new int[N + 1];
        graph = new int[N + 1][N + 1];
        st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) { // Graph Init
            itemList[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(graph[i], MAX);
            graph[i][i] = 0;
        }

        int v1, v2, c;
        for (int i = 1; i <= R; i++) { // Graph Input
            st = new StringTokenizer(input.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[v1][v2] = graph[v2][v1] = c;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int tMax, cMax;
        tMax = 0;
        for (int i = 1; i <= N; i++) {
            cMax = 0;
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] <= M)
                    cMax += itemList[j];
            }
            tMax = Math.max(tMax, cMax);
        }
        System.out.println(tMax);
    }
}
