import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
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
		dist[sV] = 0;
		PriorityQueue<edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.add(new edge(sV, dist[sV]));


		while (!pq.isEmpty()) {
			edge temp = pq.poll();
			if (visited[temp.to]) continue;
			visited[temp.to] = true;

			if (temp.to == eV) break;

			for (edge Edge : graph.get(temp.to)) {
				if (visited[Edge.to]) continue;
				if (dist[Edge.to] <= dist[temp.to] + Edge.cost) continue;
				dist[Edge.to] = dist[temp.to] + Edge.cost;
				pq.offer(new edge(Edge.to, dist[Edge.to]));
			}
		}
		System.out.println(dist[eV]);
	}
}