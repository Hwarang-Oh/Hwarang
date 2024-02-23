import java.util.*;
import java.io.*;

public class PRIM_Test {

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
