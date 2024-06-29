import java.io.*;
import java.util.*;

public class B14500_테트로미노_오화랑_Re {
    static class Solution {
        int N, M, maxSum;
        int[][] Map;
        boolean[][] visited;
        int[][] move = {
                { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }
        };

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            this.N = Integer.parseInt(st.nextToken());
            this.M = Integer.parseInt(st.nextToken());
            this.Map = new int[this.N][this.M];
            this.visited = new boolean[this.N][this.M];

            for (int i = 0; i < this.N; i++) {
                st = new StringTokenizer(input.readLine());
                for (int j = 0; j < this.M; j++) {
                    this.Map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < this.N; i++) {
                for (int j = 0; j < this.M; j++) {
                    this.visited[i][j] = true;
                    getDFS(i, j, this.Map[i][j], 0);
                    this.visited[i][j] = false;
                    getBFS(i, j, this.Map[i][j]);
                }
            }

            System.out.println(this.maxSum);
        }

        void getDFS(int x, int y, int sum, int count) {
            if (count == 3) {
                this.maxSum = Math.max(sum, this.maxSum);
                return;
            }
            int nX, nY;
            for (int[] eachM : this.move) {
                nX = x + eachM[0];
                nY = y + eachM[1];
                if (nX < 0 || nY < 0 || nX >= this.N || nY >= this.M)
                    continue;
                if (this.visited[nX][nY])
                    continue;
                this.visited[nX][nY] = true;
                getDFS(nX, nY, sum + this.Map[nX][nY], count + 1);
                this.visited[nX][nY] = false;
            }
        }

        void getBFS(int x, int y, int sum) {
            if (x - 1 < 0) {
                if (y - 1 < 0 || y + 1 >= this.M)
                    return;
                else {
                    sum += (this.Map[x + 1][y] + this.Map[x][y - 1] + this.Map[x][y + 1]);
                    this.maxSum = Math.max(sum, this.maxSum);
                }
            } else if (x + 1 >= this.N) {
                if (y - 1 < 0 || y + 1 >= this.M)
                    return;
                else {
                    sum += (this.Map[x - 1][y] + this.Map[x][y - 1] + this.Map[x][y + 1]);
                    this.maxSum = Math.max(sum, this.maxSum);
                }
            } else {
                if (y - 1 < 0) {
                    sum += (this.Map[x + 1][y] + this.Map[x - 1][y] + this.Map[x][y + 1]);
                    this.maxSum = Math.max(sum, this.maxSum);
                } else if (y + 1 >= this.M) {
                    sum += (this.Map[x + 1][y] + this.Map[x - 1][y] + this.Map[x][y - 1]);
                    this.maxSum = Math.max(sum, this.maxSum);
                } else {
                    int nX, nY;
                    sum += (this.Map[x + 1][y] + this.Map[x - 1][y] + this.Map[x][y + 1] + this.Map[x][y - 1]);
                    for (int[] eachM : this.move) {
                        nX = x + eachM[0];
                        nY = y + eachM[1];
                        this.maxSum = Math.max(sum - this.Map[nX][nY], this.maxSum);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}
