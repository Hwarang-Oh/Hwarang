import java.util.Scanner;

public class SquareNumberTest {
	static int callCount;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt(); // 최대 10억까지 가능
		System.out.println(exp1(x, n));
		System.out.println(callCount);
	}
	
	static long exp1(long x, int n) { // 밑과 지수
		callCount++;
		if (n == 1) return x;
		int half = n/2;
		long res = exp1(x, half);
		res *= res; // 본인의 결과에 본인의 결과를 곱하기
		
		return n%2 == 0 ? res : res*x; // 짝수면 바로 결과, 홀수면 곱하기 자기자신 한번 더해줘서 return
	}
}

// 나중에, 알고리즘 문제에서 많이 나오는ㄷ, 나머지 연산도 고려할 필요는 있음.
