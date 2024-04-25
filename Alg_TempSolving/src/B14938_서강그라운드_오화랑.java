/*
 * 사실 문제를 읽다보면 풀이 방식이 보이는 문제
 * 주어진 문제 조건 + 제약 조건 (V <= 100, E <= 100)을 고려하면 Floyd-Warshall Algorithm이 가장 적합한 풀이
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        for (int i = 1; i <= N; i++) {
            itemList[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(graph[i], MAX);
            graph[i][i] = 0;
        }

        int v1, v2, c;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(input.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[v1][v2] = graph[v2][v1] = c;
        }

        int[][] dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = graph[i].clone();
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][i]);
                }
            }
        }
        for (int i = 0; i <= N; i++)
            System.out.println(Arrays.toString(dist[i]));
    }
}
