import java.io.*;
import java.util.*;

public class BOJ_12891_HR2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int dnaNum = Integer.parseInt(st.nextToken());
        int pwNum = Integer.parseInt(st.nextToken());
        String dna = input.readLine();
        int[] pwBoundRule = new int[4];

        st = new StringTokenizer(input.readLine());
        for (int i = 0 ; i < 4 ; i++)
            pwBoundRule[i] = Integer.parseInt(st.nextToken());

        int searchEnd = dnaNum - pwNum;
        int[] dnaCnt; int pwdCnt = 0; int curDiff;
        for (int i = 0 ; i <= searchEnd ; i++) {
            dnaCnt = new int[4];
            for (int j = 0 ; j < pwNum ; j++) {
                switch (dna.charAt(i + j)) {
                    case 'A': dnaCnt[0]++; break;
                    case 'C': dnaCnt[1]++; break;
                    case 'G': dnaCnt[2]++; break;
                    case 'T': dnaCnt[3]++; break;
                }
            }
            curDiff = 0;
            for (int ind = 0 ; ind < 4 ; ind++){
                curDiff = dnaCnt[ind] - pwBoundRule[ind];
                if (curDiff < 0)
                    break;
            }
            if (curDiff >= 0)
                pwdCnt++;
        }
        System.out.println(pwdCnt);
    }
}
