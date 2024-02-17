import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

// 완전이진트리 - 배열 구현
// 크기 늘리지 않는 버전
public class CBT<T> {
	private Object[] nodes;
	private final int SIZE;
	private int lastIndex;
	private ArrayList<Integer> thresHold = new ArrayList<Integer>(); 
	private int nodeCnt = 0;
	
	public CBT(int size) { // 완전이진트리로 입력이 들어온다.
		SIZE = size;
		nodes = new Object[size + 1];
		
		int temp = 1;
		while (true) {
			if (size < temp)
				break;
			thresHold.add(temp);
			temp *= 2;
		}
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(T e) {
		if (isFull()) {
			System.out.println("포화");
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	public void bfs() { // Queue에 넣는 것이 방문한 것이 아니라, Queue에서 나오는 것이 방문한 것이다. 
		if (isEmpty()) return; //Root 한개는 있어야 한다.
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1); // 방문할 노드를 관리할 값 넣기
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(nodes[current]); // Node 처리로직
			
			// 왼쪽 자식 노드, 오른쪽 자식 노드 
			if (current*2 <= lastIndex) queue.offer(current*2);
			if (current * 2 + 1<= lastIndex) queue.offer(current* 2 + 1);
		}
	}
	
	public void bfs2() { // Queue에 넣는 것이 방문한 것이 아니라, Queue에서 나오는 것이 방문한 것이다. 
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
	
	public void bfs3() { // Queue에 넣는 것이 방문한 것이 아니라, Queue에서 나오는 것이 방문한 것이다. 
		if (isEmpty()) return; //Root 한개는 있어야 한다.
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1); // 방문할 노드를 관리할 값 넣기 -> {nodeIndex , 너비}
		
		int breadth = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			System.out.println("breadth " + breadth + " : ");
			while (--size >= 0) {
				int current = queue.poll();
				System.out.print(breadth + ":" + nodes[current] + "\t"); // Node 처리로직
				// 왼쪽 자식 노드, 오른쪽 자식 노드 
				if (current*2 <= lastIndex) queue.offer(current*2);
				if (current * 2 + 1<= lastIndex) queue.offer(current* 2 + 1);
			}
			++breadth;
			System.out.println();
		}
	}
}
// 자식 노드를 탐색할 때, Queue의 사이즈가 늘어난다.
// 0인 친구가 빠져나갈 때 너비가 1인 친구들이 들어옴.

// 빼내기 전의 Size가 동일 너비를 가지고 있는 개수 => 동일 너비의 탐색 대상들이 Queue에 들어가 있다. 
// Queue size => 1일때 너비가 0인거 1개
// Queue Size => 2일때 너비 1인거 2개
// Queue Size => 4일때 너비 2인거 4개 
// 이중 for문 => 동일 너비에 대한 묶은 처리가 가능함. 


// 1 2 4 8 