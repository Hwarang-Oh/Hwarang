import java.io.*;
import java.util.*;

// Problem
// N : 500,000 (MAX), Q : 100,000 (MAX)

public class B23326_홍익투어리스트_오화랑 {

    static class Solution {
        int N, Q;
        int[] list;
        int[][] Tree;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            this.N = Integer.parseInt(st.nextToken());
            this.Q = Integer.parseInt(st.nextToken());
            this.Tree = new int[this.N + 1][2];

            st = new StringTokenizer(input.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}
