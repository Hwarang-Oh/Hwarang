import java.io.*;
import java.util.*;

public class T0228_¿ÀÈ­¶û {
	
	static int[] made, parents;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(input.readLine());
		int M = Integer.parseInt(input.readLine());
		int[] numbers = new int [N];
		visited = new boolean[N];
		made = new int[M];
		
		st = new StringTokenizer(input.readLine());
		for (int i = 0 ; i < N ; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		
//		perm(0, M, numbers);
//		comb(0, 0, M, numbers);
//		power(0, numbers);
		
		// nextP
//		Arrays.sort(numbers);
//		do {
//			System.out.println(Arrays.toString(numbers));
//		}while(nextP(numbers));
		
		
		// nextC
//		int[] selected = new int[N];
//		for (int i = 0 ; i < M ; i++) selected[N - M + i] = 1;
//		do {
//			int index = 0;
//			for (int i = 0 ; i < N ; i++) {
//				if(selected[i] == 1) made[index++] = numbers[i];
//			}
//			System.out.println(Arrays.toString(made));
//			
//		}while(nextC(selected));
		
		// union Finding
		makeSet(N);
		System.out.println(findSet(1));
		union(1,2); union(2,3);
		System.out.println(findSet(2));
		System.out.println(findSet(3));
		
		// Topology Sort
		
	}
	
	public static void perm(int cnt, int M, int[] numbers) {
		if (cnt == M) {
			System.out.println(Arrays.toString(made));
			return;
		}
		
		for(int i = 0 ; i < numbers.length ; i++) {
			made[cnt] = numbers[i];
			visited[i] = true;
			perm(cnt + 1, M, numbers);
			visited[i] = false;
		}
	}
	public static void comb(int cnt, int start, int M, int[] numbers) {
		if (cnt == M) {
			System.out.println(Arrays.toString(made));
			return;
		}
		for (int i = start ; i < numbers.length ; i++) {
			made[cnt] = numbers[i];
			comb(cnt + 1, i + 1, M, numbers);
		}
	}
	public static void power(int cnt, int[] numbers) {
		if (cnt == numbers.length) {
			ArrayList<Integer> made = new ArrayList<Integer>();
			for (int i  = 0 ; i < numbers.length ; i++) {
				if(visited[i]) made.add(numbers[i]);
			}
			if(made.size() == 0) return;
			System.out.println(made);
			return;
		}
		visited[cnt] = true;
		power(cnt + 1, numbers);
		visited[cnt] = false;
		power(cnt + 1, numbers);
	}
	public static boolean nextP(int[] numbers) {
		final int size = numbers.length;
		
		int target = size - 1;
		while(target > 0 && numbers[target - 1] > numbers[target]) --target;
		if (target == 0) return false;
		
		int swapLoc = size - 1;
		while(numbers[target - 1] > numbers[swapLoc]) --swapLoc;
		swap(numbers, target - 1, swapLoc);
		
		int back = size - 1;
		while(target < back) swap(numbers, target++, back--);
		return true;
	}
	
	public static boolean nextC(int[] selected) {
		final int size = selected.length;
		
		int target = size - 1;
		while(target > 0 && selected[target - 1] >= selected[target]) -- target;
		if(target == 0) return false;
		
		int swapLoc = size - 1;
		while(selected[target - 1] >= selected[swapLoc]) --swapLoc;
		swap(selected, target - 1, swapLoc);
		
		int back = size - 1;
		while(target < back) swap(selected, target++, back--);
		return true;
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}
	
	public static void makeSet(int vNum) {
		parents = new int[vNum  +1];
		for (int i = 1 ; i <= vNum ; i++) parents[i] = i;
	}
	
	public static int findSet(int vNum) {
		if (parents[vNum] == vNum) return vNum;
		else return parents[vNum] = findSet(parents[vNum]);
	}
	
	public static void union(int v1, int v2) {
		int v1Root = findSet(v1);
		int v2Root = findSet(v2);
		if( v1Root == v2Root ) return;
		else parents[v2Root] = v1Root;
	}
}
