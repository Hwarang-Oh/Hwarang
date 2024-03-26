import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865_평범한배낭_오화랑 {
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(st.nextToken());
        int mWeight = Integer.parseInt(st.nextToken());
        memo = new int[num + 1][mWeight + 1];

        int eachW, eachV;
        for (int i = 1 ; i <= num ; i++) {
            st = new StringTokenizer(input.readLine());
            eachW = Integer.parseInt(st.nextToken());
            eachV = Integer.parseInt(st.nextToken());
            for (int w = 1 ; w <= mWeight ; w++) {
                if (eachW > w) continue;
                else {

                }
            }
        }
    }
}
