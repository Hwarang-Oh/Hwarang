import java.io.*;
import java.util.*;

public class S5656_벽돌깨기_오화랑 {
    static class pair {
        int x, y, power;

        public pair(int x, int y, int power) {
            this.x = x;
            this.y = y;
            this.power = power;
        }
    }

    static int N, H, W;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int TC = Integer.parseInt(input.readLine());

        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            int[][] Map = new int[H][W];
            int[] Top = new int[W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(input.readLine());
                for (int j = 0; j < W; j++) {
                    Map[i][j] = Integer.parseInt(st.nextToken());
                    if (Map[i][j] > 0 && Top[j] == 0) Top[j] = i;
                }
            }
        }
    }

    public static void shoot(int cnt, int broke, int[][] Map) {
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        if (cnt == N) return;
    }
}
