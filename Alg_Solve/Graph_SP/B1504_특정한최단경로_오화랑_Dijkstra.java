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

        int[] path1_v1_v2 = Dijkstra(1, haveTov1, haveTov2, V);
        int[] pathN_v1_v2 = Dijkstra(V, haveTov1, haveTov2, V);
        int[] pathv1_v2 = Dijkstra(haveTov1, haveTov2, haveTov2, V);

        int pathA = path1_v1_v2[0] + pathv1_v2[0] + pathN_v1_v2[1];
        int pathB = path1_v1_v2[1] + pathv1_v2[0] + pathN_v1_v2[0];
        if (pathA >= INF && pathB >= INF) {
            System.out.println(-1);
        } else
            System.out.println(Math.min(pathA, pathB));
    }

    public static int[] Dijkstra(int start, int end1, int end2, int V) {
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
        return new int[] { dist[end1], dist[end2] };
    }
}

/*
 * 1 v1 v2 N
 * 1 v1 N v2
 * 1 N v1 v2
 * 1 - v1 - v2 - N
 * 1 - v2 - v1 - N
 * 결국 1에서 시작해서 N으로 돌아와야 한다.
 * 
 */