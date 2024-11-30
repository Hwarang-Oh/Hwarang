
/**
 * IMP : https://www.acmicpc.net/problem/15686
 * * Re : 치킨 배달 => 한때, '순조부'를 잘했을 때 풀고자 노력했던 문제 
 * * R X C 형태 ( R 행, C 열 ) => (r, c) : 위에서 부터 r번째 칸, 왼쪽에서 부터 c번째 칸 ( r, c >= 1 )
 * * 치킨 거리 => 집과 가장 가까운 치킨집의 거리 => 도시의 치킨 거리 : Sum of Each 치킨 거리
 * * 최대 M개의 치킨 집을 골랐을 때, 도시의 치킨 거리의 최소값을 구하여라 
 * Type : 순 조 부 
 * IMP : 최대 13개 중 M 개를 선택하는 느낌 => 13C6 / 13C7이 최대가 됨 => 1716
 * 
 */

import java.io.*;
import java.util.*;

public class B15686_치킨배달_오화랑 {

    static class Home {
        int x, y;

        public Home(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Chicken {
        int x, y;
        boolean selected;

        public Chicken(int x, int y, boolean selected) {
            this.x = x;
            this.y = y;
            this.selected = selected;
        }
    }

    static class Solution {
        int N, M;
        int[][] Map;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Map = new int[N][M];

            for 
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }

}