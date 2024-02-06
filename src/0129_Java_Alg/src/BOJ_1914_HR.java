import java.util.*;
import java.io.*;

public class BOJ_1914_HR {
	static StringBuilder result = new StringBuilder();
	static int moveCnt;
	static long moveCnt2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(input.readLine());
		if (cnt < 20) {
			hanoi(cnt, 1, 2, 3);
			System.out.println(moveCnt);
			System.out.println(result);
		} else {
			hanoi2(cnt, 1, 2, 3);
			System.out.println(moveCnt2);
		}
	}
	public static void hanoi(int cnt, int from, int temp, int to) {
		if (cnt == 0) return;
		moveCnt++;
		hanoi(cnt - 1, from, to, temp);
		result.append(from).append(" ").append(to).append("\n");
		hanoi(cnt - 1, temp, from, to);
	}
	public static void hanoi2(int cnt, int from, int temp, int to) {
		if (cnt == 0) return;
		moveCnt2++;
		hanoi2(cnt - 1, from, to, temp);
		hanoi2(cnt - 1, temp, from, to);
	}
}

// 5개를 옮기는 상황 ~= 4개 ~= 3개 ~= 2개 ~= 1개

// 1
// 1 3

// 2
// 1 2
// 1 3
// 2 3

// 3
// 1 3
// 1 2
// 3 2
// 1 3
// 2 1
// 2 3
// 1 3