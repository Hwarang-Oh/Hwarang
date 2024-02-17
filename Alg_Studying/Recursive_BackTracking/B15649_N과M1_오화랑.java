import java.io.*;
import java.util.*;

public class BOJ_15649_HR {
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int range = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		
		isSelected = new boolean[range + 1];
		numbers = new int [length];
		permutate(range, length, 0);
		System.out.println(sb.toString());
	}
	
	public static void permutate(int range, int length, int cnt) {
		if (cnt == length) {
			for (int number : numbers) {
				sb.append(number + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1 ; i <= range ; i++) {
			if (isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			permutate(range, length, cnt + 1);
			isSelected[i] = false;
		}
	}
}
	

