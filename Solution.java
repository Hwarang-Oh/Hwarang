import java.io.*;
import java.util.*;

public class Solution {
	static int[][] Map;
	static boolean[][] visited;
	static int R, C;
	static boolean canGo;
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int testCase = Integer.parseInt(input.readLine());
	
		for (int t = 1 ; t <= testCase ; t++) {
			st = new StringTokenizer(input.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			Map = new int[R][C];
			visited = new boolean[R][C];
			canGo = false;
			
			// Map 입력받기 + start / end
			int startX = R - 1; int startY = 0;
			int tarX, tarY;
			tarX = tarY = 0;
			for (int i = 0 ; i < R ; i++) {
				st = new StringTokenizer(input.readLine());
				for (int j = 0 ; j < C ; j++) {
					Map[i][j] = Integer.parseInt(st.nextToken());
					if (Map[i][j] == 3) { tarX = i; tarY = j; }
				}
			}
			
			int hardCount = 0;
			for (int i = 1 ; i < R ; i++) {
				checkHard(startX, startY, tarX, tarY, i);
				if (canGo) {
					hardCount = i;
					break;
				}
				visited = new boolean[R][C];
			}
			System.out.printf("#%d %d%n", t, hardCount);
		}
	}
	
	public static void checkHard(int currX, int currY, int tX, int tY, int hard) {
		int[][] moveM = { {1,0}, {-1,0}, {0,1}, {0, -1} };
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(currX); queue.offer(currY);
		visited[currX][currY] = true;
		
		int cX, cY, nextX, nextY;
		while (!queue.isEmpty()) {
			if (canGo) break;
			cX = queue.poll();
			cY = queue.poll();
			for (int i = 0 ; i < 4 ; i++) {
				if (i == 0 || i == 1) {
					for (int j = 1 ; j <= hard ; j++) {
						nextX = cX + j * moveM[i][0];
						nextY = cY + j * moveM[i][1];
						if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) break;
						if (Map[nextX][nextY] == 0) continue;
						if (Map[nextX][nextY] == 1 && !visited[nextX][nextY]) { 
							queue.offer(nextX); queue.offer(nextY);
							visited[nextX][nextY] = true;
							break;
						}
						if (Map[nextX][nextY] == 3) canGo = true;
					}
				}
				else {
					nextX = cX + moveM[i][0];
					nextY = cY + moveM[i][1];
					if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
					if (Map[nextX][nextY] == 0) continue;
					if (Map[nextX][nextY] == 1 && !visited[nextX][nextY]) { 
						queue.offer(nextX); queue.offer(nextY);
						visited[nextX][nextY] = true;
					}
					if (Map[nextX][nextY] == 3) canGo = true;
				}
			}
		}
	}
}
