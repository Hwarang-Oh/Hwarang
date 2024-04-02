import java.io.*;
import java.util.*;

public class B12865_평범한배낭_오화랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int iNum = Integer.parseInt(st.nextToken());
        int wMax = Integer.parseInt(st.nextToken());
        int[] memo = new int[wMax + 1];

        int eachW, eachV;
        for (int i = 0 ; i < iNum ; i++) {
            st = new StringTokenizer(input.readLine());
            eachW = Integer.parseInt(st.nextToken());
            eachV = Integer.parseInt(st.nextToken());
            if (eachW > wMax) continue;

            for (int w = wMax -eachW ; w >= 0 ; w--)
                memo[eachW + w] = Math.max(memo[eachW + w], memo[w] + eachV);
            System.out.println(Arrays.toString(memo));
        }
        System.out.println(memo[wMax]);
    }
}