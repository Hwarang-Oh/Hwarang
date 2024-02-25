import java.io.*;
import java.util.*;

public class B2252_줄세우기_오화랑 {

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int vertex = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int[] inDegree = new int[vertex + 1];


		for (int i = 0 ; i <= vertex ; i++)
			graph.add(new ArrayList<>());

		int stHigh, stLow;
		for (int i = 0 ; i < edge ; i++) {
			st = new StringTokenizer(input.readLine());
			stHigh = Integer.parseInt(st.nextToken());
			stLow = Integer.parseInt(st.nextToken());
			inDegree[stLow]++;
			graph.get(stHigh).add(stLow);
		}
		sort(vertex, inDegree);
		System.out.print(sb);

	}
	public static void sort(int vertex, int[] inDegree) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visitedSort = new boolean[vertex + 1];

		// InDegree가 0인 vertex부터 탐색의 1순위에 넣기
		for (int i = 1 ; i <= vertex ; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
				visitedSort[i] = true;
			}
		}

		int currV; // 현재 탐색하고 있는 vertex
		while (!queue.isEmpty()) {
			currV = queue.poll();
			for (int nextV : graph.get(currV)) {
				if (visitedSort[nextV]) continue;

				inDegree[nextV]--; // 가장 마지막에 나를 호출한 앞 순서 뒤에 서야 한다.

				if (inDegree[nextV] == 0) {
					queue.offer(nextV);
					visitedSort[nextV] = true;
				}
			}
			sb.append(currV).append(" ");
		}
	}
}