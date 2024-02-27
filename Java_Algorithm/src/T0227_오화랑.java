import java.io.*;
import java.util.*;

public class T0227_오화랑 {
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
		
		// 1. 순
//		Permutation(0, M, numbers);
		
		// 2. 조
//		Combination(0, 0, M, numbers);
		
		// 3. 부
//		PowerSet(0,numbers);

		
		// 4. NextP
//		Arrays.sort(numbers);
//		do {
//			System.out.println(Arrays.toString(numbers));
//		} while(NextP(numbers));
		
		// 5. NextC
//		Arrays.sort(numbers);
//		int[] nextCvisited = new int[N];
//		for (int i = M ; i < N ; i++) nextCvisited[i] = 1;
//		
//		int index = 0;
//		do {
//			for (int i = 0 ; i < N ; i++) {
//				if (nextCvisited[i] == 1) made[index++] = numbers[i];
//			}
//			System.out.println(Arrays.toString(made));
//			index = 0;
//		} while(NextC(nextCvisited));
		
		// 6. NextPowerSet
//		Arrays.sort(numbers);
//		int[] nextCvisited;
//		for (int m = 0 ; m < N ; m++) {
//			nextCvisited = new int[N];
//			for (int i = m ; i < N ; i++) {
//				made = new int[N - m];
//				nextCvisited[i] = 1;
//			}
//			int index = 0;
//			do {
//				for (int i = 0 ; i < N ; i++) {
//					if (nextCvisited[i] == 1) made[index++] = numbers[i];
//				}
//				System.out.println(Arrays.toString(made));
//				index = 0;
//			} while(NextC(nextCvisited));
//		}
		
		// 7. union find
		makeSet(N);
		for (int i = 1 ; i <= N ; i++) System.out.println(findSet(i));
		union(1, 2);
		union(2, 3);
		System.out.printf("%d %d", findSet(1), findSet(2));
		
		// 8. Dijkstra => Fighting!!
	}
	
	public static void Permutation(int cnt, int M, int[] numbers) {
		if(cnt == M) {
			System.out.println(Arrays.toString(made));
			return;
		}
		
		for (int i = 0 ; i < numbers.length ; i++) {
			if (visited[i]) continue;
			made[cnt] = numbers[i];
			visited[i] = true;
			Permutation(cnt + 1, M, numbers);
			visited[i] = false;
		}
	}
	
	public static void Combination(int cnt, int start, int M, int[] numbers) {
		if(cnt == M) {
			System.out.println(Arrays.toString(made));
			return;
		}
		for (int i = start ; i < numbers.length ; i++) {
			made[cnt] = numbers[i];
			Combination(cnt + 1, i + 1, M, numbers);
		}
	}
	
	public static void PowerSet(int cnt, int[] numbers) {
		if (cnt == numbers.length) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int i = 0 ; i < numbers.length ; i++) {
				if(visited[i]) temp.add(numbers[i]);
			}
			System.out.println(temp);
			temp.clear();
			return;
		}
		visited[cnt] = true;
		PowerSet(cnt + 1, numbers);
		
		visited[cnt] = false;
		PowerSet(cnt + 1, numbers);
	}
	
	public static boolean NextP(int[] numbers) {
		final int size = numbers.length;
		int target = size - 1;
		
		while (target > 0 && numbers[target - 1] > numbers[target]) --target;
		if (target == 0) return false;
		
		int swapLoc = size - 1;
		while (numbers[target - 1] >= numbers[swapLoc]) --swapLoc;
		swap(numbers, target - 1, swapLoc);
		
		int back = size - 1;
		while(target < back) swap(numbers, target++, back--);
		return true;
	}
	public static boolean NextC(int[] nextCvisited) {
		final int size = nextCvisited.length;
		
		int target = size - 1;
		while(target > 0 && nextCvisited[target - 1] >= nextCvisited[target]) -- target;
		if (target == 0) return false;
		
		int swapLoc = size - 1;
		while(nextCvisited[target - 1] >= nextCvisited[swapLoc]) --swapLoc;
		swap(nextCvisited, target - 1, swapLoc);
		
		int back = size - 1;
		while(target < back) swap(nextCvisited, target++, back--);
		return true;
	}
	public static void swap(int arr[], int num1, int num2) {
		int temp = arr[num1];
		arr[num1] = arr[num2];
		arr[num2] = temp;
	}
	
	public static void makeSet(int num) {
		parents = new int[num + 1];
		for (int i = 1 ; i <= num ; i++) parents[i] = i;
	}
	public static int findSet(int num) {
		if (parents[num] == num) return num;
		else return parents[num] = findSet(parents[num]);
	}
	public static void union(int num1, int num2) {
		int root1 = findSet(num1);
		int root2 = findSet(num2);
		if (root1 == root2) return;
		parents[root2] = root1;
	}
}