import java.io.*;
import java.util.*;

public class B1916_최소비용구하기_오화랑2 {
    static class edge {
        int to, cost;
        public edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    static ArrayList<ArrayList<edge>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(input.readLine());
        int M = Integer.parseInt(input.readLine());
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        graph = new ArrayList<>(N + 1);
        for (int i = 0 ; i <= N ; i++) {
            graph.add(new ArrayList<>());
            dist[i] = 100_000_000;
        } // dist Array INIT

        int v1, v2, cost;
        for (int e = 0 ; e < M ; e++) {
            st = new StringTokenizer(input.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new edge(v2, cost));
        } // graph Representation with Adjacency List
        st = new StringTokenizer(input.readLine());
        int sV = Integer.parseInt(st.nextToken()); // start Vertex
        int eV = Integer.parseInt(st.nextToken()); // end Vertex

        // Dijkstra Algorithm
        dist[sV]= 0;
        for (edge each : graph.get(sV)) dist[each.to] = Math.min(dist[each.to], each.cost);

        int currMinDist;
        for (int i = 1 ; i <= N - 1 ; i++) {
            visited[sV] = true;
            // get smallest dist Node
            currMinDist = 100_000_000;
            for (int n = 1 ; n <= N ; n++) {
                if (visited[n]) continue;
                if (dist[n] < currMinDist) {
                    sV = n;
                    currMinDist = dist[n];
                }
            }
            for (edge each : graph.get(sV)) {
                if (visited[each.to]) continue;
                dist[each.to] = Math.min(dist[each.to], dist[sV] + each.cost);
            }
        }
        System.out.println(dist[eV]);
    }
}


// weight가 존재해도, 정점의 수 N과 간선의 수 E가 작다면 BFS로 풀어낼 수 있긴 하다. ( BOJ 4485 )
// 이번 문제는 정점의 수는 1000개로 많지 않음. But 간선의 수가 많은 상황이다.
// 각 정점당 뻗어나갈 수 있는 간선의 수가 평균적으로 100개 정도 된다.
// 이런 경우에는 어떻게 풀어내야 할까?
// 음수의 간선이 존재하지 않고, Start -> End 형태의 Shortest Path 문제는 Dijkstra Algorithm이 효율적

/* Dijkstra with ArrayList
        dist[sV]= 0;
        for (edge each : graph.get(sV)) dist[each.to] = Math.min(dist[each.to], each.cost);

        int currMinDist;
        while (!visited[sV]) {
            visited[sV] = true;
            currMinDist = 100_000_000;
            for (int i = 1 ; i <= N ; i++) {
                if (visited[i]) continue;
                if (dist[i] < currMinDist) {
                    sV = i;
                    currMinDist = dist[i];
                }
            }
            for (edge each : graph.get(sV)) {
                if (visited[each.to]) continue;
                dist[each.to] = Math.min(dist[each.to], dist[sV] + each.cost);
            }
        }
        System.out.println(dist[eV]);
 */