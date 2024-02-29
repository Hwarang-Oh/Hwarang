import java.io.*;
import java.util.*;

public class S5644_무선충전_오화랑 {
    static ArrayList<ArrayList<PriorityQueue<int[]>>> Map;
    static int[] aWay, bWay;
    static int aRow, aCol, bRow, bCol;
    static int totalCharge;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st, temp = null;
        int testCase = Integer.parseInt(input.readLine());
        for (int t = 1 ; t <= testCase ; t++) {
            st = new StringTokenizer(input.readLine());
            int mNum = Integer.parseInt(st.nextToken());
            int bcNum = Integer.parseInt(st.nextToken());
            aWay = new int[mNum] ; bWay = new int[mNum];
            totalCharge = 0;
            aRow = aCol = 1; bRow = bCol = 10;

            st = new StringTokenizer(input.readLine());
            temp = new StringTokenizer(input.readLine());

            for (int i = 0 ; i < mNum ; i++) {
                aWay[i] = Integer.parseInt(st.nextToken());
                bWay[i] = Integer.parseInt(temp.nextToken());
            }

            Map = new ArrayList<>();
            for (int i = 0 ; i <= 10 ; i++) {
                Map.add(new ArrayList<>());
                for (int j = 0 ; j <= 10 ; j++) {
                    Map.get(i).add(new PriorityQueue<int[]>(new Comparator<int[]>() {
                        @Override
                        public int compare(int[] o1, int[] o2) {
                            return Integer.compare(o2[1], o1[1]);
                        }
                    }));
                }
            }

            int r, c, a, p;
            for (int i = 0 ; i < bcNum ; i++) {
                st = new StringTokenizer(input.readLine());
                r = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                a = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());

                for (int j = r - a ; j <= r + a ; j++) {
                    for (int k = c - a; k <= c + a ; k++) {
                        if(j < 1 || k < 1 || j > 10 || k > 10) continue;
                        if((Math.abs(j - r) + Math.abs(k - c)) > a) continue;
                        Map.get(j).get(k).offer(new int[] {i, p});
                    }
                }
            }
            for (int i = 0 ; i <= mNum ; i++) {
                if (i == 0) countPoint(Map.get(aRow).get(aCol), Map.get(bRow).get(bCol)); // 처음 위치
                else { // 이동하고 나서, 계산
                    aWalk(i); bWalk(i);
                    if(aRow == bRow && aCol == bCol) {
                        int[] sameLoc = Map.get(aRow).get(aCol).poll();
                        if(!Map.get(aRow).get(aCol).isEmpty()) {
                            totalCharge += Map.get(aRow).get(aCol).peek()[1];
                        }
                        totalCharge += sameLoc[1];
                        Map.get(aRow).get(aCol).offer(sameLoc);
                    }
                    else countPoint(Map.get(aRow).get(aCol), Map.get(bRow).get(bCol));
                }
                System.out.println(totalCharge);
            }
//            System.out.println(totalCharge);
        }
    }
    public static void aWalk(int time) {
        switch(aWay[time - 1]) {
            case 0: break; case 1: aRow--; break; case 2: aCol++; break;
            case 3: aRow++; break; case 4: aCol--; break;
        }
    }
    public static void bWalk(int time) {
        switch(bWay[time - 1]) {
            case 0: break; case 1: bRow--; break; case 2: bCol++; break;
            case 3: bRow++; break; case 4: bCol--; break;
        }
    }
    public static void countPoint(PriorityQueue<int []> a, PriorityQueue<int []> b) {
        if (a.isEmpty()) {
            if (!b.isEmpty()) totalCharge += b.peek()[1];
        }
        else {
            if (b.isEmpty()) totalCharge += a.peek()[1];
            else {
                if (a.peek()[0] == b.peek()[0]) tieCount(a,b);
                else totalCharge += (a.peek()[1] + b.peek()[1]);
            }
        }
    }
    public static void tieCount(PriorityQueue<int []> a, PriorityQueue<int []> b) {
        int[] temp = a.poll(); b.poll();
        if (a.isEmpty() && b.isEmpty()) {
            totalCharge += temp[1];
            a.offer(temp); b.offer(temp);
            return;
        }
        if (a.isEmpty() && !b.isEmpty()) {
            totalCharge += temp[1];
            totalCharge += b.peek()[1];
            a.offer(temp); b.offer(temp);
            return;
        }
        if (!a.isEmpty() && b.isEmpty()) {
            totalCharge += temp[1];
            totalCharge += a.peek()[1];
            a.offer(temp); b.offer(temp);
            return;
        }
        if (!a.isEmpty() && !b.isEmpty() && a.peek()[1] >= b.peek()[1]) totalCharge += (temp[1] + a.peek()[1]);
        else if ((!a.isEmpty() && !b.isEmpty() && a.peek()[1] < b.peek()[1])) totalCharge += (temp[1] + b.peek()[1]);
        a.offer(temp); b.offer(temp);
    }
}
