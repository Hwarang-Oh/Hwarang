import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] adjMatrix = new int[V][V];
		for (int i = 0 ; i < E ; i++ ) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from]= adjMatrix[from][to] = 1;

		}
		
//		for (int [] row : adjMatrix) {
//			System.out.println(Arrays.toString(row));
//		}
		
		bfs(adjMatrix, 0);
		bfs2(adjMatrix, 0);
	}
	static void bfs(int[][] adjMatrix, int start) {
		int V = adjMatrix.length;
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
			visited[current] = true;
			System.out.print((char)(current + 65) + " ");
			
			for (int i = 0 ; i < V ; i++) {
				if (adjMatrix[current][i] != 0 && !visited[i]) {
					queue.offer(i);
//					visited[i] = true;
				}
			}
		}
	}
}
