import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

// 완전이진트리 - 배열 구현
// 크기 늘리지 않는 버전
public class A0208_CBT<T> {
	private Object[] nodes;
	private final int SIZE;
	private int lastIndex; // Last 저장 Index
	private ArrayList<Integer> thresHold = new ArrayList<Integer>();
	private int nodeCnt = 0;

	public A0208_CBT(int size) { // 완전이진트리로 입력이 들어온다.
		SIZE = size;
		nodes = new Object[size + 1];

//		int temp = 1;
//		while (true) {
//			if (size < temp)
//				break;
//			thresHold.add(temp);
//			temp *= 2;
//		}
	}

	public boolean isEmpty() {
		return lastIndex == 0;
	}

	public boolean isFull() { // 크기를 늘리지 않는 개념이라 가능한 isFull() Method
		return lastIndex == SIZE;
	}

	public void add(T e) {
		if (isFull()) { // 예외를 던져도 되고, 다음과 같이 안내문도 괜찮음.
			System.out.println("포화");
			return;
		}
		nodes[++lastIndex] = e;
	}

	public void bfs() { // Queue에 넣는 것이 방문한 것이 아니라, Queue에서 나오는 것이 방문한 것이다.
		if (isEmpty()) return; // Root Node 한개 정도는 있어야 한다.
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1); // 방문할 노드를 관리할 값 넣기 => Node 번호 Index

		while(!queue.isEmpty()) { // 방문할 대상이 있는 동안 반복
			int current = queue.poll();
			System.out.println(nodes[current]); // Node 처리로직

			// 왼쪽 자식 노드, 오른쪽 자식 노드
			if (current*2 <= lastIndex) queue.offer(current*2);
			if (current * 2 + 1<= lastIndex) queue.offer(current* 2 + 1);
		}
	}

	// Queue에 탐색할 Node 번호와 너비를 함께 넣기
	public void bfs2() {
		if (isEmpty()) return; //Root 한개는 있어야 한다.
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {1,0}); // 방문할 노드를 관리할 값 넣기 -> {nodeIndex , 너비}

		while(!queue.isEmpty()) {
			int[] currentInfo = queue.poll();
			int current = currentInfo[0];
			int breadth = currentInfo[1];
			System.out.println(breadth + ":" + nodes[current]); // Node 처리로직


			// 왼쪽 자식 노드, 오른쪽 자식 노드
			if (current*2 <= lastIndex) queue.offer(new int[] {current*2, breadth + 1});
			if (current * 2 + 1<= lastIndex) queue.offer(new int[] {current* 2 + 1, breadth + 1});
		}
	}

	// 동일 너비 단위로 처리 => 해야 하는 순간이 올 수 있을 것이다
	public void bfs3() {
		if (isEmpty()) return; //Root 한개는 있어야 한다.
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1); // 방문할 노드를 관리할 값 넣기 -> {nodeIndex , 너비}

		int breadth = 0; // 너비 변수를 다로 관리!
		while(!queue.isEmpty()) {
			int size = queue.size(); // Queue Size 체크 : 동일 너비의 탐색 대상 Node의 개수
			System.out.println("breadth " + breadth + " : ");
			while (--size >= 0) {
				int current = queue.poll();
				System.out.print(breadth + ":" + nodes[current] + "\t"); // Node 처리로직
				// 왼쪽 자식 노드, 오른쪽 자식 노드
				if (current*2 <= lastIndex) queue.offer(current*2);
				if (current * 2 + 1<= lastIndex) queue.offer(current* 2 + 1);
			}
			++breadth; // 다음 탐색을 위한 너비 변수 추가
			System.out.println();
		}
	}
	public void dfsByPreorder() {
		if (isEmpty()) return;
		System.out.println("===Preorder===");
		dfsByPreorder(1);
		System.out.println();
	}

	private void dfsByPreorder(int current) { // BFS 코드에서 부모가 나오고, 왼쪽 오른쪽을 Queue에 넣는 과정과 Same! (FLAT)
		// Method를 호출하는 Stack으로 탐색 순서를 관리함 -> 결국 Queue로 탐색 관리하는 것과 결은 같음.
		// BFS의 current가 매개변수로 가주어야 함
		System.out.print(nodes[current] + "\t"); // Node 처리로직

		// 부모 -> 왼쪽 자식 노드 -> 오른쪽 자식 노드
		if (current*2 <= lastIndex) dfsByPreorder(current * 2);
		if (current * 2 + 1<= lastIndex) dfsByPreorder(current * 2 + 1);
	}

	public void dfsByInorder() {
		if (isEmpty()) return;
		System.out.println("===Inorder===");
		dfsByInorder(1);
		System.out.println();
	}

	private void dfsByInorder(int current) { // BFS 코드에서 부모가 나오고, 왼쪽 오른쪽을 Queue에 넣는 과정과 Same! (FLAT)
		// Method를 호출하는 Stack으로 탐색 순서를 관리함 -> 결국 Queue로 탐색 관리하는 것과 결은 같음.
		// BFS의 current가 매개변수로 가주어야 함

		// 왼쪽 자식 노드 -> 부모 -> 오른쪽 자식 노드
		if (current*2 <= lastIndex) dfsByInorder(current * 2);
		System.out.print(nodes[current] + "\t"); // Node 처리로직
		if (current * 2 + 1<= lastIndex) dfsByInorder(current * 2 + 1);
	}

	public void dfsByPostorder() {
		if (isEmpty()) return;
		System.out.println("===Postorder===");
		dfsByPostorder(1);
		System.out.println();
	}

	private void dfsByPostorder(int current) { // BFS 코드에서 부모가 나오고, 왼쪽 오른쪽을 Queue에 넣는 과정과 Same! (FLAT)
		// Method를 호출하는 Stack으로 탐색 순서를 관리함 -> 결국 Queue로 탐색 관리하는 것과 결은 같음.
		// BFS의 current가 매개변수로 가주어야 함

		// 왼쪽 자식 노드 -> 오른쪽 자식 노드 -> 부모 Node
		if (current*2 <= lastIndex) dfsByPostorder(current * 2);
		if (current * 2 + 1<= lastIndex) dfsByPostorder(current * 2 + 1);
		System.out.print(nodes[current] + "\t"); // Node 처리로직
	}

	private void dfsByPostorder2(int current) { // BFS 코드에서 부모가 나오고, 왼쪽 오른쪽을 Queue에 넣는 과정과 Same! (FLAT)
		// Method를 호출하는 Stack으로 탐색 순서를 관리함 -> 결국 Queue로 탐색 관리하는 것과 결은 같음.
		// BFS의 current가 매개변수로 가주어야 함
		if (current > lastIndex) return;

		// 왼쪽 자식 노드 -> 오른쪽 자식 노드 -> 부모 Node
		dfsByPostorder2(current * 2);
		dfsByPostorder2(current * 2 + 1);
		System.out.print(nodes[current] + "\t"); // Node 처리로직
	}
}


// 자식 노드를 탐색할 때, Queue의 사이즈가 늘어난다.
// 0인 친구가 빠져나갈 때 너비가 1인 친구들이 들어옴.

// 빼내기 전의 Size가 동일 너비를 가지고 있는 개수 => 동일 너비의 탐색 대상들이 Queue에 들어가 있다.
// Queue size => 1일때 너비가 0인거 1개
// Queue Size => 2일때 너비 1인거 2개
// Queue Size => 4일때 너비 2인거 4개
// 이중 while문 => 동일 너비에 대한 묶은 처리가 가능함.


// 1 2 4 8