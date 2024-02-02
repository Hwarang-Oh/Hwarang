import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class StackAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>(); // vector로부터 상속받음 ( vector는 List의 구현체 ) => push랑 add 모두 같음.
		Queue<String> queue = new ArrayDeque<String>();
		
		System.out.println(queue.isEmpty() + "//" + queue.size());
		queue.offer("오화랑");
		queue.offer("카리나");
		queue.offer("최예나");
		System.out.println(queue.isEmpty() + "//" + queue.size());
		queue.offer("카즈하");
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty() + "//" + queue.size());
//		System.out.println(stack.pop());
//		System.out.println(stack.isEmpty() + "//" + stack.size());
		System.out.println("================================");
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
			System.out.println(queue.isEmpty() + "//" + queue.size());
		}
	}

}

// 마이쮸 : Queue문제  : 마지막 마이쮸의 획득 개수와 누가 가져가는지 Counting