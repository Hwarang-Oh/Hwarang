import java.io.*;
import java.util.*;

public class BOJ_14503_HR {
	static int row, col, cleanCnt;
	static int[][] room;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(input.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		room = new int[row][col];
		
		st = new StringTokenizer(input.readLine());
		int sRow = Integer.parseInt(st.nextToken());
		int sCol = Integer.parseInt(st.nextToken());
		int sDir = Integer.parseInt(st.nextToken());
		
		for (int i = 0 ; i < row ; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0 ; j < row ; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
	}
	public static void clean(int sRow, int sCol, int sDir) {
		cleanCnt++;
		
		int tempX, tempY;
		boolean canGo = false;
		
		for (int i = 0 ; i < 4 ; i++) {
			tempX = sRow + dx[i];
			tempY = sCol + dy[i];
			if (tempX < 0 | tempX >= row | tempY < 0 | tempY >= col)
				continue;
			if (room[tempX][tempY] == 0)
				canGo = true;
		}
		
		switch (sDir) {
			case 0: { 
				tempX = sRow + dx[3]; tempY = sCol + dy[3];
				if (tempX < 0 | tempX >= row | tempY < 0 | tempY >= col)
					
				
			}
				
		}
			
		if (canGo) {
			switch (sDir) {
				case 0 : tempX = sRow + dx[3] ; tempY = sCol + dy[3]; break; // ºÏ -> ¼­
				case 1 : tempX = sRow + dx[0] ; tempY = sCol + dy[0]; break; // µ¿ -> ºÏ
				case 2 : tempX = sRow + dx[1] ; tempY = sCol + dy[1]; break; // ³² -> µ¿
				case 3 : tempX = sRow + dx[2] ; tempY = sCol + dy[2]; break; // ¼­ -> ³²
			}
			if (tempX < 0 | tempX >= row | tempY < 0 | tempY >= col) {
				
			}

	

}
