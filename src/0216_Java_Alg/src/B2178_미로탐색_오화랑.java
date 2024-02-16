import java.io.*;
import java.util.*;


public class B2178_미로탐색_오화랑 {
	static boolean[][] visited;
	static int row, col;
	static char[][] maze;
	static int[][] routeCount;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		maze = new char [row][col];
		visited = new boolean[row][col];
		routeCount = new int[row][col];
		
		for (int i = 0 ; i < row ; i++)
			maze[i] = input.readLine().toCharArray();
		
		bfs(0,0);
		System.out.println(routeCount[row-1][col-1] + 1);
	}
	
	public static void bfs(int rowS, int colS) {
		Queue<Integer> queue = new ArrayDeque<>();
		int[][] search = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
		
		queue.offer(rowS); queue.offer(colS);
		visited[rowS][colS] = true;
		
		int tempX, tempY;
		while (!queue.isEmpty()) {
			tempX = queue.poll();
			tempY = queue.poll();
			
			int nextX, nextY;
			for (int i = 0 ; i < 4 ; i++) {
				nextX = tempX + search[i][0];
				nextY = tempY + search[i][1];
				if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
				
				if (maze[nextX][nextY] == '1' && !visited[nextX][nextY]) {
					routeCount[nextX][nextY] = routeCount[tempX][tempY] + 1;
					queue.offer(nextX); queue.offer(nextY);
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}

