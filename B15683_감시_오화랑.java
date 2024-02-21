import java.io.*;
import java.util.*;

public class B15683_감시_오화랑 {
	static ArrayList<int []> cctvList = new ArrayList<>(8);
	static int row, col;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		int[][] room = new int[row][col];
		
		for (int i = 0 ; i < row ; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0 ; j < col ; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				switch (room[i][j]) {
				case 1: cctvList.add(new int[] {1,i,j}); break;
				case 2: cctvList.add(new int[] {2,i,j}); break;
				case 3: cctvList.add(new int[] {3,i,j}); break;
				case 4: cctvList.add(new int[] {4,i,j}); break;
				case 5: cctvList.add(new int[] {5,i,j}); break;
				}
			}
		}
		coloring(0, room);
//		System.out.println(Arrays.deepToString(room));
	}
	public static void coloring(int cnt, int[][] room) {
		if (cnt == cctvList.size()) {
			System.out.println(Arrays.deepToString(room));
			return;
		}
		
		int[][] search = { {-1,0}, {0,1}, {1,0}, {0,-1} };
		int[][] tempRoom = new int[row][col];
		
		int cctvNum = cctvList.get(cnt)[0];
		int currX = cctvList.get(cnt)[1];
		int currY = cctvList.get(cnt)[2];
		
		if (cctvNum == 1) {
			for (int i = 0 ; i < 4 ; i++) {
				int nextX = currX, nextY = currY;
				for (int j = 0 ; j < row ; j++)
					System.arraycopy(room[j], 0, tempRoom[j], 0, row);
				
				while (true) {
					nextX += search[i][0];
					nextY += search[i][1];
					if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) break;
					if (tempRoom[nextX][nextY] == 6) break;
					if (tempRoom[nextX][nextY] == 0) tempRoom[nextX][nextY] = -1;
				}
				coloring(cnt + 1, tempRoom);
			}
		}
		else if (cctvNum == 2) {
			for (int i = 0 ; i < 4 ; i++) {
				int nextX = currX, nextY = currY;
				for (int j = 0 ; j < row ; j++)
					System.arraycopy(room[j], 0, tempRoom[j], 0, row);
				while (true) {
					nextX += search[i][0];
					nextY += search[i][1];
					if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) break;
					if (tempRoom[nextX][nextY] == 6) break;
					if (tempRoom[nextX][nextY] == 0) tempRoom[nextX][nextY] = -1;
				}
				int nextFind = i + 2;
				if (nextFind >= 4) nextFind -= 4;
				while (true) {
					nextX += search[nextFind][0];
					nextY += search[nextFind][1];
					if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) break;
					if (tempRoom[nextX][nextY] == 6) break;
					if (tempRoom[nextX][nextY] == 0) tempRoom[nextX][nextY] = -1;
				}
				coloring(cnt + 1, tempRoom);
			}
		}
		else if (cctvNum == 3) {
			for (int i = 0 ; i < 4 ; i++) {
				int nextX = currX, nextY = currY;
				for (int j = 0 ; j < row ; j++)
					System.arraycopy(room[j], 0, tempRoom[j], 0, row);
				while (true) {
					nextX += search[i][0];
					nextY += search[i][1];
					if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) break;
					if (tempRoom[nextX][nextY] == 6) break;
					if (tempRoom[nextX][nextY] == 0) tempRoom[nextX][nextY] = -1;
				}
				int nextFind = i + 1;
				if (nextFind >= 4) nextFind -= 4;
				while (true) {
					nextX += search[nextFind][0];
					nextY += search[nextFind][1];
					if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) break;
					if (tempRoom[nextX][nextY] == 6) break;
					if (tempRoom[nextX][nextY] == 0) tempRoom[nextX][nextY] = -1;
				}
				coloring(cnt + 1, tempRoom);
			}
		}
		else if (cctvNum == 4) {
			for (int i = 0 ; i < 4 ; i++) {
				int nextX = currX, nextY = currY;
				for (int j = 0 ; j < row ; j++)
					System.arraycopy(room[j], 0, tempRoom[j], 0, row);
				while (true) {
					nextX += search[i][0];
					nextY += search[i][1];
					if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) break;
					if (tempRoom[nextX][nextY] == 6) break;
					if (tempRoom[nextX][nextY] == 0) tempRoom[nextX][nextY] = -1;
				}
				int nextFind = i + 1;
				if (nextFind >= 4) nextFind -= 4;
				while (true) {
					nextX += search[nextFind][0];
					nextY += search[nextFind][1];
					if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) break;
					if (tempRoom[nextX][nextY] == 6) break;
					if (tempRoom[nextX][nextY] == 0) tempRoom[nextX][nextY] = -1;
				}
				int nextFind2 = i + 2;
				if (nextFind >= 4) nextFind -= 4;
				while (true) {
					nextX += search[nextFind2][0];
					nextY += search[nextFind2][1];
					if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) break;
					if (tempRoom[nextX][nextY] == 6) break;
					if (tempRoom[nextX][nextY] == 0) tempRoom[nextX][nextY] = -1;
				}
				coloring(cnt + 1, tempRoom);
			}
		}
	}
}
		
// 5의 CCTV의 영향력이 매우 강하고 변환할 수 없으므로, 먼저 각인해놓는다.




// CCTV의 최대 개수는 8개를 넘지 않으므로, 조합으로 충분하게 풀 수 있을 것으로 기대된다.
// 1의 경우의수 4
// 2의 경우의수 2
// 3의 경우의 수 4
// 4의 경우의 수 4
// 5의 경우의 수 1
