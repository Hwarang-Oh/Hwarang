import java.io.*;
import java.util.*;

public class B2631_줄세우기_오화랑 {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int vertex = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		
		for (int i = 0 ; i <= vertex ; i++)
			graph.add(new ArrayList<>());
		
		int st1, st2;
		for (int i = 0 ; i < edge ; i++) {
			st = new StringTokenizer(input.readLine());
			st1 = Integer.parseInt(st.nextToken());
			st2 = Integer.parseInt(st.nextToken());
			
			graph.get(st1).add(st2);
		}
		System.out.println(graph);
		
	}
	public static void sort(int vertex) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for (int i = 1 ; i <= vertex ; i++) {
			queue.offer(graph[])
		}
		
	}

}

// 아이들의 수 N이 주어진다. ( N : 200 )
// 1 ~ N까지의 숫자가 한 줄에 하나씩 주어진다.
// 3 7 5 2 6 1 4 -> 1 2 3 4 5 6 7
// 번호 순서대로 줄을 세우자

// _ _ _ _ _ _ _ 