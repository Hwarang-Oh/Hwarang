import java.util.*;
import java.io.*;

public class B18427_함께블록쌓기_오화랑 {

    static int[][] memo;
    static ArrayList<ArrayList<Integer>> boxList;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        memo = new int[N + 1][H + 1];
        boxList = new ArrayList<>(N + 1);
        boxList.add(new ArrayList<>()); // Zero Index
        memo[0][0] = 1; // Zero Index

        int blockH;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(input.readLine());
            boxList.add(new ArrayList<>(st.countTokens()));
            for (int h = 0; h <= H; h++) {
                memo[i][h] = memo[i - 1][h];
            }
            while (st.hasMoreTokens()) {
                blockH = Integer.parseInt(st.nextToken());
                boxList.get(i).add(blockH);
                for (int h = 1; h <= H; h++) {
                    if (h < blockH)
                        continue;
                    if (memo[i - 1][h - blockH] > 0) {
                        memo[i][h] += memo[i - 1][h - blockH];
                    }
                }
            }
            for (int h = 0; h <= H; h++) {
                memo[i][h] = memo[i][h] > 10007 ? memo[i][h] % 10007 : memo[i][h];
            }
        }
        // for (int i = 1; i <= N; i++) {
        // System.out.println(boxList.get(i));
        // }
        // System.out.println("----------------------------");
        // for (int i = 0; i <= N; i++) {
        // System.out.println(Arrays.toString(memo[i]));
        // }
        // System.out.println("--------------------------------");
        System.out.println(memo[N][H] % 10007);
    }
}

/*
 * for (PriorityQueue<Integer> each : boxList) {
 * while (!each.isEmpty()) {
 * System.out.print(each.poll() + " ");
 * }
 * System.out.println();
 * }
 */
