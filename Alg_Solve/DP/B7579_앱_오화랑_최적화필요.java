import java.io.*;
import java.util.*;

public class B7579_앱_오화랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int pNum = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] memo = new int[target + 1];
        Arrays.fill(memo, 1_000_000_000); // each Memory Making Cost -> Init Value : Integer.MAX_VALUE
        int eachM, eachC;
        StringTokenizer stM = new StringTokenizer(input.readLine());
        StringTokenizer stC = new StringTokenizer(input.readLine());
        for (int i = 0 ; i < pNum ; i++) {
            eachM = Integer.parseInt(stM.nextToken());
            eachC = Integer.parseInt(stC.nextToken());
            if (eachM > target) eachM = target;

            for (int m = target - eachM ; m > 0 ; m--) {
                memo[eachM + m] = Math.min(memo[eachM + m], memo[m] + eachC);
            }
            for (int m = 0 ; m <= eachM ; m++) {
                memo[m] = Math.min(memo[m], eachC);
            }
        }
        System.out.println(memo[target]);
    }
}

//