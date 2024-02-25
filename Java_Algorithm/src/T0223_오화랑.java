import java.io.*;
import java.util.*;

public class T0223_오화랑 {
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
//
		
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
//		int[] nextCVisited;
//		for (int i = 0 ; i < N ; i++) {
//			nextCVisited = new int[N];
//			for (int j = i ; j < N ; j++) {
//				made = new int[N - i];
//				nextCVisited[j] = 1;
//			}
//			int index = 0;
//			do {
//				for (int s = 0 ; s < N ; s++)
//					if (nextCVisited[s] == 1) made[index++] = numbers[s];
//				
//				System.out.println(Arrays.toString(made));
//				index = 0;
//			} while(NextC(nextCVisited));
//		}
//		
		// 4. Union Finding -> 議곌툑 �뜑 蹂듭뒿�빐�빞 �븷 寃� 媛숈뒿�땲�떎.
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
					temp.add(numbers[i]);
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
	
//	public static boolean NextP(int[] numbers) {
//		final int size = numbers.length;
//
//		// 떨어지는 위치 찾기
//		int target = size - 1;
//		while (target > 0 && numbers[target - 1] > numbers[target]) --target;
//		if (target == 0) return false; // 계속 내려가는 수열 ( -> 다음순열X )
//
//		// Swap 위치도 맨 끝에서부터!
//		int swapLoc = size - 1;
//		while()
//
//
//	}
	
	
}

// 과목평가
// 1. 순조부가 어떤 역할을 가지고 있고, 어떻게 쓰이는지?
// 2. 3문제 -> 1문제는 쉽다
// 3. 3문제 중 2문제를 풀면 된다. 

// 월말평가
// 1. 그래프의 표현 -> 인접 행렬 / 인접 리스트 / 간선 리스트
// 2. 3문제 -> 1문제 ( 그래프 탐색 )
// 3. 3문제 -> 2문제 ( A형 언저리 문제들 )
