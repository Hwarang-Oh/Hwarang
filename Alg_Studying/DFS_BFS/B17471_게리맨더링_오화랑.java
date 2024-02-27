import java.io.*;
import java.util.*;

public class B17471_게리맨더링_오화랑 {
	
	static int[][] graph;
	static int[] pNumList;
	static boolean[] visited;
	static int minDiff = Integer.MAX_VALUE;
	static boolean canCal;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int dNum = Integer.parseInt(input.readLine());
		pNumList = new int[dNum + 1];
		graph = new int[dNum + 1][];
		visited = new boolean[dNum];
		
		st = new StringTokenizer(input.readLine());
		for (int i = 1 ; i <= dNum ; i++) pNumList[i] = Integer.parseInt(st.nextToken());
		
		int adjNum;
		for (int i = 1 ; i <= dNum ; i++) {
			st = new StringTokenizer(input.readLine());
			adjNum = Integer.parseInt(st.nextToken());
			graph[i] = new int[adjNum];
			for (int j = 0 ; j < adjNum ; j++) graph[i][j] = Integer.parseInt(st.nextToken());
		}
		gerryMandering(dNum, 0);
		if (canCal) System.out.println(minDiff);
		else System.out.println(-1);
		
	}
	
	public static void gerryMandering(int dNum, int cnt) { // 지역구가 짝수로 들어오면, 중복이 생길 수 있는 Code 형태
		if (cnt == dNum) {
			int redPeople = 0;
			int bluePeople = 0;
			ArrayList<Integer> red = new ArrayList<>();
			ArrayList<Integer> blue = new ArrayList<>();
			for (int i = 0 ; i < dNum ; i++) {
				if(visited[i]) { red.add(i + 1); redPeople += pNumList[i + 1]; }
				else { blue.add(i + 1); bluePeople += pNumList[i + 1]; }
			}
			if (red.size() <= dNum/2 && red.size() != 0) {
				if(doubleBFS(dNum, red, blue)) {
					canCal = true;
					minDiff = Math.min(minDiff, Math.abs(redPeople - bluePeople));
				}
			}
			return;
		}
		visited[cnt] = true;
		gerryMandering(dNum, cnt + 1);
		
		visited[cnt] = false;
		gerryMandering(dNum, cnt + 1);
	}
	
	public static boolean doubleBFS(int dNum, ArrayList<Integer> red, ArrayList<Integer> blue) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] isV = new boolean[dNum + 1];
		Arrays.fill(isV, true); 
		for (int i : red) isV[i] = false;
		queue.offer(red.get(0));
		isV[red.get(0)] = true;
		
		int redCount = 0;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			redCount++;
			for (int i = 0 ; i < graph[current].length ; i++) {
				if(isV[graph[current][i]]) continue;
				queue.offer(graph[current][i]);
				isV[graph[current][i]] = true;
			}
		}
		if (redCount < red.size()) return false;
		
		isV = new boolean[dNum + 1];
		Arrays.fill(isV, true); for (int i : blue) isV[i] = false;
		queue.offer(blue.get(0));
		isV[blue.get(0)] = true;
		
		int blueCount = 0;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			blueCount++;
			for (int i = 0 ; i < graph[current].length ; i++) {
				if(isV[graph[current][i]]) continue;
				queue.offer(graph[current][i]);
				isV[graph[current][i]] = true;
			}
		}
		if (blueCount < blue.size()) return false;
		return true;
	}
}