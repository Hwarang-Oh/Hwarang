import java.io.*;
import java.util.*;


public class B20056_마법사상어와파이어볼_오화랑 {
    static class fireBall {
        int fNum;
        int r, c, m, s, d;

        public fireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
            this.fNum = 1;
        }

        public fireBall(int r, int c) {
            this.r = r;
            this.c = c;
            this.m = 0;
            this.s = 0;
            this.d = 0;
            this.fNum = 0;
        }
        public void moveBall() {
            int[][] moveWay = { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };
            int realMove = s % (Map.size() - 1);
            r += realMove * moveWay[d][0];
            c += realMove * moveWay[d][0];

        }


        @Override
        public String toString() {
            return "fireBall{" +
                    "fNum=" + fNum +
                    ", r=" + r +
                    ", c=" + c +
                    ", m=" + m +
                    ", s=" + s +
                    ", d=" + d +
                    '}';
        }
    }

    static ArrayList<ArrayList<fireBall>> Map;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()); // 격자 크기 : N
        int M = Integer.parseInt(st.nextToken()); // 파이어볼 개수 : M
        int K = Integer.parseInt(st.nextToken()); // 이동 개수 : K
        Map = new ArrayList<>(N + 1);

        for (int i = 0 ; i <= N ; i++) {
            Map.add(new ArrayList<>());
            for (int j = 0 ; j <= N ; j++) {
                Map.get(i).add(new fireBall(i, j));
            }
        }

        int r, c, m, s, d;
        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(input.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            Map.get(r).get(c).m = m;
            Map.get(r).get(c).s = s;
            Map.get(r).get(c).d = d;
            Map.get(r).get(c).fNum++;
        }

        for (ArrayList<fireBall> each : Map)
            System.out.println(each);

    }
    public static void move(int N) {
        ArrayList<ArrayList<fireBall>> nextMap = new ArrayList<>(N + 1);
        for (int i = 0 ; i <= N ; i++) {
            nextMap.add(new ArrayList<>());
            for (int j = 0 ; j <= N ; j++) {
                nextMap.get(i).add(new fireBall(i, j));
            }
        }


        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                if (Map.get(i).get(j).fNum >= 1) {

                }
            }
        }
    }

}

// 격자의 행과 열은 1번 N번까지 번호가 매겨져 있고 1번 행 - N번 행과 연결, 1번 열은 N번 열과 연결되어 있음
// 파이어볼 -> 방향 , 속력만큼 이동함 => 이동하는 중에 같은 칸에 여러개의 파이어볼 존재
// 2개 이상 파이어볼 -> 하나로 합쳐진다 => 4개로 나누어진다.
// 질량은 sum / 5 , 속력은 sum / 개수, 모두 홀수 or 짝수면 방향 0 2 4 6 / 1 3 5 7
// 4 <= N <= 50 격자
// 0 <= M <= N^2 최대 2500개 파이어볼
// 1 <= K <= 1000 명령
// 연결되어 있는 것을 주의해야 함.
// 파이어볼 위치 r, c,질량 m, 속도 s, 방향 7
// 1000 * 2500 -> int 처리 가능
