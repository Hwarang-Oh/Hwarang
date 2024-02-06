import java.util.*;
import java.io.*;

public class B2164_Ä«µå2_¿ÀÈ­¶û {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int cardNum = Integer.parseInt(input.readLine());
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for (int i = 0 ; i < cardNum ; i++) {
			queue.offer(i + 1);
		}
		
		int num1 = 0, num2 = 1;
		while (queue.size() > 1) {
			num1 = queue.poll();
			num2 = queue.poll();
			queue.offer(num2);
		}
		System.out.println(num2);
	}
}
