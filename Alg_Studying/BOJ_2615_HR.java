import java.io.*;
import java.util.*;

public class BOJ_2615_HR {
	
	static int[][] Omok = new int[19][19];
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean isBlack;
		boolean isWhite;

		for (int i = 0 ; i < 19 ; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0 ; j < 19 ; j++) {
				Omok[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0 ; i < 19 ; i++) {
			for (int j = 0 ; j < 19 ; j++) {
				if (Omok[i][j] == 1) {
					if (search(1,i,j)) {
						System.out.println(1);
						System.out.printf("%d %d", i + 1, j + 1);
						return;
					}
				}
				else if (Omok[i][j] == 2) {
					if (search(2,i,j)) {
						System.out.println(2);
						System.out.printf("%d %d", i + 1, j + 1);
						return;
					}
				}
			}
		}
		System.out.println(0);
	}

	
	public static boolean search(int color, int i, int j) {
		int[][] searchMethod = {
				{-1, 1}, {1, 0}, {0, 1}, {1, 1}
		};
		
		boolean isWin = false;
		int tempX, tempY, count;
		for(int[] search : searchMethod) {
			tempX = i;
			tempY = j;
			count = 1;
			while (true) {
				tempX += search[0];
				tempY += search[1];
				if (tempX < 0 | tempY < 0 | tempX >= 19 | tempY >= 19)
					break;
				if (Omok[tempX][tempY] == color)
					count++;
				else
					break;
				if (count >= 6)
					break;
			}
			if (count == 5) {
				int backX = i - search[0];
				int backY = j - search[1];
				if ( backX < 0 | backY < 0 | backX >= 19 | backY >= 19 ) {
					isWin = true;
					break;
				}
				if (Omok[backX][backY] != color) {
					isWin = true;
					break;
				}
			}
		}
		return isWin;
	}
}
