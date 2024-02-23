import java.io.*;
import java.util.*;


public class MST_Test {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	static int V;
	static Edge[] edgeList;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		
		for (int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		} // 간선 리스트 생성
		
		// 전처리 : 간선리스트 정렬
		Arrays.sort(edgeList);
		
		
		parents = new int[V]; // 자신의 부모 혹은 Root를 저장 (경로 압축 )
		// 1. make - set
		make();
		
		// 2. 정렬된 간선 하나씩 꺼내어 신장트리 생성 
		int weight = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if (!union(edge.from, edge.to)) continue; // v1과 v2의  Union 주기
			weight += edge.weight;
			if (++cnt == V - 1) break;
		}
		System.out.println(weight);

	}
	public static void make() {
		parents = new int[V]; // 자신의 부모 혹은 Root를 저장 (경로 압축 )
		for (int i = 0 ; i < V ; i++) {
			parents[i] = i;
		}
	}
	public static int find(int a) { // a가 속한 Tree의 root 찾기
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]); // 경로 압축
	}
	public static boolean union(int a, int b) {
		int aRoot = find(a); int bRoot = find(b); 
		if (aRoot == bRoot) return false; // a, b가 같은 트리에 속해 있다 -> 불필요
		parents[bRoot] = aRoot;
		return true;
	}

}
