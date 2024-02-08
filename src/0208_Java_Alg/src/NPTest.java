import java.io.*;
import java.util.*;


public class NPTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] input = new int[N];
		
		for (int i = 0 ; i < N ; i++)
			input[i] = sc.nextInt();
		
		// step0 : 정렬 (오름차순)
		Arrays.sort(input);
		
		do {
			// 순열 이용한 처리 로직 
			System.out.println(Arrays.toString(input));
			
		}while(np(input));
	}
	
	public static boolean np(int[] p) { // 현 순열의 사전순 다음 순열 생성 (P : 현 순열)
		final int N = p.length;
		// step1 : 교환위치 찾기 ( 뒤쪽부터 꼭대기를 찾으면 꼭대기 이전이 교환 위치가 됨
		int i = N - 1;
		while( i > 0  && p[i-1] >= p[i]) --i; // 빠져나왔다면, i == 0 OR p[i-1] < p[i]
		
		if (i == 0) return false; // 현재 순열의 상태가 가장 큰 순열이므로 NP 없음
		
		// step2 : 교환 위치 ( i - 1 )에 넣을 값 뒤쪽부터 찾기 ( 큰 값 중 최소값 )
		
		int j = N - 1;
		while(p[i-1] >= p[j]) --j;
		
		// step3 : 교환위치(i -1) 값과 찾은 위치 (j)값을 교환
		swap(p, i - 1, j); // swap 유지 되어 있음 (참조값을 전해주었기 때문에)
		
		// step4 : 꼭대기(i)위치부터 맨 뒤까지 오름차순 정렬
		int k = N - 1;
		while(i < k) swap(p, i++, k--);
		
		return true;
	}
	
	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
