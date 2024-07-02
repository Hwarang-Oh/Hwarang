import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/3197
public class B3197_백조의호수_오화랑 {
    static class Ice {
        int x, y;

        public Ice(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Water {
        int x, y;
        boolean d1, d2;

        public Water(int x, int y, boolean d1, boolean d2) {
            this.x = x;
            this.y = y;
            this.d1 = d1;
            this.d2 = d2;
        }
    }

    static class Solution {
        int R, C;
        int[][] Move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        boolean Made;
        boolean[][] Water;
        boolean[][] possDuck1;
        boolean[][] possDuck2;
        ArrayDeque<Ice> iceList = new ArrayDeque<>();
        ArrayDeque<Ice> willBeWaterList = new ArrayDeque<>();
        int[][] Duck = new int[2][2];

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            this.R = Integer.parseInt(st.nextToken());
            this.C = Integer.parseInt(st.nextToken());
            this.Water = new boolean[this.R][this.C];
            this.possDuck1 = new boolean[this.R][this.C];
            this.possDuck2 = new boolean[this.R][this.C];

            int eachDuck = 0;
            for (int i = 0; i < this.R; i++) {
                String line = input.readLine();
                for (int j = 0; j < this.C; j++) {
                    switch (line.charAt(j)) {
                        case '.':
                            Water[i][j] = true;
                            break;
                        case 'X':
                            iceList.offer(new Ice(i, j));
                            break;
                        case 'L': {
                            Water[i][j] = true;
                            Duck[eachDuck++] = new int[] { i, j };
                            break;
                        }
                    }
                }
            }
            getDuckPoss(); // 1. 초기 Duck1과 Duck2의 가능 영역을 계산한다.
            int day = 0;
            while (!Made) {
                melt();
                day++;
            }
            System.out.println(day);
        }

        void getDuckPoss() {
            int[] Duck1 = Duck[0];
            int[] Duck2 = Duck[1];
            getPoss(Duck1[0], Duck1[1], 1);
            getPoss(Duck2[0], Duck2[1], 2);
        }

        void getPoss(int sX, int sY, int i) {
            int nX, nY;
            if (i == 1) {
                possDuck1[sX][sY] = true;
                for (int[] eachM : Move) {
                    nX = sX + eachM[0];
                    nY = sY + eachM[1];
                    if (nX < 0 || nY < 0 || nX >= this.R || nY >= this.C)
                        continue;
                    if (!Water[nX][nY] || possDuck1[nX][nY])
                        continue;
                    getPoss(nX, nY, i);
                }
            } else {
                possDuck2[sX][sY] = true;
                for (int[] eachM : Move) {
                    nX = sX + eachM[0];
                    nY = sY + eachM[1];
                    if (nX < 0 || nY < 0 || nX >= this.R || nY >= this.C)
                        continue;
                    if (!Water[nX][nY] || possDuck2[nX][nY])
                        continue;
                    getPoss(nX, nY, i);
                }
            }
        }

        void melt() {
            int size = iceList.size();
            int nX, nY;
            boolean melt;
            Ice temp;
            while (size-- > 0) {
                melt = false;
                temp = iceList.poll();
                for (int[] eachM : Move) {
                    nX = temp.x + eachM[0];
                    nY = temp.y + eachM[1];
                    if (nX < 0 || nY < 0 || nX >= R || nY >= C)
                        continue;
                    if (Water[nX][nY]) {
                        melt = true;
                        break;
                    }
                }
                if (melt)
                    willBeWaterList.offer(temp);
                else
                    iceList.offer(temp);
            }
            while (!willBeWaterList.isEmpty()) {
                boolean d1 = false;
                boolean d2 = false;
                temp = willBeWaterList.poll();
                for (int[] eachM : Move) {
                    nX = temp.x + eachM[0];
                    nY = temp.y + eachM[1];
                    if (nX < 0 || nY < 0 || nX >= R || nY >= C)
                        continue;
                    if (possDuck1[nX][nY]) {
                        d1 = true;
                    }
                    if (possDuck2[nX][nY]) {
                        d2 = true;
                    }
                }
                if (d1 && d2) {
                    possDuck1[temp.x][temp.y] = true;
                    possDuck2[temp.x][temp.y] = true;
                    Made = true;
                } else if (d1) {
                    possDuck1[temp.x][temp.y] = true;
                } else if (d2) {
                    possDuck2[temp.x][temp.y] = true;
                }
                Water[temp.x][temp.y] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}
