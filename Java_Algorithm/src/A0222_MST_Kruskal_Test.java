import java.io.*;
import java.util.*;

/*
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1
-> 10
 */
public class A0222_MST_Kruskal_Test {
	static class Edge implements Comparable<Edge> {
		// Edge List를 만들ㅇ어낼 수 있는 Edge Class 설정
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
		} // 간선 리스트 생성 -> 인접 행렬, 리스트 처럼 뒤집을 필요 X
		
		// 전처리 : 간선 리스트 오름차순 정렬
		Arrays.sort(edgeList);
		
		// Union Find Alg 적용하기! // 1. make - set
		makeSet();
		
		// 2. 정렬된 간선 하나씩 꺼내어서 신장트리르 생성한다. ( MST )
		int weight = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if (!union(edge.from, edge.to)) continue; // v1과 v2의 Union 시도
			weight += edge.weight;
			if (++cnt == V - 1) break; // 최소신장트리 완성
		}
		System.out.println(weight);

	}
	public static void makeSet() {
		parents = new int[V]; // 자신의 부모나 루트를 저장 ( Path Compression )
		for (int i = 0 ; i < V ; i++)
			parents[i] = i; // 모든 정점을 자신을 대표자로
	}
	public static int find(int a) { // a가 속한 트리의 루트 찾기
		if (a == parents[a]) return a; // 본인이 대표자, 뿌리의 시작이면 return a;
		return parents[a] = find(parents[a]); // 나의 부모를, 대표자로 바꿔버림 ( 경로 압축 )
	}
	public static boolean union(int a, int b) {
		int aRoot = find(a); int bRoot = find(b); 
		if (aRoot == bRoot) return false; // a, b의 Root가 같으면, false 반환 -> Union 불가
		parents[bRoot] = aRoot; // 여젼하게 편향된 트리의 발생 가능성이 일어날 수 있음. (랭크 관리가 없기 때문)
		return true;
	}
}
