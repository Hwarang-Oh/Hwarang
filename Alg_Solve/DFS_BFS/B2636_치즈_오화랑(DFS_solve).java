import java.io.*;
import java.util.*;

public class B2636_치즈_오화랑 {
	static int cheeseCount, timeCount, row, col;

	static boolean isMelt;
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		int[][] cheese = new int[row][col];
		
		for (int i = 0 ; i < row ; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0 ; j < col ; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			for(int i = 0 ; i < row ; i++) {
				for(int j = 0 ; j < col ; j++) {
					switch (cheese[i][j]) {
						case -1 : cheese[i][j] = 0; break;
						case 2 : { 
							cheese[i][j] = 0;
							cheeseCount++;
							break;}
					}
				}
			}
			melt(cheese, 0,0);
			if (!isMelt) break;
			isMelt = false;
			timeCount++;
			cheeseCount = 0;
		}
		System.out.println(timeCount);
		System.out.println(cheeseCount);
	}
	public static void melt(int[][] cheese, int currX, int currY) {
		int[][] searchMethod = {
				{-1, 0}, {1, 0}, {0, -1}, {0, 1}
		};
		cheese[currX][currY] = -1;
		
		int nextX, nextY;
		for (int[] search : searchMethod) {
			nextX = currX + search[0];
			nextY = currY + search[1];
			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
			if (cheese[nextX][nextY] == 1) { isMelt = true; cheese[nextX][nextY] = 2; continue; }
			if (cheese[nextX][nextY] == 0) melt(cheese, nextX, nextY);
		}
	}

}
