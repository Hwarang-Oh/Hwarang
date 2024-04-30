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
        int mX, mY, state;

        public log(int mX, int mY, int state) {
            this.mX = mX;
            this.mY = mY;
            this.state = state; // 0 -> ㅡ , 1 -> |
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
            temp = new log(checkState.get(2), checkState.get(3), 0);
            visitedByH[checkState.get(2)][checkState.get(3)] = true;
        } else {
            temp = new log(checkState.get(2), checkState.get(3), 1);
            visitedByV[checkState.get(2)][checkState.get(3)] = true;
        }

        Queue<log> logList = new ArrayDeque<>();
        logList.offer(temp);
        int[][] move = {
                { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
        };
        while (!logList.isEmpty()) {
            temp = logList.poll();
            if (temp.state == 1) {

            } else {

            }
        }
    }
}
