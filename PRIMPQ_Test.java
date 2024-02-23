import java.util.*;
import java.io.*;

public class PRIMPQ_Test {
	
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
		Arrays.fill(minEdge, Integer.MAX_VALUE); // 최소값 갱신위해 Max 초기화
		minEdge[0] = 0;  // 임의의 시작점 0을 위해 처리
		int result = 0;
		
		for (int c = 0 ; c < V ; c++) {
			// step 1 : 비트리 정점 중 최소간선비용의 정점 찾기
			int min = Integer.MAX_VALUE;
			int minVertex =-1;
			
			// step 2 : 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점들과의 간선 비용 고려 최적 업데이트
			for (int i = 0 ; i < V ; i++) {
				if (!visited[i] && minEdge[i] < min) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			if (minVertex == -1) break;
			result += min; // 간선비용 누적
			visited[minVertex] = true; // 트리 정점에 포함
			
			// step 2 : 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점들과의 간선 비용 고려 최적 업데이트
			for (int i = 0 ; i < V ; i++) {
				if (!visited[i] && adjMatrix[minVertex][i] != 0 &&
						adjMatrix[minVertex][i] < minEdge[i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
					
			}
		}
	}
}

// 인접리스트로 바꾸면, 인접 여부는 판단하지 않는다!
// 최악의 경우 : 밀집 그래프 -> 계속 갱신이 일어나는 상황 간선 수 만큼 PQ에 들어가는 행위가 일어남.
// 완전 그래프일 때는, PQ쓰지 마라 -> 넣고 빼는 최악이 존재할 수 있음 => 계속 유리한 그런 상황이 존재할 수 있음. 
// PRIM -> 인접 행렬 / 인접 리스트 쓰는 시긴복잡도가 다 다름 => 최악은 결국 간선 개수가 최대일 때

