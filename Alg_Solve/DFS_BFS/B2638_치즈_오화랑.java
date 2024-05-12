import java.io.*;
import java.util.*;

public class B2638_치즈_오화랑 {
    static class cheese {
        int x, y;

        public cheese(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] Map;
    static boolean[][] isOutAir;
    static int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static Queue<cheese> cList = new ArrayDeque<>();
    static Queue<cheese> willBeAirList = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        isOutAir = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
                if (Map[i][j] > 0) {
                    cList.offer(new cheese(i, j));
                }
            }
        }
        findOutAir(N, M, 0, 0);
        int cSize = 0;
        int time = 0;
        while (!cList.isEmpty()) {
            cSize = cList.size();
            time++;
            cheese temp;
            int cX, cY, aX, aY, airCount;
            while (cSize-- > 0) {
                temp = cList.poll();
                cX = temp.x;
                cY = temp.y;
                airCount = 0;
                for (int[] eachM : move) {
                    aX = cX + eachM[0];
                    aY = cY + eachM[1];
                    if (isOutAir[aX][aY])
                        airCount++;
                    if (airCount >= 2)
                        break;
                }
                if (airCount == 2) {
                    willBeAirList.offer(temp);
                } else
                    cList.offer(temp);
            }
            while (!willBeAirList.isEmpty()) {
                temp = willBeAirList.poll();
                Map[temp.x][temp.y] = 0;
                findOutAir(N, M, temp.x, temp.y);
            }
        }
        System.out.println(time);
    }

    public static void findOutAir(int N, int M, int x, int y) {
        if (isOutAir[x][y] == true)
            return;
        isOutAir[x][y] = true;
        int nextX, nextY;
        for (int[] eachM : move) {
            nextX = x + eachM[0];
            nextY = y + eachM[1];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                continue;
            if (Map[nextX][nextY] == 1)
                continue;
            findOutAir(N, M, nextX, nextY);
        }
    }
}
