import java.io.*;
import java.util.*;


public class B1916_최소비용구하기_오화랑 {
    static class adjV {
        int vertex;
        int weight;

        public adjV(int vertex, int weight) {
            super();
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int V = Integer.parseInt(input.readLine());
        int E = Integer.parseInt(input.readLine());

        ArrayList<ArrayList<adjV>> graph = new ArrayList<>();
        for (int i = 0 ; i <= V ; i++) graph.add(new ArrayList<>());


        for (int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(input.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new adjV(v2, w));
        }

        st = new StringTokenizer(input.readLine());
        int source = Integer.parseInt(st.nextToken());
        int sink = Integer.parseInt(st.nextToken());

        // dist Array 초기화!
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Dijkstra(source, sink, graph, dist);
    }

    public static void Dijkstra(int source, int sink, ArrayList<ArrayList<adjV>> graph, int[] dist) {
        // step 1
        boolean[] visited = new boolean[graph.size()];
        visited[source] = true;
        int visitCount = 1;
        dist[source] = 0;
        for(adjV eachV : graph.get(source)) {
            if (dist[eachV.vertex] > eachV.weight) dist[eachV.vertex] = eachV.weight;
        }

        while (visitCount != visited.length - 1) {
            int currMinV = 0;
            for (int i = 1 ; i <= dist.length - 1 ; i++) {
                if(dist[currMinV] > dist[i] && !visited[i]) currMinV = i;
            }
            visited[currMinV] = true;
            visitCount++;
            for (adjV eachV : graph.get(currMinV)) {
                if (visited[eachV.vertex]) continue;
                dist[eachV.vertex] = Math.min(dist[eachV.vertex], dist[currMinV] + eachV.weight);
            }
        }
        System.out.println(dist[sink]);
    }
}
