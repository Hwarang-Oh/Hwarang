import java.io.*;
import java.util.*;

public class BOJ_15649_HR {
	
	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int range = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		
		
		int maxCnt = getCnt(range, length);
		boolean[] isSelected = new boolean[range + 1];
		
	}
	
	public static int getCnt(int range, int length) {
		int maxCnt = 1;
		for (int i = 0 ; i < length ; i++) {maxCnt *= range--;}
		return maxCnt;
	}
	
	public static void permute(int length, int range, int cnt) {
		if (cnt == length) {
			System.out.println(numbers);
			numbers.clear();
			break;
		}


		}
	}
}
	

