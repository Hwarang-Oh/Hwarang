import java.io.*;
import java.util.*;

public class B16435_스네이크버드_오화랑 {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int numF = Integer.parseInt(st.nextToken());
		int snakeBird = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> heightList = new PriorityQueue<>(numF);
		
		st = new StringTokenizer(input.readLine());
		for (int i = 0 ; i < numF ; i++) heightList.offer(Integer.parseInt(st.nextToken()));
		
		while (!heightList.isEmpty()) {
			if (snakeBird >= heightList.poll()) snakeBird++;
			else break;
		}
		System.out.println(snakeBird);
	}
}

// 스네이크 버드는 자신보다 작거나 같은 과일을 먹을 수 있음. => 먹을수록 성장
// 본인만 성장하기 때문에, 어떠한 경우에도 본인보다 작은 과일은 반드시 먹을 수 있음.