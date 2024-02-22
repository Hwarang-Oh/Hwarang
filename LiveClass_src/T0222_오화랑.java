import java.io.*;
import java.util.*;

public class T0222_오화랑 {
	static int[] made;
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
		
		// 순
//		Permutation(0, M, numbers);
		// 조
//		Combination(0, 0, M, numbers);
		// 부
//		PowerSet(0, M, numbers);
		
		// 1. NextP
//		Arrays.sort(numbers);
//		do {
//			System.out.println(Arrays.toString(numbers));
//		} while(NextP(numbers));
		
		
		// 2. NextC
//		int[] nextCVisited = new int[N];
//		for (int i = M ; i < N ; i++)
//			nextCVisited[i] = 1;
//		System.out.println(Arrays.toString(nextCVisited));
//		
//		int index = 0;
//		do {
//			for (int i = 0 ; i < N ; i++) {
//				if (nextCVisited[i] == 1) made[index++] = numbers[i];
//			}
//			System.out.println(Arrays.toString(made));
//			index = 0;
//		} while(NextC(nextCVisited));
		
		// 3. NextPowerSet
		int[] nextCVisited;
		for (int i = 0 ; i < N ; i++) {
			nextCVisited = new int[N];
			for (int j = i ; j < N ; j++) {
				made = new int[N - i];
				nextCVisited[j] = 1;
			}
			int index = 0;
			do {
				for (int s = 0 ; s < N ; s++)
					if (nextCVisited[s] == 1) made[index++] = numbers[s];
				
				System.out.println(Arrays.toString(made));
				index = 0;
			} while(NextC(nextCVisited));
		}
		
		// 4. Union Finding -> 조금 더 복습해야 할 것 같습니다.
		
		
		
	}	
	public static void Permutation(int cnt, int M, int[] numbers) {
		if (cnt == M) {
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
		if (cnt == M) {
			System.out.println(Arrays.toString(made));
			return;
		}
		for (int i = start ; i < numbers.length ; i++) {
			made[cnt] = numbers[i];
			Combination(cnt + 1, i + 1, M, numbers);
		}
	}
	
	public static void PowerSet(int cnt, int M, int[] numbers) {
		if (cnt == numbers.length) {
			int count = 0;
			ArrayList<Integer> temp = new ArrayList<>();
			for (int i = 0 ; i < numbers.length ; i++) {
				if (visited[i]) {
					count++;
					temp.add(i);
				}
			}
			if (count == M)
				System.out.println(temp);
			return;
		}
		visited[cnt] = true;
		PowerSet(cnt + 1, M, numbers);
		
		visited[cnt] = false;
		PowerSet(cnt + 1, M, numbers);
	}
	
	public static boolean NextP(int[] numbers) {
		final int size = numbers.length;
		
		int target = size - 1;
		while (target > 0 && numbers[target - 1] > numbers[target]) -- target;
		if (target == 0) return false; // Last 순열 -> false!
		
		int swapLoc = size - 1;
		while(numbers[target - 1] >= numbers[swapLoc]) --swapLoc;
		
		swap(numbers, target - 1, swapLoc);
		int back = size - 1;
		while (target < back) swap(numbers, target++, back--);
		return true;
	}
	
	public static boolean NextC(int[] visited) {
		final int size = visited.length;
		
		int target = size - 1; // NextC와 NextP의 차이점을 잘 알아두어야 한다. 
		while (target > 0 && visited[target - 1] >= visited[target]) -- target;
		if (target == 0) return false; // Last 순열 -> false!
		
		int swapLoc = size - 1;
		while(visited[target - 1] >= visited[swapLoc]) --swapLoc;
		
		swap(visited, target - 1, swapLoc);
		int back = size - 1;
		while (target < back) swap(visited, target++, back--);
		return true;
	}
	
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
