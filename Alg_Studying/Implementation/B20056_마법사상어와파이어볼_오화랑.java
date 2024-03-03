import java.io.*;
import java.util.*;

public class B20056_마법사상어와파이어볼_오화랑 {
    static class fireBall {
        int fNum; // 현재 칸의 FireBall 개수
        int r, c, m, s, d, TMass; // row col mass speed direction
        int standard = -1; // 합쳐지는 FireBall의 even/odd 판단값
        int spreadM = 1; // 합쳐진 FireBall의 이동 Method -> 1 : 0246 / 2 : 1357
        boolean haveToCheck = true; // 합쳐지는 FireBall에 대한 이동 판단의 여부
        public fireBall(int r, int c, int m, int s, int d) {
            this.r = r; this.c = c;
            this.m = m; this.s = s;
            this.d = d; this.fNum = 1;
            TMass = m * fNum; // 1개만 있을 때는, 무게 * FireBall 개수가 총 무게!
        }
        public void moveBall(int size) {
            int[][] moveWay = { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };
            int realMove = s % (size);
            r += realMove * moveWay[d][0]; // 실제로 이동을 하는 개수
            c += realMove * moveWay[d][1];
            if (r > size) r -= size; if (r < 1) r += size;
            if (c > size) c -= size; if (c < 1) c += size;
        }
        public void addBall(fireBall nextF) { // fireBall이 같은 위치에 있다면
            this.TMass += nextF.m;
            this.s += nextF.s;
            this.fNum++;

            standard = this.d % 2;
            if (haveToCheck) {
                if (nextF.d % 2 != standard) {
                    spreadM = 2;
                    haveToCheck = false;
                }
            }
        }
        public void updateBall() {
            this.m = TMass / 5;
            this.s /= this.fNum;
            fNum = 4;
        }
    }
    static ArrayList<fireBall> fList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()); // 격자 크기 : N
        int M = Integer.parseInt(st.nextToken()); // 파이어볼 개수 : M
        int K = Integer.parseInt(st.nextToken()); // 이동 개수 : K
        int r, c, m, s, d;
        int totalMass = 0;
        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(input.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            fList.add(new fireBall(r,c,m,s,d));
        }
        for (int i = 0 ; i < K ; i++){
            move(N);
        }
        for (fireBall eachF : fList) totalMass += (eachF.m * eachF.fNum);
        System.out.println(totalMass);
    }
    public static void move(int N) {
        ArrayList<fireBall> nextFList = new ArrayList<>();
        PriorityQueue<fireBall> tempList = new PriorityQueue<>(new Comparator<fireBall>() {
            @Override
            public int compare(fireBall o1, fireBall o2) {
                int diff = Integer.compare(o1.r, o2.r);
                return diff != 0 ? diff : Integer.compare(o1.c, o2.c);
            }
        });
        for (fireBall eachF : fList) {
            if (eachF.fNum == 4) {
                for (int i = 0; i < 4; i++) {
                    if (eachF.spreadM == 1) {
                        fireBall nextF = new fireBall(eachF.r, eachF.c, eachF.m, eachF.s, 2 * i);
                        nextF.moveBall(N);
                        tempList.offer(nextF);
                    } else {
                        fireBall nextF = new fireBall(eachF.r, eachF.c, eachF.m, eachF.s, 2 * i + 1);
                        nextF.moveBall(N);
                        tempList.offer(nextF);
                    }
                }
            }
            else {
                eachF.moveBall(N);
                tempList.offer(eachF);
            }
        }
        while(!tempList.isEmpty()) {
            fireBall currF = tempList.poll();
            while(!tempList.isEmpty()) {
                fireBall nextF = tempList.peek();
                if (currF.r == nextF.r && currF.c == nextF.c) {
                    tempList.poll();
                    currF.addBall(nextF);
                }
                else break;
            }
            if (currF.fNum >= 2) currF.updateBall();
            if (currF.m >= 1) nextFList.add(currF);
        }
        fList = nextFList;
    }
}
