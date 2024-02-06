import java.io.*;
import java.util.*;

public class BOJ_1149_HR {
	static int[][] eachCost;
	static int[][] getTotal;
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(input.readLine());
		eachCost = new int[num][3];
		getTotal = new int[num][3];
		StringTokenizer st;
		for (int i = 0 ; i < num ; i++) {
			st = new StringTokenizer(input.readLine());
			eachCost[i][0] = Integer.parseInt(st.nextToken());
			eachCost[i][1] = Integer.parseInt(st.nextToken());
			eachCost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		getTotal[0][0] = eachCost[0][0];
		getTotal[0][1] = eachCost[0][1];
		getTotal[0][2] = eachCost[0][2];
	}
	
	public static int DP(int cnt, int color) {
		if (getTotal[cnt][color] == 0) {
			
			if (color == 0)
				getTotal
			
		}
	}

}
// 1 ~ N번 집이 순서대로 있다.
// 1번과 2번 집의 색은 다르다.
// N번과 N-1번의 집의 색은 다르다.
// 2 <= i <= N-1번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
// N개 줄에는 각 집을 빨강 초록 파랑으로 칠하는 비용이 1줄로 
/*
6
30 19 5
64 77 64
15 19 97
4 71 57
90 86 84
93 32 91
*/

/*
3
1 100 100
100 1 100
100 100 1
*/