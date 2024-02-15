import java.util.Arrays;
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
		
		for (Node node : adjList) {
			System.out.println(node);
		}
	}
}
