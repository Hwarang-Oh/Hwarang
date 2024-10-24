import java.io.*;
import java.util.*;

/**
 * IMP : https://www.acmicpc.net/problem/11758
 * * 2차원 좌표 평면 위에 있는 점 3개 P1, P2, P3 -> 순서대로 이은 선분이 어떤 방향을 이루고 있는가?
 * * 좌표 3개 & 정수값 좌표, 서로 다른 3개의 좌표
 * * 선분이 반시계 방향 => 1, 시계방향 => -1, 일직선 0
 * * 생각보다 더 고려할 것이 많을 수 있겠다!!
 */

public class B11758_CCW_오화랑 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Solution {
        Pair p1, p2, p3;
        StringTokenizer st;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            int eachX, eachY;
            for (int i = 1; i <= 3; i++) {
                st = new StringTokenizer(input.readLine());
                eachX = Integer.parseInt(st.nextToken());
                eachY = Integer.parseInt(st.nextToken());
                if (i == 1)
                    p1 = new Pair(eachX, eachY);
                else if (i == 2)
                    p2 = new Pair(eachX, eachY);
                else
                    p3 = new Pair(eachX, eachY);
            }
            System.out.println(getClockValue(p1, p2, p3));
        }

        int getClockValue(Pair p1, Pair p2, Pair p3) {
            if ((p2.x - p1.x) == 0) {
                if (p1.x > p3.x)
                    return 1;
                else if (p1.x == p3.x)
                    return 0;
                else
                    return -1;
            }

            int deg = (p2.y - p1.y) / (p2.x - p1.x);
            int stand = deg * p3.x - deg * p1.x + p1.y;
            if (stand > p3.y)
                return -1;
            else if (stand == p3.y)
                return 0;
            else
                return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}