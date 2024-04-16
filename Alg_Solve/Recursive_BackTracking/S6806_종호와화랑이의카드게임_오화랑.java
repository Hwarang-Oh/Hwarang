import java.io.*;
import java.util.*;

public class S6806_종호와화랑이의카드게임_오화랑 {
	static int[] hwaPick = new int[9];
	static boolean[] hwaUsed = new boolean[9];
	static int[] jongCard, hwaCard;
	static int jongWinPoint, jongLosePoint;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(input.readLine());
		
		for (int i = 1; i <= testCase ; i++) {
			jongCard = new int [9];
			hwaCard = new int [9];
			boolean[] totalCard = new boolean[19];
			st = new StringTokenizer(input.readLine());
			
			int jongPick;
			for (int j = 0 ; j < 9 ; j++) {
				jongPick = Integer.parseInt(st.nextToken());
				totalCard[jongPick] = true;
				jongCard[j] = jongPick;
			}
			
			int index = 0;
			for (int c = 1 ; c <= 18 ; c++)
				if(!totalCard[c]) hwaCard[index++] = c;
			
			check(0, hwaCard);
			System.out.printf("#%d %d %d%n", i, jongWinPoint, jongLosePoint);
			jongWinPoint = jongLosePoint = 0;
		}
	}
	
	public static void check(int cnt, int[] hwaCard) {
		if (cnt == 9) { WLCount(); return; }
		
		for (int i  = 0 ; i < 9 ; i++) {
			if (hwaUsed[i]) continue;
			hwaPick[cnt] = hwaCard[i];
			hwaUsed[i] = true;
			check(cnt + 1, hwaCard);
			hwaUsed[i] = false;
		}
	}
	
	public static void WLCount() {
		int jongPoint = 0; int hwaPoint = 0;
		for (int i = 0 ; i < 9 ; i++) {
			if (jongCard[i] > hwaPick[i]) jongPoint += (jongCard[i] + hwaPick[i]);
			else hwaPoint += (jongCard[i] + hwaPick[i]);
		}
		if (hwaPoint < jongPoint) jongWinPoint++;
		if (hwaPoint > jongPoint) jongLosePoint++;
	}
}
