import java.io.*;
import java.util.*;

public class S1767_프로세서연결하기_오화랑 {
	
	
	static int[][] core;
	static ArrayList<int[]> point;
	static boolean[] visited;
	static int minCost = Integer.MAX_VALUE;
	static int maXconnected;
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int size = Integer.parseInt(input.readLine());
		core = new int[size][size];
		visited = new boolean[size];
		point = new ArrayList<>();
		
		int each;
		for (int i = 0 ; i < size ; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0 ; j < size ; j++) {
				each = Integer.parseInt(st.nextToken());
				if ((i == 0 || j == 0) && each == 1) core[i][j] = 2;
				else core[i][j] = each;
				if (core[i][j] == 1) point.add(new int [] {i,j});
			}
		}
		connect(0);
		System.out.println(minCost);
	}
	
	public static void connect(int cnt) {
		if (cnt == point.size()) {
			
			ArrayList<int []> temp = new ArrayList<>();
			for (int i = 0 ; i < point.size(); i++) {
				if (visited[i]) temp.add(point.get(i));
			}
			
			find(temp, 0);
			return;
		}
		visited[cnt] = true;
		connect(cnt + 1);
		visited[cnt] = false;
		connect(cnt + 1);
	}
	
	public static void find(ArrayList<int[]> temp, int cnt) {
		if (cnt == temp.size()) {
			minCost = Math.min(minCost, countLine());
			return;
		}
		
		for (int i = 0 ; i < 4 ; i++) {
			coloring(temp.get(cnt), i, cnt + 5, connected);
			find(temp, cnt + 1);
			decoloring(temp.get(cnt), i, cnt + 5, connected);
		}
	}

	public static void coloring(int[] loc, int way, int color) {
		int[][] search = { {1,0}, {0,1}, {-1,0}, {0,-1}};
		int nextX = loc[0];
		int nextY = loc[1];
		
		while (true) {
			nextX += search[way][0];
			nextY += search[way][1];
			
			if (nextX == 0 || nextY == 0 || nextX == core.length - 1 || nextY == core.length - 1) {
				if (core[nextX][nextY] == 0) { 
					core[nextX][nextY] = color;
					connected++;
					break;
				}
				else { decoloring(loc, way, color); break; }
			}
			if (core[nextX][nextY] != 0) { decoloring(loc,way, color); break; }
			core[nextX][nextY] = color;
		}
	}
	
	
	public static void decoloring(int[] loc, int way, int color) {
		int[][] search = { {1,0}, {0,1}, {-1,0}, {0,-1}};
		int nextX = loc[0];
		int nextY = loc[1];
		while (true) {
			nextX += search[way][0];
			nextY += search[way][1];
			if (core[nextX][nextY] == color) core[nextX][nextY] = 0;
			else return;
		}
	}
	
	
	public static int countLine() {
		int lineCount = 0;
		for (int i = 0 ; i < core.length ; i++) {
			for (int j = 0 ; j < core.length ; j++) {
				if (core[i][j] == 3) lineCount++;
			}
		}
		return lineCount;
	}
}
