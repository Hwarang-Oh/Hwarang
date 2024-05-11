import java.io.*;
import java.util.*;

public class S5656_벽돌깨기_오화랑_noClone {
    static class pair {
        int x, y, power;
        public pair(int x, int y, int power) {
            this.x = x;
            this.y = y;
            this.power = power;
        }
    }
    static int N, H, W;
    static int[][] Map;
    static int[] Top;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int TC = Integer.parseInt(input.readLine());

        for (int t = 0 ; t < TC ; t++) {
            st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            Map = new int[H][W];
            Top = new int[W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(input.readLine());
                for (int j = 0 ; j < W ; j++) {
                    Map[i][j] = Integer.parseInt(st.nextToken());
                    if (Map[i][j] > 0 && Top[j] == 0) Top[j] = i;
                }
            }
            shoot(0,0);
        }
    }

    public static void shoot(int cnt, int broke) {
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        if (cnt == N) return;

        Queue<pair> brickList = new ArrayDeque<>();
        Queue<pair> brokeList = new ArrayDeque<>();
        for (int i = 0 ; i < W ; i++) {
            // Destroy
            brickList.offer(new pair(Top[i], i , Map[Top[i]][i]));
            Map[Top[i]][i] = 0;
            Top[i] = 0;
            while (!brickList.isEmpty()) {
                pair tempB = brickList.poll();
                brokeList.offer(tempB);
                int x = tempB.x;
                int y = tempB.y;
                int p = tempB.power;
                if (p == 1) continue;
                for (int[] eachM : move) {
                    int nX = x; int nY = y;
                    for (int j = 1 ; j < p ; j++) {
                        nX += eachM[0];
                        nY += eachM[1];
                        if (nX < 0 || nY < 0 || nX >= H || nY >= W) break;
                        if (Map[nX][nY] > 0) {
                            brickList.offer(new pair(nX, nY, Map[nX][nY]));
                            Map[nX][nY] = 0;
                        }
                    }
                }
            }
            Queue<pair> beforeList = new ArrayDeque<>();
            Queue<pair> afterList = new ArrayDeque<>();
            for (int r = H - 2 ; r >= 0 ; r--) {
                for (int c = W - 1 ; c >= 0 ; c--) {
                    if (Map[r][c] > 0 && Map[r + 1][c] == 0) {
                        int loc = r;
                        while (true) {
                            loc++;
                            System.out.println(loc);
                            if (Map[loc + 1][c] > 0)break;
                            if (loc == H - 1) break;
                        }
                        beforeList.add(new pair(r, c, Map[r][c]));
                        Map[loc][c] = Map[r][c];
                        Map[r][c] = 0;
                        afterList.add(new pair(loc, c, Map[loc][c]));
                        Top[c] = loc;
                    }
                }
            }
            for (int k = 0 ; k < H ; k++) {
                System.out.println(Arrays.toString(Map[k]));
            }
            System.out.println();
            System.out.println(Arrays.toString(Top));
            System.out.println();
            shoot(cnt + 1, 0);
            // Refactoring
            // Next Shoot DFS
            // deRefactoring
            // Undestroy
        }
    }
}

// 구슬을 쏘는 횟수 N번 => 1 ~ 4
// W -> 가로 2 ~ 12
// H -> 세로 2 ~ 15
// 12 * 11 * 10 * 9

//for (int i = 0 ; i < H ; i++) {
//System.out.println(Arrays.toString(Map[i]));
//}
//System.out.println();
//System.out.println(Arrays.toString(Top));