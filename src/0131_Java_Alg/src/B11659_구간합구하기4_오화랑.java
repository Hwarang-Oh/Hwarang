import java.util.*;
import java.io.*;

public class BOJ_11659_HR {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());	
		int numCnt = Integer.parseInt(st.nextToken());
		int sumCnt = Integer.parseInt(st.nextToken());
		int [] sumArray = new int [numCnt + 1];
		st = new StringTokenizer(input.readLine());	
		
		int sum = 0;
		for (int i = 1 ; i <= numCnt ; i++) {
			sum += Integer.parseInt(st.nextToken());
			sumArray[i] = sum;
		}
		
		int start; int end;
		for (int j = 0 ; j < sumCnt ; j++) {
			st = new StringTokenizer(input.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			System.out.println(sumArray[end] - sumArray[start -1]);
		}
	}
}
