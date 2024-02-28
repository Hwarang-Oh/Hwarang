import java.io.*;
import java.util.*;

public class T0228_¿ÀÈ­¶û_TopoSort {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[] inDegree = new int [V];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
		Collections.fill(graph, new ArrayList<>());
		
		int v1, v2;
		for (int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(input.readLine());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			inDegree[v2]++;
			graph.get(v1).add(v2);
			System.out.print(sb);
		}
		
	}
	public static void TopoSort(ArrayList<ArrayList<Integer>> graph, int V, int[] inDegree) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visitedSort = new boolean[V + 1];
		
		for (int i = 1; i <= V ; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
				visitedSort[i] = true;
			}
		}
		
		int currV;
		while(!queue.isEmpty()) {
			currV = queue.poll();
			for (int nextV : graph.get(currV)) {
				if (visitedSort[nextV]) continue;
				inDegree[nextV]--;
				
				if(inDegree[nextV] == 0) {
					queue.offer(nextV);
					visitedSort[nextV] = true;
				}
			}
			sb.append(currV).append(" ");
		}
	}

}
