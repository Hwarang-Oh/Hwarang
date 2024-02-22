import java.io.*;
import java.util.*;

public class B15683_감시_오화랑 {
	static int[][] search = { {-1,0}, {0,1}, {1,0}, {0,-1} };
	static int minCount = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int[][] room = new int[row][col];
		ArrayList<int []> cctvList = new ArrayList<>();
		
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
		coloring(0, cctvList, room);
		System.out.println(minCount);
	}
	public static void coloring(int cnt, ArrayList<int []> cctvList, int[][] room) {
		if (cnt == cctvList.size()) {
			minCount = Math.min(minCount,count(room));
			return;
		}
		int cctvNum = cctvList.get(cnt)[0];
		int currX = cctvList.get(cnt)[1];
		int currY = cctvList.get(cnt)[2];

		// 현재 room Array는 보관하고, tempRoom Array를 다음 재귀로 넘겨준다.
		int[][] tempRoom = new int[room.length][room[0].length];

		int nextX, nextY;
		// 4개의 search Method로 탐색한다.
		for (int i = 0 ; i < 4 ; i ++) {
			for (int r = 0 ; r < room.length ; r++){
				for (int c = 0 ; c < room[0].length ; c++)
					tempRoom[r][c] = room[r][c];
			}
			switch (cctvNum) {
				case 5 : nextX = currX; nextY = currY;
					int nextFind5 = i + 3;
					if (nextFind5 >= 4) nextFind5 -= 4;
					while (true) {
						nextX += search[nextFind5][0]; nextY += search[nextFind5][1];
						if (nextX < 0 || nextY < 0 || nextX >= room.length || nextY >= room[0].length) break;
						if (tempRoom[nextX][nextY] == 6) break;
						if (tempRoom[nextX][nextY] == 0) tempRoom[nextX][nextY] = -1;
					}
				case 4 : nextX = currX; nextY = currY;
					int nextFind4 = i + 2;
					if (nextFind4 >= 4) nextFind4 -= 4;
					while (true) {
						nextX += search[nextFind4][0]; nextY += search[nextFind4][1];
						if (nextX < 0 || nextY < 0 || nextX >= room.length || nextY >= room[0].length) break;
						if (tempRoom[nextX][nextY] == 6) break;
						if (tempRoom[nextX][nextY] == 0) tempRoom[nextX][nextY] = -1;
					}
				case 3 : nextX = currX; nextY = currY;
					int nextFind3 = i + 1;
					if (nextFind3 >= 4) nextFind3 -= 4;
					while (true) {
						nextX += search[nextFind3][0]; nextY += search[nextFind3][1];
						if (nextX < 0 || nextY < 0 || nextX >= room.length || nextY >= room[0].length) break;
						if (tempRoom[nextX][nextY] == 6) break;
						if (tempRoom[nextX][nextY] == 0) tempRoom[nextX][nextY] = -1;
					}
				case 1 : nextX = currX; nextY = currY;
					while (true) {
						nextX += search[i][0]; nextY += search[i][1];
						if (nextX < 0 || nextY < 0 || nextX >= room.length || nextY >= room[0].length) break;
						if (tempRoom[nextX][nextY] == 6) break;
						if (tempRoom[nextX][nextY] == 0) tempRoom[nextX][nextY] = -1;
					}
					coloring(cnt + 1, cctvList, tempRoom);
					break;
				case 2 : nextX = currX; nextY = currY;
					while (true) {
						nextX += search[i][0]; nextY += search[i][1];
						if (nextX < 0 || nextY < 0 || nextX >= room.length || nextY >= room[0].length) break;
						if (tempRoom[nextX][nextY] == 6) break;
						if (tempRoom[nextX][nextY] == 0) tempRoom[nextX][nextY] = -1;
					}
					int nextFind2 = i + 2;
					if (nextFind2 >= 4) nextFind2 -= 4;
					while (true) {
						nextX += search[nextFind2][0]; nextY += search[nextFind2][1];
						if (nextX < 0 || nextY < 0 || nextX >= room.length || nextY >= room[0].length) break;
						if (tempRoom[nextX][nextY] == 6) break;
						if (tempRoom[nextX][nextY] == 0) tempRoom[nextX][nextY] = -1;
					}
					coloring(cnt + 1, cctvList, tempRoom);
			}
		}
	}
	public static int count(int[][] room) {
		int count = 0;
		for (int i = 0 ; i < room.length ; i++) {
			for (int j = 0 ; j < room[0].length ; j++) {
				if (room[i][j] == 0) count++;
			}
		}
		return count;
	}
}