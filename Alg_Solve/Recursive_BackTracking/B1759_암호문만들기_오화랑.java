import java.io.*;
import java.util.*;

public class B1759_암호문만들기_오화랑 {
	static boolean[] isSelected;
	static String[] possiblePassWord;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int passNum = Integer.parseInt(st.nextToken());
		int possibleNum = Integer.parseInt(st.nextToken());
		String[] possChar = new String[possibleNum];
		isSelected = new boolean[possibleNum];
		possiblePassWord = new String[passNum];
		
		st = new StringTokenizer(input.readLine());
		for (int i = 0 ; i < possibleNum ; i++) possChar[i] = st.nextToken();
		Arrays.sort(possChar);
		guessPass(0, passNum, possibleNum, possChar);
	}
	
	public static void guessPass(int cnt, int passNum, int possibleNum, String[] possChar) {
		if (cnt == possibleNum) {
			sb = new StringBuilder();
			int vCount = 0; int cCount = 0;
			for (int i = 0 ; i < possibleNum ; i++) {
				if (isSelected[i]) {
					switch (possChar[i]) {
						case "a": case "e": case "i": case "o": case "u": vCount++; break;
						default : cCount++;
					}
					sb.append(possChar[i]);
				}
			}
			if (vCount >= 1 && cCount >= 2 && vCount + cCount == passNum)
				System.out.println(sb);
			return;
		}
		isSelected[cnt] = true;
		guessPass(cnt + 1, passNum, possibleNum, possChar);
		
		isSelected[cnt] = false;
		guessPass(cnt + 1, passNum, possibleNum, possChar);
	}
}



// 암호 : 최소 1개의 모음 + 최소 2개의 자음으로 구성 
// 암호는 증가하는 순서로 이루어져 있다.
// 조교들이 암호로 사용했을 법한 문자의 종류는 C가지
// C개의 문자가 주어졋을 때, 가능성이 있는 암호들을 모두 구하는 프로그램
// C개의 문자에 중복은 존재하지 않는다.

