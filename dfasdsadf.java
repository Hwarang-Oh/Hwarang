import java.io.*;
import java.util.*;

public class Main {
    static class sum {
        int vSum, hSum;
        public sum(int vSum, int hSum) {
            this.vSum = vSum;
            this.hSum = hSum;
        }
    }

    static int[][] Map;
    static sum[][] sumMap;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        sumMap = new sum[N - 1][M - 1];
    }
}