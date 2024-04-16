import java.io.*;
import java.util.*;

public class B19236_청소년상어_오화랑 {
    static class Shark {
        int x, y, eat, dir;
        public Shark(int x, int y, int eat, int dir) {
            this.x = x;
            this.y = y;
            this.eat = eat;
            this.dir = dir;
        }
    }
    static class fish {
        int x, y, num, dir;
        public fish(int x, int y, int num, int dir) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
        }
    }
    static int maxEat;
    static int[][] move = { {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1} };
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        Shark shark = null;
        fish[][] ocean = new fish[4][4];
        PriorityQueue<fish> fishList = new PriorityQueue<>(16, (o1, o2) ->
                Integer.compare(o1.num, o2.num));

        int fN, fD;
        for (int i = 0 ; i < 4 ; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0 ; j < 4 ; j++) {
                fN = Integer.parseInt(st.nextToken());
                fD = Integer.parseInt(st.nextToken());
                if (i == 0 && j == 0) {
                    shark = new Shark(i, j, fN, fD);
                    continue;
                }
                ocean[i][j] = new fish(i, j, fN, fD);
                fishList.offer(ocean[i][j]);
            }
        }
        hunt(shark, fishList, ocean);
        System.out.println(maxEat);
    }
    public static void hunt(Shark shark, PriorityQueue<fish> fishList, fish[][] ocean) {
        // fish Move
        int cX, cY, cD, nX, nY;
        boolean trapped;
        fish tempFish1, tempFish2;
        while (!fishList.isEmpty()) {
            tempFish1 = fishList.poll();
            cX = tempFish1.x;
            cY = tempFish1.y;
            cD = tempFish1.dir;
            nX = cX + move[cD - 1][0];
            nY = cY + move[cD - 1][1];
            if (nX < 0 || nY < 0 || nX >= 4 || nY >= 4 || (nX == shark.x && nY == shark.y) ) {
                trapped = true;
                for (int i = 1 ; i <= 8 ; i++) {
                    cD++;
                    if (cD > 8) cD = 1;
                    nX = cX + move[cD - 1][0];
                    nY = cY + move[cD - 1][1];
                    if (nX < 0 || nY < 0 || nX >= 4 || nY >= 4 || (nX == shark.x && nY == shark.y) ) continue;
                    else { trapped = false; break; }
                }
                if (!trapped) {
                    tempFish1.x = nX;
                    tempFish1.y = nY;
                    tempFish1.dir = cD;
                    if (ocean[nX][nY] == null) {
                        ocean[nX][nY] = tempFish1;
                        ocean[cX][cY] = null;
                    }
                    else {
                        tempFish2 = ocean[nX][nY];
                        tempFish2.x = cX;
                        tempFish2.y = cY;
                        ocean[nX][nY] = tempFish1;
                        ocean[cX][cY] = tempFish2;
                    }
                }
            }
            else {
                tempFish1.x = nX;
                tempFish1.y = nY;
                if (ocean[nX][nY] == null) {
                    ocean[nX][nY] = tempFish1;
                    ocean[cX][cY] = null;
                }
                else {
                    tempFish2 = ocean[nX][nY];
                    tempFish2.x = cX;
                    tempFish2.y = cY;
                    ocean[nX][nY] = tempFish1;
                    ocean[cX][cY] = tempFish2;
                }
            }
        }
        // shark Move
        nX = shark.x;
        nY = shark.y;
        cD = shark.dir;
        Shark nextShark = null;
        fish[][] nextOcean;
        PriorityQueue<fish> nextFishList;
        for (int i = 0 ; i < 3 ; i++) {
            nX += move[cD - 1][0];
            nY += move[cD - 1][1];
            if (nX < 0 || nY < 0 || nX >= 4 || nY >= 4) continue;
            if (ocean[nX][nY] == null) continue;
            nextShark = new Shark(nX, nY, shark.eat + ocean[nX][nY].num, ocean[nX][nY].dir);
            nextOcean = new fish[4][4];
            nextFishList = new PriorityQueue<>(16, (o1, o2) -> Integer.compare(o1.num, o2.num));
            for (int r = 0 ; r < 4 ; r++) {
                for (int c = 0 ; c < 4 ; c++) {
                    if (r == nX && c == nY) continue;
                    if (ocean[r][c] == null) continue;
                    nextOcean[r][c] = new fish(r, c, ocean[r][c].num, ocean[r][c].dir);
                    nextFishList.offer(nextOcean[r][c]);
                }
            }
            hunt(nextShark, nextFishList, nextOcean);
        }
        maxEat = Integer.max(maxEat, shark.eat);
    }
}
