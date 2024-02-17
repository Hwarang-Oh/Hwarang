import java.io.*;
import java.util.*;

public class J1183_동전자판기하_오화랑 {
	static int[] coinList = {500, 100, 50, 10, 5, 1};
	static int[] haveList;
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(input.readLine());
		int max = 0; int newTarget;
		
		int[] coinList = {500, 100, 50, 10, 5, 1};
		int[] haveList = new int[6];
		int[] usedList = new int[6];
		
		StringTokenizer st = new StringTokenizer(input.readLine());
		for (int i = 0 ; i < 6 ; i++) {
			haveList[i] = Integer.parseInt(st.nextToken());
			max += coinList[i] * haveList[i];
		}
		
		newTarget = max - target;
		for (int i = 0 ; i < 6 ; i++) {
			if (newTarget > coinList[i])
				usedList[i] = newTarget / coinList[i];
				newTarget %= coinList[i];
		}
		System.out.println(Arrays.toString(usedList));
		
		
	}
}
// 100원 5개 -> 500원 1개

// 50원 2개 -> 100원 1개 => 50원 10개 -> 500원 1개

// 10원 5개 -> 50원 1개 => 10원 10개 -> 100원 1개 => 10원 50개 -> 500원 1개

// 5원 2개 -> 10원 1개 => 5원 10개 -> 50원 1개 => 5원 20개 -> 100원 1개

// 1원 5개 -> 5원 1개 => 1원 10개 -> 10원 1개 => 1원 50개 -> 50원 1개

// 100원 5개가 있다면 500원으로 환산 => 500원을 썼다면 100원을 5개 쓴거!

// 4 5 2 6 3 4 => 5(4 + 1), 1(0 + 1), 

// newCoinList;
// {500, 100, 50, 10} , {100, 50, 10, 5}, {50, 10, 5, 1}, {10, 5, 1}, {5, 1}, {1}\
// w = 500x + 100x + 50x + 10x + 5x + x;