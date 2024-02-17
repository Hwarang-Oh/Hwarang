import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

// 무향 그래프 : 연결리스트 버전
public class AdjListTest {
	static class Node {
		int to;
		Node next;
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
		
		public Node(int to) {
			this.to = to;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", next=" + next + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		Node[] adjList = new Node[V]; // 각 정점의 인접리스트 Head 저장, 굳이 뒤로 들어갈 필요 없음 ( 맨 앞에 세우고, 갱신해주면 됨 )
		for (int i = 0 ; i < E ; i++ ) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to, adjList[from]); // 어떤 경우에도 반드시 바로 앞에 할 수 있는 코드 잘 알고 있기!!
			adjList[to] = new Node(from, adjList[to]);
		}
		
//		for (Node node : adjList) {
//			System.out.println(node);
//		}
		bfs(adjList, 0);
	}
	static void bfs(Node[] adjList, int start) {
		int V = adjList.length;
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
			
			for (Node temp = adjList[current] ; temp != null ; temp = temp.next) {
				if (!visited[temp.to]) { // 방문체크만!
					queue.offer(temp.to);
					visited[temp.to] = true;
				}
			}
		}
	}
}
