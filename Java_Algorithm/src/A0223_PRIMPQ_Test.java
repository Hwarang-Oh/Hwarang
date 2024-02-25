import java.util.*;
import java.io.*;

public class A0223_PRIMPQ_Test {
	static class Vertex implements Comparable<Vertex> {
		int no, weight;
		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(in.readLine());
		int[][] adjMatrix = new int[V][V];
		boolean[] visited = new boolean[V];
		int[] minEdge = new int[V];
		
		StringTokenizer st = null;
		for (int i = 0 ; i < V ; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0 ; j < V ; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0;
		int result = 0;
		pq.offer(new Vertex(0,minEdge[0]));

		int c = 0;
		while (pq.isEmpty()) {
			Vertex minVertex = pq.poll();
			if (visited[minVertex.no]) continue;

			result += minVertex.weight;
			visited[minVertex.no] = true;
			if(++c == V) break;
			
			for (int i = 0 ; i < V ; i++) {
				if (!visited[i] && adjMatrix[minVertex.no][i] != 0 &&
						adjMatrix[minVertex.no][i] < minEdge[i]) {
					minEdge[i] = adjMatrix[minVertex.no][i];
					pq.offer(new Vertex(i, minEdge[i]));
				}
			}
		}
		System.out.println(c == V? result : -1);
	}
}

// PQ를 쓰는게 항상 유리한 것은 아니다. 계속계속 갱신이 되버리면 어떻게 할 것인가?
// 잘 판단해서 그때그때 맞는 전략을 택해야 한다.

