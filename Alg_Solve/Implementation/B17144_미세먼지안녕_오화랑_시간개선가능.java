import java.io.*;
import java.util.*;

public class B17144_미세먼지안녕_오화랑 {
    static class dust {
        int x, y, amount;

        public dust(int x, int y, int amount) {
            this.x = x;
            this.y = y;
            this.amount = amount;
        }
    }

    static int[][] Map;
    static int allDust;
    static ArrayList<Integer> AC = new ArrayList<>(2);
    static Queue<dust> dustList = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        Map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
                if (Map[i][j] > 0) {
                    dustList.offer(new dust(i, j, Map[i][j]));
                    allDust += Map[i][j];
                } else if (Map[i][j] == -1) {
                    AC.add(i);
                }
            }
        }
        while (T-- > 0) {
            spreadDust(N, M);
        }
        System.out.println(allDust);
    }

    public static void spreadDust(int N, int M) {
        int[][] spread = {
                { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }
        };

        dust currDust;
        int cX, cY, nX, nY, cAmount, nextGive, nextCount;
        while (!dustList.isEmpty()) {
            currDust = dustList.poll();
            cX = currDust.x;
            cY = currDust.y;
            cAmount = currDust.amount;
            nextGive = cAmount / 5;
            nextCount = 0;
            for (int[] eachS : spread) {
                nX = cX + eachS[0];
                nY = cY + eachS[1];
                if (nX < 0 || nY < 0 || nX >= N || nY >= M)
                    continue;
                if (Map[nX][nY] == -1)
                    continue;

                Map[nX][nY] += nextGive;
                nextCount++;
            }
            Map[cX][cY] -= nextCount * nextGive;
        }
        cleanDust(N, M);
        allDust = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Map[i][j] > 0) {
                    dustList.offer(new dust(i, j, Map[i][j]));
                    allDust += Map[i][j];
                }
            }
        }
    }

    public static void cleanDust(int N, int M) {
        int AC_0_M1 = Map[AC.get(0)][M - 1];
        int AC_1_M1 = Map[AC.get(1)][M - 1];
        int AC_0_M2 = Map[0][M - 1];
        int AC_1_M2 = Map[N - 1][M - 1];
        int AC_0_M3 = Map[0][0];
        int AC_1_M3 = Map[N - 1][0];

        // first AC0 , AC1 Move
        for (int i = M - 1; i > 0; i--) {
            Map[AC.get(0)][i] = Map[AC.get(0)][i - 1];
            Map[AC.get(1)][i] = Map[AC.get(1)][i - 1];
            if (i == 1) {
                Map[AC.get(0)][i] = 0;
                Map[AC.get(1)][i] = 0;
            }
        }

        // Second Move
        for (int i = 0; i < AC.get(0) - 1; i++) {
            Map[i][M - 1] = Map[i + 1][M - 1];
        }
        for (int i = N - 1; i > AC.get(1) + 1; i--) {
            Map[i][M - 1] = Map[i - 1][M - 1];
        }
        Map[AC.get(0) - 1][M - 1] = AC_0_M1;
        Map[AC.get(1) + 1][M - 1] = AC_1_M1;

        // Third Move
        for (int i = 0; i < M - 2; i++) {
            Map[0][i] = Map[0][i + 1];
            Map[N - 1][i] = Map[N - 1][i + 1];
        }
        Map[0][M - 2] = AC_0_M2;
        Map[N - 1][M - 2] = AC_1_M2;

        // Last Move
        for (int i = AC.get(0) - 1; i > 1; i--) {
            Map[i][0] = Map[i - 1][0];
        }
        for (int i = AC.get(1) + 1; i < N - 1; i++) {
            Map[i][0] = Map[i + 1][0];
        }
        Map[1][0] = AC_0_M3;
        Map[N - 2][0] = AC_1_M3;
    }
}

/*
 * 공기청정기는 항상 1번 열에 설치되어 있고, 크기는 2행을 차지한다.
 * 설치 X -> 미세먼지가 존재하고, 미세먼지의 양은 칸에 나타남 (A_rc)
 * 
 * 1. 미세먼지가 확산된다. -> 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
 * 2. 4방향으로 확산되며, 공기청정기가 있거나, 칸이 아예 없다면, 해당 방향으로 확산 X
 * 3. 확산되는 양은 (A_rc/ 5) => 남은 미세먼지의 양은 A_rc - (A_rc / 5) * 개수
 * 
 * 1. 공기청정기가 작동한다. -> 반
 */