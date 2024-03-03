import java.io.*;
import java.util.*;

public class S5644_무선충전_오화랑 {
    static int[] aWay, bWay;
    static PriorityQueue<int[]>[][] Map = new PriorityQueue [11][11];
    static int totalCharge, aRow, aCol, bRow, bCol;
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1, st2;
        int testCase = Integer.parseInt(input.readLine());
        for (int t = 1 ; t <= testCase ; t++) {
            st1 = new StringTokenizer(input.readLine());
            int moveNum = Integer.parseInt(st1.nextToken());
            int bcNum = Integer.parseInt(st1.nextToken());

            st1 = new StringTokenizer(input.readLine());
            st2 = new StringTokenizer(input.readLine());
            aWay = new int[moveNum];
            bWay = new int[moveNum];
            totalCharge = 0;
            for (int i = 0 ; i < moveNum ; i++) {
                aWay[i] = Integer.parseInt(st1.nextToken());
                bWay[i] = Integer.parseInt(st2.nextToken());
            }
            for (int i = 1 ; i <= 10 ; i++) {
                for (int j = 1 ; j <= 10 ; j++) {
                    Map[i][j] = new PriorityQueue<>(new Comparator<int[]>() {
                        @Override
                        public int compare(int[] o1, int[] o2) {
                            return Integer.compare(o2[1], o1[1]);
                        }
                    });
                }
            }
            int c, r, a, p;
            for (int i = 0 ; i < bcNum ; i++) {
                st1 = new StringTokenizer(input.readLine());
                c = Integer.parseInt(st1.nextToken());
                r = Integer.parseInt(st1.nextToken());
                a = Integer.parseInt(st1.nextToken());
                p = Integer.parseInt(st1.nextToken());
                for (int j = c - a ; j <= c + a; j++) {
                    for (int k = r - a ; k <= r + a ; k++) {
                        if (j < 1 || k < 1 || j > 10 || k > 10) continue;
                        if (Math.abs(j - c) + Math.abs(k - r) > a) continue;
                        Map[k][j].offer(new int[] {i, p});
                    }
                }
            }
            aRow = aCol = 1; bRow = bCol = 10;
            countPoint(aCol, aRow, bCol, bRow);
            for (int i = 0 ; i < moveNum ; i++) {
                ABwalk(i);
                countPoint(aCol, aRow, bCol, bRow);
            }
            System.out.printf("#%d %d%n", t, totalCharge);
        }
    }
    public static void ABwalk(int time) {
        switch (aWay[time]) {
            case 0: break; case 1: aCol--; break; case 2: aRow++; break;
            case 3: aCol++; break; case 4: aRow--; break;
        }
        switch (bWay[time]) {
            case 0: break; case 1: bCol--; break; case 2: bRow++; break;
            case 3: bCol++; break; case 4: bRow--; break;
        }
    }
    public static void countPoint(int aC, int aR, int bC, int bR) {
        PriorityQueue<int []> currA = Map[aC][aR];
        PriorityQueue<int []> currB = Map[bC][bR];
        if (currA.isEmpty() || currB.isEmpty()) case1_Count(currA, currB);
        else if (aC == bC && aR == bR) case2_Count(currA);
        else case3_Count(currA, currB);
    }
    public static void case1_Count(PriorityQueue<int []> currA, PriorityQueue<int []> currB ) {
        if (currA.isEmpty() && currB.isEmpty()) return;
        else if (currA.isEmpty()) totalCharge += currB.peek()[1];
        else totalCharge += currA.peek()[1];
    }
    public static void case2_Count(PriorityQueue<int []> currA) {
        int[] temp = currA.poll();
        if (!currA.isEmpty()) totalCharge += currA.peek()[1];
        totalCharge += temp[1];
        currA.offer(temp);
    }
    public static void case3_Count(PriorityQueue<int []> currA, PriorityQueue<int []> currB) {
        if (currA.peek()[0] == currB.peek()[0]) {
            int[] temp = currA.poll(); currB.poll();
            if (currA.isEmpty() || currB.isEmpty()) case1_Count(currA, currB);
            else {
                if (currA.peek()[1] >= currB.peek()[1]) totalCharge += currA.peek()[1];
                else totalCharge += currB.peek()[1];
            }
            totalCharge += temp[1];
            currA.offer(temp); currB.offer(temp);
        }
        else totalCharge += (currA.peek()[1] + currB.peek()[1]);
    }
}