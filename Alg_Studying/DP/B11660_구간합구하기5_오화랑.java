import java.util.*;
import java.io.*;

public class BOJ_11660_HR {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(st.nextToken());
		int sumCnt = Integer.parseInt(st.nextToken());
		int [][] numArr = new int [size + 1][size + 1];
		
		int sum;
		for (int i = 1 ; i <= size ; i++) {
			st = new StringTokenizer(input.readLine());
			sum = 0;
			for (int j = 1 ; j <= size ; j++) {
				sum += Integer.parseInt(st.nextToken());
				numArr[i][j] = numArr[i-1][j] + sum;
			}
		}
		
		int x1_row, x1_col, x2_row, x2_col;
		int totalSum, minusRow, minusCol, plusArea, result;
		for (int j = 0 ; j < sumCnt ; j++) {
			st = new StringTokenizer(input.readLine());
			x1_row = Integer.parseInt(st.nextToken());
			x1_col = Integer.parseInt(st.nextToken());
			x2_row = Integer.parseInt(st.nextToken());
			x2_col = Integer.parseInt(st.nextToken());
			totalSum = numArr[x2_row][x2_col];
			minusRow = numArr[x1_row - 1][x2_col];
			minusCol = numArr[x2_row][x1_col -1];
			plusArea = numArr[x1_row -1][x1_col - 1];

			result = totalSum - minusRow - minusCol + plusArea;
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
