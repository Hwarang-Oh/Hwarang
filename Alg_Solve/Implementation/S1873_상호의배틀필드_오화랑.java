import java.io.*;
import java.util.*;


public class S1873_상호의배틀필드_오화랑 {
	static int currX, currY, row, col, moveDir;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1 ; tc <= testCase ; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(input.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			map = new char[row][col];

			for (int i = 0 ; i < row ; i++) map[i] = input.readLine().toCharArray();
			int optNum = Integer.parseInt(input.readLine());
			char[] optList = input.readLine().toCharArray();
			
			for (int i = 0 ; i < row ; i++) {
				for (int j = 0 ; j < col ; j++) {
					switch (map[i][j]) {
						case '^' : currX = i; currY = j; moveDir = 0; break;
						case 'v' : currX = i; currY = j; moveDir = 1; break;
						case '<' : currX = i; currY = j; moveDir = 2; break;
						case '>' : currX = i; currY = j; moveDir = 3; break;
					}
				}
			}
			
			for (int i = 0 ; i < optNum ; i++) Move(optList[i]);
			
			for (int i = 0 ; i < row ; i++) {
				for (int j = 0 ; j < col ; j++)
					sb.append(map[i][j]);
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
	public static void Move(char opt) {
		int[][] search = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} }; // 상 하 좌 우
		char[] dirList = {'^', 'v', '<', '>'};
		int nextX, nextY;
		if (opt == 'S') {
			nextX = currX; nextY = currY;
			while (true) {
				nextX += search[moveDir][0];
				nextY += search[moveDir][1];
				if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) break;
				if (map[nextX][nextY] == '#') break;
				if (map[nextX][nextY] == '*') {
					map[nextX][nextY] = '.';
					break;
				}
			}
		}
		else {
			switch (opt) {
				case 'U' : moveDir = 0; break;
				case 'D' : moveDir = 1; break;
				case 'L' : moveDir = 2; break;
				case 'R' : moveDir = 3; break;
			}
			map[currX][currY] = dirList[moveDir];
			nextX = currX + search[moveDir][0];
			nextY = currY + search[moveDir][1];
			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) return;
			if (map[nextX][nextY] != '.') return;
			map[currX][currY] = '.';
			currX = nextX; currY = nextY;
			map[currX][currY] = dirList[moveDir];
		}
	}
}
