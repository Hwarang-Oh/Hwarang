import java.util.*;

/*
7
8
0 1
0 2
0 5
0 6
4 3
5 3
5 4
6 4
 */

/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
 */

public class A0212_AdjMatrixTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] adjMatrix = new int[V][V]; // 0으로 초기화 되어 있는 상태 (인접 X 상태)
		for (int i = 0 ; i < E ; i++ ) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from]= adjMatrix[from][to] = 1; // 무향 - 간선 양방향 처리
		}
		
//		for (int [] row : adjMatrix) {
//			System.out.println(Arrays.toString(row));
//		}
//		bfs(adjMatrix, 0);
//		bfs2(adjMatrix, 0);

		boolean[] visited = new boolean[V];
		dfs(adjMatrix, visited, 0);

	}
	static void bfs(int[][] adjMatrix, int start) {
		int V = adjMatrix.length;

		// Queue와 방문관리 배열 준비
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V];
		
		// 시작정점( 정점 start )큐에 넣고 방문 체크
		queue.offer(start);
		visited[start] = true;
		
		// 방문관리
		while (!queue.isEmpty()) {
			int current = queue.poll(); // 탐색해야 하는 정점 꺼내기
			// 탐색 정점에 관련된 로직 처리
			System.out.print((char)(current + 65) + " ");
			
			for (int i = 0 ; i < V ; i++) {
				if (adjMatrix[current][i] != 0 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	static void bfs2(int[][] adjMatrix, int start) { // 나와서 방문 체크
		int V = adjMatrix.length;
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V];
		
		// 시작정점( 정점 start )큐에 넣고 방문 체크X
		queue.offer(start);
//		visited[start] = true;
		
		// 방문관리
		while (!queue.isEmpty()) {
			int current = queue.poll(); // 탐색해야 하는 정점 꺼내기
			// 탐색 정점에 관련된 로직 처리
			visited[current] = true; // 방문했을 때 체크!
			System.out.print((char)(current + 65) + " ");
			
			for (int i = 0 ; i < V ; i++) {
				if (adjMatrix[current][i] != 0 && !visited[i]) {
					queue.offer(i);
//					visited[i] = true;
				}
			}
		}
	}
	static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		int V = adjMatrix.length;

		visited[current] = true;
		System.out.print((char)(current + 65) + " ");
		for (int i = 0 ; i < V ; i++) {
			if (adjMatrix[current][i] != 0 && !visited[i])
				dfs(adjMatrix, visited, i);
		}
	}
}
