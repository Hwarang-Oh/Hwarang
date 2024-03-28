import java.io.*;
import java.util.*;

public class B3055_탈출_오화랑 {
    static class pair {
        int x, y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int R, C;
    static boolean canGo;

    static int[][] Map;
    static boolean[][] waterVisit;
    static boolean[][] goVisit;
    static Queue<pair> goList = new ArrayDeque<>();
    static Queue<pair> waterList = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Map = new int[R][C];
        waterVisit = new boolean[R][C];
        goVisit = new boolean[R][C];
        String eachR;
        int sX, sY;
        sX = sY = 0;
        for (int i = 0 ; i < R ; i++) {
            eachR = input.readLine();
            for (int j = 0 ; j < C ; j++) {
                switch (eachR.charAt(j)) {
                    case '.': Map[i][j] = 0; break;
                    case '*': {
                        waterList.add(new pair(i, j));
                        Map[i][j] = 1;
                    } break;
                    case 'X': Map[i][j] = -1; break;
                    case 'S': {
                        Map[i][j] = 0;
                        sX = i; sY = j;
                        goVisit[sX][sY] = true;
                        goList.add(new pair(sX, sY));
                    } break;
                    case 'D': Map[i][j] = 2; break;
                }
            }
        }
        int[][] move = { {1,0}, {0, -1}, {-1, 0}, {0, 1} };
        int time = 0;
        while (!canGo) {
            int currX, currY, nextX, nextY;

            int waterSize = waterList.size();
            while (waterSize > 0) {
                pair temp = waterList.poll();
                waterSize--;
                currX = temp.x;
                currY = temp.y;
                for (int[] eachM : move) {
                    nextX = currX + eachM[0];
                    nextY = currY + eachM[1];
                    if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
                    if (Map[nextX][nextY] != 0) continue;
                    Map[nextX][nextY] = 1;
                    waterList.add(new pair(nextX, nextY));
                }
            }

            int goSize = goList.size();
            if (goSize == 0) break;
            while (goSize > 0) {
                pair temp = goList.poll();
                goSize--;
                currX = temp.x;
                currY = temp.y;
                for (int[] eachM : move) {
                    nextX = currX + eachM[0];
                    nextY = currY + eachM[1];
                    if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
                    if (goVisit[nextX][nextY]) continue;
                    if (Math.abs(Map[nextX][nextY]) == 1) continue;
                    if (Map[nextX][nextY] == 2) canGo = true;
                    goVisit[nextX][nextY] = true;
                    goList.add(new pair(nextX, nextY));
                }
            }
            time++;
        }
        if (canGo) System.out.println(time);
        else System.out.println("KAKTUS");
    }
}
// 탈출
// 티떱숲의 지도는 R행 C열로 이루어져 있다. 비어있는 곳 '.', 물이 차 있는 지역 '*', 돌은 'X'로 표시
// 비버의 굴은 'D', 고슴도치의 위치는 'S'
// 고슴도치는 현재 있는 칸과 인접한 네 칸 중 하나로 이동할 수 있다.
// 물과 고슴도치는 돌을 통과할 수 없다. 고슴도치는 물로 차있는 구역으로 이동 X, 물도 비버의 소굴로 이동 X
// 물이 먼저 이동하고 -> 고슴도치가 이동하는 방향으로 짜야 한다
// D와 S는 하나씩 주어진다.