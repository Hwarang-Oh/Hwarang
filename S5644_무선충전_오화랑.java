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

            int r, c, a, p;
            for (int i = 0 ; i < bcNum ; i++) {
                st1 = new StringTokenizer(input.readLine());
                r = Integer.parseInt(st1.nextToken());
                c = Integer.parseInt(st1.nextToken());
                a = Integer.parseInt(st1.nextToken());
                p = Integer.parseInt(st1.nextToken());
                for (int j = r - a ; j <= r + a; j++) {
                    for (int k = c - a ; k <= c + a ; k++) {
                        if (j < 1 || k < 1 || j > 10 || k > 10) continue;
                        if ( Math.abs(j - r) + Math.abs(k - c) > a) continue;
                        Map[j][k].offer(new int[] {i, p});
                    }
                }
            }

            for (int i = 1 ; i <= 10 ; i++) {
                for (int  j = 1 ; j <= 10 ; j++) {
                    System.out.print(Arrays.toString(Map[i][j].peek()) + "\t");
                }
                System.out.println();
            }

            aRow = aCol = 1; bRow = bCol = 10;
            for (int i = 0 ; i <= moveNum ; i++) {
                if (i == 0) countPoint(aRow, aCol, bRow, bCol);
                else {
                    ABwalk(i);
                    countPoint(aRow,aCol,bRow,bCol);
                }
            }
            System.out.println(totalCharge);
        }
    }
    public static void ABwalk(int time) {
        switch (aWay[time - 1]) {
            case 0: break;
            case 1: aRow--; break;
            case 2: aCol++; break;
            case 3: aRow++; break;
            case 4: aCol--; break;
        }

        switch (bWay[time - 1]) {
            case 0: break;
            case 1: bRow--; break;
            case 2: bCol++; break;
            case 3: bRow++; break;
            case 4: bCol--; break;
        }
    }

    public static void countPoint(int aR, int aC, int bR, int bC) {
        PriorityQueue<int []> currA = Map[aR][aC];
        PriorityQueue<int []> currB = Map[bR][bC];

        if (currA.isEmpty() || currB.isEmpty()) case1_Count(currA, currB);
        else case2_Count(currA, currB);
    }
    public static void case1_Count(PriorityQueue<int []> currA, PriorityQueue<int []> currB ) {
        if (currA.isEmpty() && currB.isEmpty()) return;
        else if (currA.isEmpty()) totalCharge += currB.peek()[1];
        else totalCharge += currA.peek()[1];
    }

    public static void case2_Count(PriorityQueue<int []> currA, PriorityQueue<int []> currB) {
        if (currA.peek()[0] == currB.peek()[0]) {
            int[] temp = currA.poll(); currB.poll();
            if (currA.isEmpty() || currB.isEmpty()) {
                case1_Count(currA, currB);
                totalCharge += temp[1];
            }
            else {
                if (currA.peek()[1] >= currB.peek()[1]) totalCharge += currA.peek()[1];
                else totalCharge += currB.peek()[1];
                totalCharge += temp[1];
            }
            currA.offer(temp); currB.offer(temp);
        }
        else totalCharge += ( currA.peek()[1] + currB.peek()[1]);
    }
}

