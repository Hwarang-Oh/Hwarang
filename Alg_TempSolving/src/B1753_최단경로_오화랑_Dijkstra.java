import java.io.*;
import java.util.*;

public class B1753_최단경로_오화랑 {
    static class adjV {
        int next, cost;
        public adjV(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<adjV>> graph;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int sV = Integer.parseInt(input.readLine());

        graph = new ArrayList<>(V + 1);
        dist = new int[V + 1];
        visited = new boolean[V + 1];
        for (int i = 0 ; i <= V ; i++) {
            graph.add(new ArrayList<>());
            dist[i] = 200_001; // 최대 누적 가중치 200_000 -> 200_001 : INF
        }

        int v1, v2, c;
        for (int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(input.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new adjV(v2, c));
        }

        // Dijkstra Algorithm
        dist[sV] = 0;
        visited[sV] = true;
        PriorityQueue<adjV> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
//        pq.offer(new adjV(sV, dist[sV]));

        for (adjV each : graph.get(sV)) {
            if (dist[each.next] <= each.cost) continue;
            dist[each.next] = each.cost;
            pq.offer(new adjV(each.next, dist[each.next]));
        }

        adjV temp;
        while (!pq.isEmpty()) {
            temp = pq.poll();
            if (visited[temp.next]) continue;
            visited[temp.next] = true;

            for (adjV each : graph.get(temp.next)) {
                if (visited[each.next]) continue;
                if (dist[each.next] <= dist[temp.next] + each.cost) continue;
                dist[each.next] = dist[temp.next] + each.cost;
                pq.offer(new adjV(each.next, dist[each.next]));
            }
        }
        for (int i = 1 ; i <= V ; i++) {
            if (dist[i] == 200_001) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);
    }
}
