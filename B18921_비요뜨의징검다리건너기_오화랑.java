import java.io.*;
import java.util.*;

public class B18921_비요뜨의징검다리건너기_오화랑 {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		for (int t = 0 ; t < testCase ; t++) {
			int size = Integer.parseInt(input.readLine());
			ArrayList<Integer> tempArr = new ArrayList<>();
			tempArr.add(1); tempArr.add(1);
			int index = 3;
			if (size == 1) System.out.println(tempArr.get(size - 1));
			if (size == 2) System.out.println(tempArr.get(size - 1));
			else {
				while (true) {
					tempArr.add(tempArr.get(index - 1) * 2);
					if (tempArr.get(index) > (int) Math.pow(10,9) + 7) {
						tempArr.clear();
					}
					index++;
				}
			}
		}
	}
}



// 모듈러 연산이 비요뜨 dp안에 나타나야 한다 
// 임의의 정수 X에 대해 i번째 -> i + X번째로 Jump 가능
// N번째 징검다리를 지나치면 안되며, 정확하게 도착해야 한다.
// 1 2 3 4의 징검다리 : 1에서 4로 정확하게 갈 수 있는 경우의 수!
// 1 2 3 4 => 1 4, 1 2 4, 1 3 4, 1 2 3 4 => 4개 => 부분집합 아닌가? 
// 10^9의 징검다리를.. 할 수 있을까? => NextPowerSet?
// 1 -> 1 -> 2 -> 4 -> 8 -> 16 -> 32 -> 64 -> 128 -> 256 -> 512
