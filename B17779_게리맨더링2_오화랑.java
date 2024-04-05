import java.io.*;
import java.util.*;

public class B17779_게리맨더링2_오화랑 {
    static class pair {
        int x, y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static int[][] Map;
    static Queue<pair> checkList = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int size = Integer.parseInt(input.readLine());
        Map = new int[size][size];
        for (int i = 0 ; i < size ; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0 ; j < size ; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
                if (i >= 0 && i < size - 1 && j >= 1 && j < size - 1)
                    checkList.offer(new pair(i, j));
            }
        }
        while (!checkList.isEmpty()) {
            for ()
        }
    }
}

/*
5번 선거구의 경계구역이 넘어가는 경우는 존재 X
=> size : N일때 계산해야 하는 구역
(0, 1) ~ (0, size - 2)
~
(size - 2, 1) ~ (size - 2, size - 2)
 */
