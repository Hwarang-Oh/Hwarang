import java.io.*;
import java.util.*;

public class BOJ_12891_HR3 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int dnaNum = Integer.parseInt(st.nextToken());
        int pwNum = Integer.parseInt(st.nextToken());
        String dna = input.readLine();
        int[] pwRule = new int[4];

        int[][] dnaCntArr = new int[dnaNum+1][4];
        int[] temp = new int[4];
        int[] currCnt;
        for (int i = 0 ; i < dnaNum ; i++) {
            switch (dna.charAt(i)) {
                case 'A': temp[0]++; break;
                case 'C': temp[1]++; break;
                case 'G': temp[2]++; break;
                case 'T': temp[3]++;
            }
            currCnt = Arrays.copyOf(temp,4);
            dnaCntArr[i + 1] = currCnt;
        }

        st = new StringTokenizer(input.readLine());
        for (int i = 0 ; i < 4 ; i++)
            pwRule[i] = Integer.parseInt(st.nextToken());

        int diffA, diffC, diffG, diffT;
        int pwdCnt = 0;
        for (int i = pwNum ; i <= dnaNum ; i++) {
            diffA = (dnaCntArr[i][0] - dnaCntArr[i - pwNum][0] - pwRule[0]);
            diffC = (dnaCntArr[i][1] - dnaCntArr[i - pwNum][1] - pwRule[1]);
            diffG = (dnaCntArr[i][2] - dnaCntArr[i - pwNum][2] - pwRule[2]);
            diffT = (dnaCntArr[i][3] - dnaCntArr[i - pwNum][3] - pwRule[3]);
            if (diffA >= 0 && diffC >= 0 && diffG >= 0 && diffT >= 0)
                pwdCnt++;
        }
        System.out.println(pwdCnt);
    }
}

