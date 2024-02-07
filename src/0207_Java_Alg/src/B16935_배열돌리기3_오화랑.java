import java.io.*;
import java.util.*;

public class B16935_배열돌리기3_오화랑 {
	static int row, col, temp;
	static int[][] arr;
	static int[][] arrTemp;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		StringBuilder sb = new StringBuilder();
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		int turnNum = Integer.parseInt(st.nextToken());
		arr = new int [row][col];
		
		for (int i = 0 ; i < row ; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0 ; j < col ; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(input.readLine());
		for (int i = 0 ; i < turnNum ; i++) {
			switch (st.nextToken()) {
				case "1": mode1(); break;
				case "2": mode2(); break;
				case "3": mode3(); break;
				case "4": mode4(); break;
				case "5": mode5(); break;
				case "6": mode6(); break;
			}
		}
		
		for (int i = 0 ; i < row ; i++) {
			for (int j = 0 ; j < col ; j++)
				sb.append(arr[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);

	}
	
	public static void mode1() { // Flip upside down
		ArrayList<int[]> temp = new ArrayList<int[]>();
		for (int i = 0 ; i < row/2 ; i++)
			temp.add(arr[i]);
		for (int i = 0 ; i < row ; i++) {
			if (i < row/2)
				arr[i] = arr[row - 1 - i];
			else
				arr[i] = temp.get(row -1 - i);
		}
	}
	
	public static void mode2() { // Left&Right Inversion
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0 ; i < row ; i++) {
			for (int j = 0 ; j < col ; j++) {
				if (j < col/2) {
					temp.add(arr[i][j]);
					arr[i][j] = arr[i][col - 1 - j];
				}
				else
					arr[i][j] = temp.get(col + col/2*(i) - 1 - j);
			}
		}
	}
	
	public static void mode3() { // Right 90Turn
		arrTemp = new int[col][row];
		for (int i = 0 ; i < col ; i++)
			for (int j = 0 ; j < row ; j++)
				arrTemp[i][j] = arr[row - 1 - j][i];
		arr = arrTemp;
		temp = row; row = col; col = temp;
	}
	
	public static void mode4() { // Left 90Turn
		arrTemp = new int[col][row];
		for (int i = 0 ; i < col ; i++)
			for (int j = 0 ; j < row ; j++)
				arrTemp[i][j] = arr[j][col - 1 - i];
		arr = arrTemp;
		temp = row; row = col; col = temp;
	}
	
	public static void mode5() { // Right GroupTurn
		arrTemp = new int[row][col];
		for (int i = 0 ; i < row ; i++) {
			for (int j = 0 ; j < col ; j++) {
				if(i < row/2) {
					if (j < col/2) arrTemp[i][col/2 + j] = arr[i][j]; // 1 -> 2
					else arrTemp[row/2 + i][j] = arr[i][j]; // 2 -> 3
				}
				else { // i >= row/2
					if (j < col/2) arrTemp[i - row/2][j] = arr[i][j]; // 4 -> 1
					else arrTemp[i][j - col/2] = arr[i][j]; // 3 -> 4
				}
			}
		}
		arr = arrTemp;
	}
	
	public static void mode6() { // Right GroupTurn
		arrTemp = new int[row][col];
		for (int i = 0 ; i < row ; i++) {
			for (int j = 0 ; j < col ; j++) {
				if(i < row/2) {
					if (j < col/2) arrTemp[i][j] = arr[i][col/2 + j]; // 2 -> 1
					else arrTemp[i][j] = arr[row/2 + i][j]; // 3 -> 2
				}
				else { // i >= row/2
					if (j < col/2) arrTemp[i][j] = arr[i - row/2][j]; // 1 -> 4
					else arrTemp[i][j] = arr[i][j - col/2]; // 4 -> 3
				}
			}
		}
		arr = arrTemp;
	}
}
