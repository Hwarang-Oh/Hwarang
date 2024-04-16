import java.io.*;
import java.util.*;

public class B26170_사과빨리먹기_오화랑 {
    static int[][] Map = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int minWalk = Integer.MAX_VALUE;
    static boolean canMake3;
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for (int i = 0 ; i < 5 ; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0 ; j < 5 ; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(input.readLine());
        int sRow = Integer.parseInt(st.nextToken());
        int sCol = Integer.parseInt(st.nextToken());
        dfs(sRow, sCol, 0,0);
        if (canMake3) System.out.println(minWalk);
        else System.out.println(-1);
    }
    public static void dfs(int currX, int currY, int walkCnt, int aCnt) {
        int[][] moveM = { {1, 0}, {0, -1}, {-1, 0}, {0, 1} };
        if (aCnt == 3) {
            canMake3 = true;
            minWalk = Math.min(minWalk, walkCnt);
            return;
        }
        Map[currX][currY] = -1;
        for (int[] eachM : moveM) {
            int nextX = currX + eachM[0];
            int nextY = currY + eachM[1];
            if (nextX < 0 || nextY < 0 || nextX >= 5 || nextY >= 5) continue;

            if (Map[nextX][nextY] == -1) continue;
            else if (Map[nextX][nextY] == 1) {
                dfs(nextX, nextY, walkCnt + 1, aCnt + 1);
                Map[nextX][nextY] = 1;
            }
            else {
                dfs(nextX, nextY, walkCnt + 1, aCnt);
                Map[nextX][nextY] = 0;
            }
        }
    }
}

// 굉장히 중요한 문제!! => Why DFS로 풀어야 하는 문제일까??
// BFS로는 어려울까? => MAP의 상태가 내가 움질일 때 마다, 갈 수 있는 곳이 제한된다  => DFS로 각자의 경로를 가는 것이 나음
// 5*5 크기의 보드가 정해져 있느 상태
