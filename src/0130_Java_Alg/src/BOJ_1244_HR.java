import java.io.*;
import java.util.*;

public class BOJ_1244_HR {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int switchNum = Integer.parseInt(input.readLine());
		int[] switchArr = new int [switchNum];
		StringTokenizer st = new StringTokenizer(input.readLine());
		
		for (int i = 0 ; i < switchNum ; i++)
			switchArr[i] = Integer.parseInt(st.nextToken());
		
		int changeNum = Integer.parseInt(input.readLine());
		
		for (int i = 0 ; i < changeNum ; i++) {
			st = new StringTokenizer(input.readLine());
			int gen = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken()) - 1;
			switchArr = change(switchArr, gen, point);
		}
		
		for (int j = 1 ; j <= switchNum ; j++) {
			System.out.printf("%d ", switchArr[j-1]);
			if ((j) % 20 == 0)
				System.out.println();
		}	
	}
	
	public static int[] change(int[] switchArr, int gen, int point) {
		if (gen == 1)
			switchArr = boyChange(switchArr, point);
		else 
			switchArr = girlChange(switchArr, point);
		
		return switchArr;
	}

	public static int[] girlChange(int[] switchArr, int point) {
		for (int i = 0; i < switchArr.length ; i++) {
			if (point - i < 0 | point + i >= switchArr.length)
				break;
			if (switchArr[point - i] == switchArr[point + i]) {
				if (switchArr[point - i] == 1) {
					switchArr[point - i] = 0;
					switchArr[point + i] = 0;
				}
				else {
					switchArr[point - i] = 1;
					switchArr[point + i] = 1;
				}
			}
			else
				break;
		}
		return switchArr;
	}
	
	public static int[] boyChange(int[] switchArr, int point) {
		for (int i = point + 1 ; i <= switchArr.length ; i++) {
			if (i % (point+1) == 0) {
				if (switchArr[i-1] == 1)
					switchArr[i-1] = 0;
				else
					switchArr[i-1] = 1;
			}
		}
		return switchArr;
	}
}
