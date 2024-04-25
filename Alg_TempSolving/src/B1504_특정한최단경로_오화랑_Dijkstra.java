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
    static int INF = 200_000_001; // from 200,000 * 1000
    static PriorityQueue<Integer> distList = new PriorityQueue<>();

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
        Dijkstra(1, V, haveTov1, haveTov2);
        Dijkstra(V, V, haveTov1, haveTov2);
        Dijkstra(haveTov1, V, haveTov1, haveTov2);
        int size = 3;
        int count = 0;
        while (size > 0) {
            if (distList.peek() == INF) {
                count = -1;
                break;
            }
            count += distList.poll();
            size--;
        }
        System.out.println(count);
    }

    public static void Dijkstra(int start, int V, int haveTov1, int haveTov2) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<adjV> PQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        for (adjV each : graph.get(start)) {
            dist[each.next] = each.cost;
            PQ.offer(new adjV(each.next, dist[each.next]));
        }
        dist[start] = 0;
        visited[start] = true;

        adjV temp;
        while (!PQ.isEmpty()) {
            temp = PQ.poll();
            if (visited[temp.next])
                continue;
            visited[temp.next] = true;

            for (adjV each : graph.get(temp.next)) {
                if (visited[each.next])
                    continue;
                if (dist[each.next] <= dist[temp.next] + each.cost)
                    continue;
                dist[each.next] = dist[temp.next] + each.cost;
                PQ.offer(new adjV(each.next, dist[each.next]));
            }
        }
        if (start == 1) {
            distList.offer(dist[haveTov1]);
            distList.offer(dist[haveTov2]);
            distList.offer(dist[V]);
        } else if (start == V) {
            distList.offer(dist[haveTov1]);
            distList.offer(dist[haveTov2]);
        } else
            distList.offer(dist[haveTov2]);

        System.out.println(Arrays.toString(dist));
    }
}

/*
 * for (adjV each : graph.get(temp.next)) {
 * if (visited[each.next]) continue;
 * if (dist[each.next] <= dist[temp.next] + each.cost) continue;
 * dist[each.next] = dist[temp.next] + each.cost;
 * pq.offer(new adjV(each.next, dist[each.next]));
 * }
 * 3 5 4
 * 4 1
 * 3
 * 1 1 v1 v2 N
 * N 1 v1 v2 N
 * v1 1 v1 v2 N
 * 1 ~ v1 1 ~ v2 1 ~ N
 */