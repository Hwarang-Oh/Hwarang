import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/3197
public class B3197_백조의호수_오화랑_DFS1 {
    static class ice {
        int x, y;

        public ice(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class beWater extends ice {
        boolean d0, d1, d2;

        public beWater(int x, int y, boolean d0, boolean d1, boolean d2) {
            super(x, y);
            this.d0 = d0;
            this.d1 = d1;
            this.d2 = d2;
        }
    }

    static class Solution {
        int R, C, count;
        boolean canMeet;
        int[][] Duck = new int[2][2];
        int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int[][] Map;
        ArrayDeque<ice> iceList = new ArrayDeque<>();
        ArrayDeque<beWater> beWaterList = new ArrayDeque<>();

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            this.R = Integer.parseInt(st.nextToken());
            this.C = Integer.parseInt(st.nextToken());
            this.Map = new int[this.R][this.C];
            int duckIndex = 0;
            for (int i = 0; i < this.R; i++) {
                String line = input.readLine();
                for (int j = 0; j < this.C; j++) {
                    char each = line.charAt(j);
                    if (each == '.')
                        Map[i][j] = 0;
                    else if (each == 'X') {
                        iceList.add(new ice(i, j));
                        Map[i][j] = 1;
                    } else if (each == 'L')
                        Duck[duckIndex++] = new int[] { i, j };
                }
            }
            int day = 0;
            getDuck1(Duck[0][0], Duck[0][1]);
            getDuck2(Duck[1][0], Duck[1][1]);
            while (!canMeet) {
                dayMelt();
                day++;
            }
            System.out.println(day);
        }

        void getDuck1(int cX, int cY) {
            int nX, nY;
            Map[cX][cY] = 2;
            for (int[] eachM : move) {
                nX = cX + eachM[0];
                nY = cY + eachM[1];
                if (nX < 0 || nY < 0 || nX >= R || nY >= C)
                    continue;
                if (Map[nX][nY] == 1)
                    continue;
                if (Map[nX][nY] == 2)
                    continue;
                if (Map[nX][nY] == 3) {
                    canMeet = true;
                    return;
                }
                getDuck1(nX, nY);
            }
        }

        void getDuck2(int cX, int cY) {
            int nX, nY;
            Map[cX][cY] = 3;
            for (int[] eachM : move) {
                nX = cX + eachM[0];
                nY = cY + eachM[1];
                if (nX < 0 || nY < 0 || nX >= R || nY >= C)
                    continue;
                if (Map[nX][nY] == 1)
                    continue;
                if (Map[nX][nY] == 3)
                    continue;
                if (Map[nX][nY] == 2) {
                    canMeet = true;
                    return;
                }
                getDuck2(nX, nY);
            }
        }

        void dayMelt() {
            int nX, nY;
            int loopSize = iceList.size();
            ice temp;
            boolean d0, d1, d2;
            while (loopSize-- > 0) {
                temp = iceList.poll();
                d0 = d1 = d2 = false;
                for (int[] eachM : move) {
                    nX = temp.x + eachM[0];
                    nY = temp.y + eachM[1];
                    if (nX < 0 || nY < 0 || nX >= R || nY >= C)
                        continue;
                    if (Map[nX][nY] == 1)
                        continue;
                    if (Map[nX][nY] == 0)
                        d0 = true;
                    if (Map[nX][nY] == 2)
                        d1 = true;
                    if (Map[nX][nY] == 3)
                        d2 = true;
                }
                if (!d0 && !d1 && !d2) {
                    iceList.offer(temp);
                } else {
                    beWaterList.offer(new beWater(temp.x, temp.y, d0, d1, d2));
                }
            }
            beWater poss;
            while (!beWaterList.isEmpty()) {
                poss = beWaterList.poll();
                if (poss.d1 && poss.d2) {
                    canMeet = true;
                    return;
                }
                if (poss.d0) {
                    Map[poss.x][poss.y] = 0;
                    if (poss.d1)
                        getDuck1(poss.x, poss.y);
                    else if (poss.d2)
                        getDuck2(poss.x, poss.y);
                } else {
                    if (poss.d1) {
                        Map[poss.x][poss.y] = 2;
                        getDuck1(poss.x, poss.y);
                    }
                    if (poss.d2) {
                        Map[poss.x][poss.y] = 3;
                        getDuck2(poss.x, poss.y);
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
