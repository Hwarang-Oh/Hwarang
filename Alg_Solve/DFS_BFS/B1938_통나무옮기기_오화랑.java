import java.io.*;
import java.util.*;

/*
 * U : 통나무 위로 1
 * D : 통나무 아래 1
 * L : 통나무 왼쪽 1
 * R : 통나무 우측 1
 * T : 통나무 중심 회전 90도 -> ( | , ㅡ ) 형태
 * 1 -> 다른 나무
 * 0 -> 빈 공간
 * B0011
 * B0000
 * B0000
 * 11000
 * EEE00
 * => BBB 통나무 중심의 3 * 3에 다른 나무 1이 있으면 회전이 불가함.
 */

public class B1938_통나무옮기기_오화랑 {

    static class log {
        int mX, mY, state, count;

        public log(int mX, int mY, int state, int count) {
            this.mX = mX;
            this.mY = mY;
            this.state = state; // 0 -> ㅡ , 1 -> |
            this.count = count;
        }

        @Override
        public String toString() {
            return "log [mX=" + mX + ", mY=" + mY + ", state=" + state + ", count=" + count + "]";
        }

    }

    static int[][] Map;
    static boolean[][] visitedByV;
    static boolean[][] visitedByH;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(input.readLine());
        Map = new int[size][size];
        visitedByH = new boolean[size][size];
        visitedByV = new boolean[size][size];
        String line;
        ArrayList<Integer> checkState = new ArrayList<>(6);
        ArrayList<Integer> checkState2 = new ArrayList<>(6);
        for (int i = 0; i < size; i++) {
            line = input.readLine();
            for (int j = 0; j < size; j++) {
                switch (line.charAt(j)) {
                    case 'B':
                        Map[i][j] = 2;
                        checkState.add(i);
                        checkState.add(j);
                        break;
                    case 'E':
                        Map[i][j] = 3;
                        checkState2.add(i);
                        checkState2.add(j);
                        break;
                    case '1':
                        Map[i][j] = 1;
                        break;
                    case '0':
                        Map[i][j] = 0;
                }
            }
        }
        log temp;
        if (checkState.get(0) == checkState.get(2)) {
            temp = new log(checkState.get(2), checkState.get(3), 0, 0);
            visitedByH[checkState.get(2)][checkState.get(3)] = true;
        } else {
            temp = new log(checkState.get(2), checkState.get(3), 1, 0);
            visitedByV[checkState.get(2)][checkState.get(3)] = true;
        }
        log end;
        if (checkState2.get(0) == checkState2.get(2))
            end = new log(checkState2.get(2), checkState2.get(3), 0, 0);
        else
            end = new log(checkState2.get(2), checkState2.get(3), 1, 0);

        Queue<log> logList = new ArrayDeque<>();
        logList.offer(temp);
        int[][] move = {
                { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
        };
        int mX, mY, nX, nY;
        boolean canTurn;
        boolean canMake = false;
        while (!logList.isEmpty()) {
            temp = logList.poll();
            mX = temp.mX;
            mY = temp.mY;
            canTurn = true;
            if (mX == end.mX && mY == end.mY && temp.state == end.state) {
                System.out.println(temp.count);
                canMake = true;
                break;
            }
            if (temp.state == 0) {
                for (int[] eachM : move) {
                    nX = mX + eachM[0]; // n-1X == nX == n+1X
                    nY = mY + eachM[1]; // n-1Y + 1 == nY == n+1Y - 1
                    if (nX < 0 || nX >= size || nY < 1 || nY >= size - 1)
                        continue;
                    if (Map[nX][nY] == 1 || Map[nX][nY - 1] == 1 || Map[nX][nY + 1] == 1)
                        continue;
                    if (visitedByH[nX][nY])
                        continue;
                    visitedByH[nX][nY] = true;
                    logList.offer(new log(nX, nY, temp.state, temp.count + 1));
                }
                for (int i = -1; i < 2; i++) {
                    if (!canTurn)
                        break;
                    for (int j = -1; j < 2; j++) {
                        nX = mX + i;
                        nY = mY + j;
                        if (nX < 0 || nY < 0 || nX >= size || nY >= size) {
                            canTurn = false;
                            continue;
                        }
                        if (Map[nX][nY] == 1)
                            canTurn = false;
                    }
                }

                if (canTurn && !visitedByV[mX][mY]) {
                    visitedByV[mX][mY] = true;
                    logList.offer(new log(mX, mY, temp.state + 1, temp.count + 1));
                }

            } else {
                for (int[] eachM : move) {
                    nX = mX + eachM[0]; // n-1X + 1 == nX == n+1X
                    nY = mY + eachM[1]; // n-1Y == nY == n+1Y
                    if (nY < 0 || nY >= size || nX < 1 || nX >= size - 1)
                        continue;
                    if (Map[nX][nY] == 1 || Map[nX - 1][nY] == 1 || Map[nX + 1][nY] == 1)
                        continue;
                    if (visitedByV[nX][nY])
                        continue;
                    visitedByV[nX][nY] = true;
                    logList.offer(new log(nX, nY, temp.state, temp.count + 1));
                }

                for (int i = -1; i < 2; i++) {
                    if (!canTurn)
                        break;
                    for (int j = -1; j < 2; j++) {
                        nX = mX + i;
                        nY = mY + j;
                        if (nX < 0 || nY < 0 || nX >= size || nY >= size) {
                            canTurn = false;
                            continue;
                        }
                        if (Map[nX][nY] == 1)
                            canTurn = false;
                    }
                }
                if (canTurn && !visitedByH[mX][mY]) {
                    visitedByH[mX][mY] = true;
                    logList.offer(new log(mX, mY, temp.state - 1, temp.count + 1));
                }
            }
        }
        if (!canMake)
            System.out.println(0);
    }
}
