import java.io.*;
import java.util.*;

public class B28018_시간이겹칠까_오화랑 {
    static class Solution {
        int N, Q;
        int[] seatCount = new int[1_000_002];

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = null;

            this.N = Integer.parseInt(input.readLine());
            int s, e;
            for (int i = 0; i < this.N; i++) {
                st = new StringTokenizer(input.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                seatCount[s]++;
                seatCount[e + 1]--;
            }

            for (int t = 1; t <= 1_000_000; t++)
                seatCount[t] += seatCount[t - 1];

            this.Q = Integer.parseInt(input.readLine());
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < Q; i++)
                sb.append(seatCount[Integer.parseInt(st.nextToken())]).append("\n");
            System.out.print(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}
