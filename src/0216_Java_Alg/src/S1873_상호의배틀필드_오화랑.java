import java.io.*;
import java.util.*;


public class S1873_상호의배틀필드_오화랑 {
	static int currX, currY, row, col, moveDir;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		StringTokenizer st = new StringTokenizer(input.readLine());
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
		
		for (int i = 0 ; i < row ; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println(currX);
		System.out.println(currY);
		System.out.println(moveDir);
		System.out.println(Arrays.toString(optList));
		
		for (int i = 0 ; i < optNum ; i++) {
			Move(optList[i]);
		}
		
		for (int i = 0 ; i < row ; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
	}
	public static void Move(char opt) {
		switch (opt) {
			case 'U' : moveDir = 0; break;
			case 'D' : moveDir = 1; break;
			case 'L' : moveDir = 2; break;
			case 'R' : moveDir = 3; break;
		}
		
		int[][] search = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} }; // 상 하 좌 우
		char[] dirList = {'^', 'v', '<', '>'};
		
		int nextX, nextY;
		switch (opt) {
			case 'U' :
			case 'D' :
			case 'L' :
			case 'R' : {
				map[currX][currY] = dirList[moveDir];
				nextX = currX + search[moveDir][0];
				nextY = currY + search[moveDir][1];
				
				if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) break;
				if (map[nextX][nextY] != '.') break;
				
				map[currX][currY] = '.';
				currX = nextX; currY = nextY;
				map[currX][currY] = dirList[moveDir];
				break;
			}
			case 'S':
				while (true) {
					nextX = currX + search[moveDir][0];
					nextY = currY + search[moveDir][1];
					if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) break;
					if (map[nextX][nextY] == '#') break;
					if (map[nextX][nextY] == '*') {
						map[nextX][nextY] = '.';
						break;
					}
				}
		}
				
	}
}
