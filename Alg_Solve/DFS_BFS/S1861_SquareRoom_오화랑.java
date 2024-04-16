import java.util.*;
import java.io.*;

public class S1861_SquareRoom_오화랑 {
	static int[][] rooms;
	static int[][] searchMethod = {
			{-1,0}, {0,-1}, {1,0}, {0,1}
	};
	static ArrayList<int[]> result;
	static int currMove;
 	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(input.readLine());
		int size;
		
		for (int tc = 1 ; tc <= testCase ; tc++) {
			size = Integer.parseInt(input.readLine());
			rooms = new int[size][size];
			
			for (int i = 0 ; i < size ; i++) {
				st = new StringTokenizer(input.readLine());
				for (int j = 0 ; j < size ; j++)
					rooms[i][j] = Integer.parseInt(st.nextToken());
			}
			
			result = new ArrayList<int[]>();
			int [] temp;
			for (int i = 0 ; i < size ; i++) {
				for (int j = 0 ; j < size ; j++) {
					temp = new int[2];
					currMove = 1; check(i, j, 1);
					temp[0] = currMove;
					temp[1] = rooms[i][j];
					result.add(temp);
				}
			}
			
			Collections.sort(result, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					int diff = Integer.compare(o2[0], o1[0]);
					return diff != 0 ? diff : Integer.compare(o1[1], o2[1]);
				}});
			sb.append("#").append(tc).append(" ").append(result.get(0)[1]).append(" ").append(result.get(0)[0]).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void check(int x, int y, int moveCnt) {
		// 방문 체크를 하지 않아도 된다. => 중복으로 탐색하는 일은 발생하지 않는다.
		currMove = Math.max(currMove, moveCnt);
		int tempx, tempy;
		for (int[] search : searchMethod) {
			tempx = x + search[0];
			tempy = y + search[1];
			if (tempx < 0 | tempy < 0 | tempx >= rooms.length | tempy >= rooms.length) continue;
			if (rooms[tempx][tempy] - rooms[x][y] == 1) check(tempx, tempy, moveCnt + 1);
		}
	}
}
