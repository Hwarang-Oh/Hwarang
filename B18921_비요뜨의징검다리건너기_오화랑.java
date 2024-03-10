import java.io.*;
import java.util.*;

public class B18921_비요뜨의징검다리건너기_오화랑 {
	static int[] jumpList = new int[1001];
	static int threshold = (int) Math.pow(5,9) + 7;
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		jumpList[1] = 1;
		jumpList[2] = 1;
		for (int t = 0 ; t < testCase ; t++) {
			int size = Integer.parseInt(input.readLine());
			System.out.println(getJump(size));
		}
	}
	public static int getJump(int size) {
		if (jumpList[size] != 0) return jumpList[size];
		else {
			int temp = getJump(size - 1) * 2;
			if (temp == -2) {
				jumpList[size] = -1;
				return jumpList[size] + 1;
			}
			if (temp < threshold)  return jumpList[size] = temp;
			else if (temp == threshold) {
				jumpList[size] = -1;
				return jumpList[size] + 1;
			}
			else {
				jumpList[size] = temp % threshold;
				return jumpList[size];
			}
		}
	}
}

// New Idea -> 10^9 + 7의 상황을 -> 11번째 징검다리부터 -> 2^9 / 10^9  + 7


// 모듈러 연산이 비요뜨 dp안에 나타나야 한다 
// 임의의 정수 X에 대해 i번째 -> i + X번째로 Jump 가능
// N번째 징검다리를 지나치면 안되며, 정확하게 도착해야 한다.
// 1 2 3 4의 징검다리 : 1에서 4로 정확하게 갈 수 있는 경우의 수!
// 1 2 3 4 => 1 4, 1 2 4, 1 3 4, 1 2 3 4 => 4개 => 부분집합 아닌가? 
// 10^9의 징검다리를.. 할 수 있을까? => NextPowerSet?
// 1 -> 1 -> 2 -> 4 -> 8 -> 16 -> 32 -> 64 -> 128 -> 256 -> 512
