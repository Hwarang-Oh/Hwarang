import java.io.*;
import java.util.*;

public class B1149_RGB거리_오화랑 {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(input.readLine());
		int[][] eachCost = new int[num][3];
		int[][] getTotal = new int[num][3];
		StringTokenizer st = new StringTokenizer(input.readLine());

		getTotal[0][0] = eachCost[0][0] = Integer.parseInt(st.nextToken());
		getTotal[0][1] = eachCost[0][1] = Integer.parseInt(st.nextToken());
		getTotal[0][2] = eachCost[0][2] = Integer.parseInt(st.nextToken());

		for (int i = 1 ; i < num ; i++) {
			st = new StringTokenizer(input.readLine());
			eachCost[i][0] = Integer.parseInt(st.nextToken());
			eachCost[i][1] = Integer.parseInt(st.nextToken());
			eachCost[i][2] = Integer.parseInt(st.nextToken());

			getTotal[i][0] = Math.min(getTotal[i-1][1] + eachCost[i][0], getTotal[i-1][2] + eachCost[i][0]);
			getTotal[i][1] = Math.min(getTotal[i-1][0] + eachCost[i][1], getTotal[i-1][2] + eachCost[i][1]);
			getTotal[i][2] = Math.min(getTotal[i-1][0] + eachCost[i][2], getTotal[i-1][1] + eachCost[i][2]);
		}
		Arrays.sort(getTotal[num - 1]);
		System.out.println(getTotal[num-1][0]);
	}
}
// N개의 집 존재
// 2 ~ N - 1번 사이의 모든 집은 앞집 뒷집과 색이 같지 않음.
// 각각의 집을 R / G / B로 칠하는 비용이 주어짐
// 앞집 뒷집과 색이 같지 않다는 조건을 활용하여 최소 비용 구하기
// 전략 : 앞쪽에서 최선의 선택이 항상 좋은 결과를 불러올까? -> X
/*
3
100 100 1
1000 1000 1
1 1 10000
 */
// => Greedy : 1 -> 1000 -> 2000
// => Best : 100 -> 1 -> 2000
// 나의 선택이 영향을 미치는 것은 바로 뒷 단계의 집고르기 뿐!
// 집이 2개일 때 선택의 Best부터 계속 저장해가면서 와야 한다.

/*
3
26 40 83
49 60 57
13 89 99
 */

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
1 100 100 -> R
100 1 100 -> G
100 100 1 -> B
*/