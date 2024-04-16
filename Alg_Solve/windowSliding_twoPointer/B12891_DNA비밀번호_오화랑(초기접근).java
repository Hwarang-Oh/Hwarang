import java.io.*;
import java.util.*;

public class BOJ_12891_HR {
	static int madePW = 0;
	static int[] pwBoundRule;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int strNum = Integer.parseInt(st.nextToken());
		int pwNum = Integer.parseInt(st.nextToken());
		int[][] DNA = new int [strNum+1][4];
		int[] dnaNum = new int [4];
		int[] temp;
		
		String inputDNA = input.readLine();
		for (int i = 0 ; i < strNum ; i++) {
			switch (inputDNA.charAt(i)) {
				case 'A': dnaNum[0]++; break;
				case 'C': dnaNum[1]++; break;
				case 'G': dnaNum[2]++; break;
				case 'T': dnaNum[3]++;
			}
			temp = Arrays.copyOf(dnaNum,4);
			DNA[i+1] = temp;
		}
		
		pwBoundRule = new int [4];
		st = new StringTokenizer(input.readLine());
		for (int i = 0 ; i < 4 ; i++) {
			pwBoundRule[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.deepToString(DNA));
		System.out.println(strNum);
		
		int pwEnd = strNum;
		System.out.println(pwEnd);
		int pwStart = pwEnd - (strNum - pwNum);
		int[] temp2 = new int[4];
		int num = 0;
		
		for (int i = pwEnd ; i >= pwStart ; i--) {
			for (int j = 0 ; j < 4 ; i++)
				temp2[j] = DNA[i][j] - DNA[i-pwNum][j];
			
			if (temp2[0] > pwBoundRule[0] && temp2[1] > pwBoundRule[1] &&
				temp2[2] > pwBoundRule[2] && temp2[3] > pwBoundRule[3])
				num++;
		}
		System.out.println(Arrays.deepToString(DNA));
		System.out.println(num);
	}
}
