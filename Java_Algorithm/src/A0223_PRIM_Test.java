import java.util.*;
import java.io.*;

/*
5
0 5 10 8 7
5 0 5 3 6
10 5 0 1 3
8 3 1 0 1
7 6 3 1 0
=> 10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0
=> 175

 */

public class A0223_PRIM_Test {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine());
		int[][] adjMatrix = new int[V][V]; // 인접 Matrix
		boolean[] visited = new boolean[V]; // 정점 방문 관리
		int[] minEdge = new int[V]; // 비트리 정점 기준 트리 정점과 연결했을 경우 최소 간선 비용
		
		StringTokenizer st = null;
		for (int i = 0 ; i < V ; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0 ; j < V ; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// Step 0 : Min Edge 초기화 (최소값 갱신을 위한, 최대값으로 초기화 해두기)
		
		Arrays.fill(minEdge, Integer.MAX_VALUE); // Max로 초기화
		minEdge[0] = 0;  // 임의의 시작점 0을 위한 처리
		int result = 0; // MST 가중치 비용

		int c;
		for (c = 0 ; c < V ; c++) {
			// step 1 : 비트리 정점 중 최소 간선 비용의 정점 찾기
			int min = Integer.MAX_VALUE;
			int minVertex =-1;
			
			// step 2 : 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점들 과의 간선비용 고려 -> 최적갱신
			for (int i = 0 ; i < V ; i++) {
				if (!visited[i] && minEdge[i] < min) {
					min = minEdge[i];
					minVertex = i;
				}
			}

			if (minVertex == -1) break; // 갱신되지 않은 것 ( MST 생성 불가 )
			result += min; // 간선 비용 누적
			visited[minVertex] = true; // 해당 정점 방문 처리
			
			// step 2 : 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점들과의 간선 비용 최적 업데이트
			for (int i = 0 ; i < V ; i++) {
				if (!visited[i] && adjMatrix[minVertex][i] != 0 &&
						adjMatrix[minVertex][i] < minEdge[i]) { // 해당 조건 잘 이해하기!!
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		System.out.println(c == V ? result : -1);
	}
}
