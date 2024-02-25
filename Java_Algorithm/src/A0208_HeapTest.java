import java.util.PriorityQueue;

public class A0208_HeapTest {
	public static void main(String[] args) {
		
		PriorityQueue<Student> Slist = new PriorityQueue<Student>();
		Slist.offer(new Student("카리나",99));
		Slist.offer(new Student("윈터",90));
		Slist.offer(new Student("최예나", 95));
		Slist.offer(new Student("설윤", 93));
		
		while (!Slist.isEmpty())
			System.out.print(Slist.poll() + " ");
	}
}
// PQ의 작동요소를 잘 이해해보자!!

