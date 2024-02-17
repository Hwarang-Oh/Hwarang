import java.util.*;
import java.io.*;

public class B2961_도영이가만든맛있는음식_오화랑 {
    static int[][] ing;
    static boolean[] isUsed;
    static int MIN = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ingNum = Integer.parseInt(input.readLine());
        ing = new int[ingNum][2];
        isUsed =  new boolean[ingNum];

        for (int i = 0 ; i < ingNum ; i++) {
            st = new StringTokenizer(input.readLine());
            ing[i][0] = Integer.parseInt(st.nextToken());
            ing[i][1] = Integer.parseInt((st.nextToken()));
        }
        makeJJAPA(ingNum,0);
        System.out.println(MIN);
    }
    public static void makeJJAPA(int maxIng, int cnt) {
        if (cnt == maxIng) {
            int sourP = 1;
            int bitP = 0;
            int falseCnt = 0;
            for (int i = 0 ; i < maxIng ; i++) {
                if (isUsed[i]) {
                    sourP *= ing[i][0];
                    bitP += ing[i][1];
                }
                else
                    falseCnt++;
            }
            if (falseCnt == maxIng) return;
            MIN = Math.min(MIN, Math.abs(sourP - bitP));
            return;
        }
        isUsed[cnt] = true;
        makeJJAPA(maxIng, cnt + 1);
        isUsed[cnt] = false;
        makeJJAPA(maxIng, cnt + 1);

    }
}
