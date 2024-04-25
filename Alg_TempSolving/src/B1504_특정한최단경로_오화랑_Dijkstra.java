
/*
 * 최단 경로 문제와 다른 점
 * 최단 경로 -> V : 20,000 E : 300,000 (단방향)
 * v1 -> v2 로 가는 경로가 여러개일 수 있음
 * 
 * 특정한 최단 경로 -> V : 2 ~ 800 , E : 200,000 (양방향)
 * v1 ~ v2 의 경로는 단 1개
 * 1번 이동했던 간선도 다시 이동할 수 있음
 * 1번 정점 -> N번 정점 까지의 Shortest Route
 * 1 ~ v1 => v1 ~ v2 이렇게 최단을 구하면 되지 않을까? -> V1 - V2 경로를 반드시 지나야 하는 것으로 이해해버림 -> 이거 아님
 * 최대 거리 : 2억 -> 굳이 Long 할 필요는 X
 * 1 ~ v1 -> v1 ~ v2 -> v2 ~ V
 * 1 ~ V -> v1, v2을 반드시 지나야 한다.
 */

import java.io.*;
import java.util.*;

public class B1504_특정한최단경로_오화랑_Dijkstra {

    static class adjV { // Adjacency List 구현
        int next, cost;

        public adjV(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<adjV>> graph; // Adjacency List

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        int v1, v2, c;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(input.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new adjV(v2, c));
            graph.get(v2).add(new adjV(v1, c));
        }

        st = new StringTokenizer(input.readLine());
        int haveTov1 = Integer.parseInt(st.nextToken());
        int haveTov2 = Integer.parseInt(st.nextToken());
    }
}
