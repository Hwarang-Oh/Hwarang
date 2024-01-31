import java.util.Arrays;
import java.util.Scanner;

// 주사위를 3번 던져서 나올 수 있는 모든 경우
// 112와 121이 다름 -> 구성은 동일하나 순서가 다르면 diff 판단 => Permutation
// value의 중복이 가능함. ( Duplicate )

// 주사위 던지기 ( 던지는 횟수는 6번 이하라 하자 )
public class DiceTetst {
	static int N, numbers[];
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		numbers = new int[N];
		int mode= sc.nextInt() ;
		
		switch (mode) {
		case 1: // 중복순열
			dice1(0);
			break;
		case 2: // 순열 : 중복 관리
			isSelected = new boolean[7];
			dice2(0);
			break;
		
		}
	}
	
	public static void dice1(int cnt) { // 직전까지 던진 주사위 횟수
		
		if (cnt == N)
			System.out.println(Arrays.toString(numbers));
			return;
		
		for (int i = 1; i <= 6; i++) { // 모든 주사위의 눈을 시도
			numbers[cnt] = i; // 되돌릴 필요 X 정해진 cnt 자릿수에 넣기 때문에, 계속 덮어씌움 
			dice1(cnt + 1); 
			} // cnt가 직접 바귀는 것은의미 X
	}

	
	public static void dice2(int cnt) { // 직전까지 던진 주사위 횟수
		// 고정된 수 순열 -> 입력된 수 순열 => 1-> 0, input.length ( input 배열에 isSelected 배열 관리 )
		if (cnt == N)
			System.out.println(Arrays.toString(numbers));
			return;
		for (int i = 1; i <= 6; i++) { // 모든 주사위의 눈을 시도
			if (isSelected[i]) continue;
			
			numbers[cnt] = i;
		}// 되돌릴 필요 X 정해진 cnt 자릿수에 넣기 때문에, 계속 덮어씌움 
		
	}		
		//  중복조합
	public static void dice3(int cnt, int start) {
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
		}
	}
	it4(int cnt ; int stat) {
		if (cnt == N)
	}
		
		
	// 조합
	public static void de
	it4(int cnt ; nt stat) {
		if (cnt == N)
	}
}
