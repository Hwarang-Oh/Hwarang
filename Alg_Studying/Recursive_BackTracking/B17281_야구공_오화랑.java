import java.io.*;
import java.util.*;

public class B17281_야구공_오화랑 {
	static int maxPoint = Integer.MIN_VALUE;
	
	static class gameBase {
		int base1, base2, base3, home;
		public gameBase() {
			super();
			base1 = 0; base2 = 0;
			base3 = 0; home = 0;
		}
		public void newGame() {
			base1 = 0; base2 = 0; base3 = 0;
		}
		public void one() { 
			if(base3 == 1) {base3--; home++;}
			if(base2 == 1) {base2--; base3++;}
			if(base1 == 1) {base1--; base2++;}
			base1++;
		}
		public void two() {
			if(base3 == 1) {base3--; home++;}
			if(base2 == 1) {base2--; home++;}
			if(base1 == 1) {base1--; base3++;}
			base2++;
		}
		public void three() {
			if(base3 == 1) {base3--; home++;}
			if(base2 == 1) {base2--; home++;}
			if(base1 == 1) {base1--; home++;}
			base3++;
		}
		public void homeRun() {
			if (base3 == 1) {base3--; home++;}
			if (base2 == 1) {base2--; home++;}
			if (base1 == 1) {base1--; home++;}
			home++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int maxTurn = Integer.parseInt(input.readLine());
		int [] playerTurn = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[][] expPoint = new int[maxTurn][9];	
		for (int i = 0 ; i < maxTurn ; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0 ; j < 9 ; j++)
				expPoint[i][j] = Integer.parseInt(st.nextToken());
		}
		
		do {
//			playerTurn -> 1위치를 index 4에 넣고 NextP값을 복사해주기
			Queue<Integer> playerSeq = new ArrayDeque<>();
			for (int i = 0 ; i < 9 ; i++) {
				if (i == 3) playerSeq.offer(0);
				else {
					if (i > 3) playerSeq.offer(playerTurn[i - 1]);
					else playerSeq.offer(playerTurn[i]);
				}
			}
			maxPoint = Math.max(maxPoint, pointCal(playerSeq, expPoint));
		} while(NextP(playerTurn));
		
		System.out.println(maxPoint);

	}
	
	public static boolean NextP(int[] playerTurn) { // 현순열의 사전순 다음 순열 생성
		final int size = playerTurn.length;
		
		// step1 : 교환위치 찾기 ( 뒤쪽부터 꼭대기를 찾으면, 꼭대기 이전이 교환 위치가 됨
		int i = size - 1;
		while(i > 0 && playerTurn[i-1] > playerTurn[i]) --i;
		if (i == 0) return false;
		
		// step2 : 교환 위치 (i - 1)에 넣을 값을 뒤쪽부터 찾기 ( 큰값 중 최소값 )
		int j = size - 1;
		while (playerTurn[i-1] >= playerTurn[j]) --j;
		
		// step3 : 교환위치 (i - 1) 값과 찾은 위치 (j) 교환
		swap(playerTurn, i - 1, j);
		int k = size - 1;
		while (i < k) swap(playerTurn, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int pointCal(Queue<Integer> playerSeq, int[][] expPoint) {
		gameBase game = new gameBase();
		
		for (int i = 0 ; i < expPoint.length ; i++) {
			int currPlayer, currResult;
			int outCount = 0;
			game.newGame();
			while (true) {
				currPlayer = playerSeq.poll();
				currResult = expPoint[i][currPlayer];
				if (currResult == 0) outCount++;
				else if (currResult == 1) game.one();
				else if (currResult == 2) game.two();
				else if (currResult == 3) game.three();
				else if (currResult == 4) game.homeRun();
				playerSeq.offer(currPlayer);
				if (outCount == 3) break;
			}
		}
		return game.home;
	}
}

// _ _ _ 1 _ _ _ _ _
// _ _ _ 1 _ _ _ _ _
// _ _ _ 1 _ _ _ _ _
// _ _ _ 1 _ _ _ _ _