import java.util.*;

public class A0206_QueuePractice {

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1);
		int[] getMy = new int[22];
		
		int temp = 0;
		for (int i = 1 ; i < 21 ; i++) {
			temp = queue.poll();
			getMy[temp]++;
			queue.offer(temp);
			queue.offer(i + 1);
		}
		System.out.println(temp);
		System.out.println(Arrays.toString(getMy));
	}
}
// 1 out and 1 in 2 in
// 1 out and 1 in 3 in
// 2 out and 2 in 4 in
// 1 out and 1 in 5 in
// 3 out and 3 in 6 in