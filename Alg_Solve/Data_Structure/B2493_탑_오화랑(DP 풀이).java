import java.io.*;
import java.util.*;

public class B2493_탑_오화랑 {
	static int[] meetPoint;
	static int[] towers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(input.readLine());
		towers = new int[num + 1];
		meetPoint = new int[num + 1];
		
		StringTokenizer st = new StringTokenizer(input.readLine());	
		for (int i = 1 ; i <= num ; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
			if (towers[i] < towers[i-1]) {
				sb.append(i - 1).append(" ");
				meetPoint[i] = i - 1;
			}
			if (towers[i] > towers[i-1])
				check(i - 1, i);
 		}
		System.out.println(sb);
	}
	
	public static void check(int index, int target) {
		if (towers[meetPoint[index]] > towers[target]) {
			meetPoint[target] = meetPoint[index];
			sb.append(meetPoint[index]).append(" ");
			return;
		} else if (meetPoint[index] == 0) {
			meetPoint[target] = 0;
			sb.append(meetPoint[index]).append(" ");
			return;
		} else
			check(meetPoint[index], target);
	}
}

// Stack을 이용한 구현 -> 의미있는 Tower의 크기들만 Stack에 집어넣는 것 
// stack을 뚜렷하게 쓰게되는 문제! 
