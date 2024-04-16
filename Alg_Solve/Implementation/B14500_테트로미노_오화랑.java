import java.io.*;
import java.util.*;

public class B14500_테트로미노_오화랑 {
    static class sum { // 2칸의 합을 더한 것 -> 테트로미노 2칸 + 2칸으로 이루어져 있음
        int hSum, vSum;
        public sum(int hSum, int vSum) {
            this.hSum = hSum;
            this.vSum = vSum;
        }
    }
    static int[][] Map;
    static sum[][] sumMap; // 2개의 합정보를 가지고 있음
    static int N, M;
    static int maxTet = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        sumMap = new sum[N][M];
        int hsum, vsum;
        sumMap[0][0] = new sum(0, 0);
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0 ; j < M ; j++) {
                Map[i][j] =  Integer.parseInt(st.nextToken());
                if (i > 0 && j > 0) {
                    hsum = Map[i][j - 1] + Map[i][j];
                    vsum = Map[i - 1][j] + Map[i][j];
                    sumMap[i][j] = new sum(hsum, vsum);
                }
                else if (j > 0) {
                    hsum = Map[i][j - 1] + Map[i][j];
                    sumMap[i][j] = new sum(hsum, 0);
                }
                else if (i > 0) {
                    vsum = Map[i - 1][j] + Map[i][j];
                    sumMap[i][j] = new sum(0, vsum);
                }
            }
        }
        // 1 2 3 4
        // 2 3 4 5
        // {0, 0}, {3, 0}
        // {0, 3}, {5, 5}


        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                makeMax(i,j,sumMap[i][j]);
            }
        }
        System.out.println(maxTet);
    }
    public static void makeMax(int x, int y, sum eachSum) {
        int[][] moveHH = { {1, -1}, {1, 0}, {1, 1}, {0, 2} };
        int[][] moveHV = { {1, -2}, {2, -1}, {2, 0}, {1, 1} };
        int[][] moveVH = { {0, -1}, {1, 0}, {1, 1}, {0, 2} };
        int[][] moveVV = { {1, -1}, {2, 0}, {1, 1}, {0, 1} };
        int[][] moveT = { {0, 1}, {1, 0} };

        int nextX, nextY, tempSum;
        if (eachSum.hSum == 0 && eachSum.vSum == 0) return;

        else if (eachSum.hSum == 0) {
            tempSum = 0;
            for (int[] eachM : moveVH) {
                nextX = x + eachM[0];
                nextY = y + eachM[1];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                tempSum = eachSum.vSum + sumMap[nextX][nextY].hSum;
                maxTet = Math.max(maxTet, tempSum);
            }
            for (int[] eachM : moveVV) {
                nextX = x + eachM[0];
                nextY = y + eachM[1];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                tempSum = eachSum.vSum + sumMap[nextX][nextY].vSum;
                maxTet = Math.max(maxTet, tempSum);
            }
            if (x == N - 1) return;
            tempSum = eachSum.vSum + Map[x + 1][y] + Map[x][y + 1];
            maxTet = Math.max(maxTet, tempSum);
        }

        else if (eachSum.vSum == 0) {
            tempSum = 0;
            for (int[] eachM : moveHH) {
                nextX = x + eachM[0];
                nextY = y + eachM[1];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                tempSum = eachSum.hSum + sumMap[nextX][nextY].hSum;
                maxTet = Math.max(maxTet, tempSum);
            }
            for (int[] eachM : moveHV) {
                nextX = x + eachM[0];
                nextY = y + eachM[1];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                tempSum = eachSum.hSum + sumMap[nextX][nextY].vSum;
                maxTet = Math.max(maxTet, tempSum);
            }
            if (y == M - 1) return;
            tempSum = eachSum.hSum + Map[x + 1][y] + Map[x][y + 1];
            maxTet = Math.max(maxTet, tempSum);
        }
        else {
            tempSum = 0;
            for (int[] eachM : moveVH) {
                nextX = x + eachM[0];
                nextY = y + eachM[1];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                tempSum = eachSum.vSum + sumMap[nextX][nextY].hSum;
                maxTet = Math.max(maxTet, tempSum);
            }
            for (int[] eachM : moveVV) {
                nextX = x + eachM[0];
                nextY = y + eachM[1];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                tempSum = eachSum.vSum + sumMap[nextX][nextY].vSum;
                maxTet = Math.max(maxTet, tempSum);
            }
            for (int[] eachM : moveHH) {
                nextX = x + eachM[0];
                nextY = y + eachM[1];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                tempSum = eachSum.hSum + sumMap[nextX][nextY].hSum;
                maxTet = Math.max(maxTet, tempSum);
            }
            for (int[] eachM : moveHV) {
                nextX = x + eachM[0];
                nextY = y + eachM[1];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                tempSum = eachSum.hSum + sumMap[nextX][nextY].vSum;
                maxTet = Math.max(maxTet, tempSum);
            }
            for (int[] eachM : moveT) {
                nextX = x + eachM[0];
                nextY = y + eachM[1];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                tempSum = eachSum.hSum + eachSum.vSum + Map[nextX][nextY] - Map[x][y];
                maxTet = Math.max(maxTet, tempSum);
            }
            for (int i = 0 ; i < 2 ; i++) {
                if (x + 1 < N && y + 1 < M) {
                    if (i == 0) {
                        tempSum = eachSum.hSum + Map[x + 1][y] + Map[x][y + 1];
                        maxTet = Math.max(maxTet, tempSum);
                    }
                    else {
                        tempSum = eachSum.vSum + Map[x + 1][y] + Map[x][y + 1];
                        maxTet = Math.max(maxTet, tempSum);
                    }
                }
            }
        }
    }
}
