import java.util.ArrayDeque;
import java.util.Queue;

public class A0206_QueueAPITest {

	public static void main(String[] args) {
		Queue<String> queue = new ArrayDeque<>(); // vector로부터 상속받은 add Method도 존재

		System.out.println(queue.isEmpty() + "//" + queue.size());
		queue.offer("카리나");
		queue.offer("최예나");
		queue.offer("홍은채");
		queue.offer("설윤");
		queue.offer("윈터");
		queue.offer("배유빈");

		System.out.println(queue.isEmpty() + "//" + queue.size());
		queue.offer("이나경");
		queue.offer("세은");

		System.out.println(queue.peek());
		System.out.println(queue.isEmpty() + "//" + queue.size());

		System.out.println(queue.poll());
		System.out.println(queue.isEmpty() + "//" + queue.size());
		System.out.println("===========================================");
		while(!queue.isEmpty())
			System.out.println(queue.poll());
	}

}