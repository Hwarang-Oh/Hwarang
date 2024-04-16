import java.io.*;
import java.util.*;

public class B17779_게리맨더링2_오화랑 {
    static class pair {
        int x, y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] Map;
    static int totalCnt;
    static int minDiff = Integer.MAX_VALUE;
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
                totalCnt += Map[i][j];
                if (i < size - 2 && j >= 1 && j < size - 1)
                    checkList.offer(new pair(i, j));
            }
        }
        for (pair each : checkList) divide(each, size);
        System.out.println(minDiff);
    }
    public static void divide(pair each, int size) {
        int d1_max = each.y;
        int d2_max = size - 1 - each.y;
        int sum_max = size - 1 - each.x;

        for (int d1 = 1 ; d1 <= d1_max ; d1++) {
            for (int d2 = 1 ; d2 <= d2_max ; d2++) {
                if (d1 + d2 > sum_max) continue;
                calculate(each, size, d1, d2);
            }
        }
    }

    public static void calculate(pair each, int size, int d1, int d2) {
        PriorityQueue<Integer> pList = new PriorityQueue<>();
        int not5Sum = 0;
        int currMin, currMax, dis1Sum, dis2Sum, dis3Sum, dis4Sum;

        // district 1 ( each.x , each.y ~ each.x + d1, each.y - d1 )
        int currY = each.y;
        dis1Sum = 0;
        for (int i = 0 ; i < each.x + d1 ; i++) {
            if (i < each.x)
                for (int j = 0 ; j <= currY ; j++) dis1Sum += Map[i][j];
            else {
                for (int j = 0; j < currY; j++) dis1Sum += Map[i][j];
                currY--;
            }
        }

        // district 2 ( each.x, each.y ~ each.x + d2, each.y + d2 )
        currY = each.y;
        dis2Sum = 0;
        for (int i = 0 ; i <= each.x + d2 ; i++) {
            if (i < each.x)
                for (int j = size - 1 ; j > currY ; j--) dis2Sum += Map[i][j];
            else {
                for (int j = size - 1; j > currY; j--) dis2Sum += Map[i][j];
                currY++;
            }
        }

        // district 3 ( each.x + d1 , each.y - d1 ~ each.x + d1 + d2 , each.y - d1 + d2 )
        currY = each.y;
        dis3Sum = 0;
        for (int i = size - 1 ; i >= each.x + d1 ; i--) {
            if (i > each.x + d1 + d2)
                for (int j = 0 ; j < currY - d1 + d2 ; j++) dis3Sum += Map[i][j];
            else {
                for (int j = 0; j < currY - d1 + d2; j++) dis3Sum += Map[i][j];
                currY--;
            }
        }

        // district 4 ( each.x + d2, each.y + d2 ~ each.x + d2 + d1 , each.y + d2 - d1 )
        currY = each.y;
        dis4Sum = 0;
        for (int i = size - 1 ; i > each.x + d2 ; i--) {
            if ( i > each.x + d1 + d2 )
                for (int j = size - 1 ; j >= currY -d1 + d2 ; j--) dis4Sum += Map[i][j];
            else {
                for (int j = size - 1 ; j > currY - d1 + d2 ; j--) dis4Sum += Map[i][j];
                currY++;
            }
        }

        // district 5 : complement Set of other sum
        not5Sum = dis1Sum + dis2Sum + dis3Sum + dis4Sum;
        pList.offer(dis1Sum);
        pList.offer(dis2Sum);
        pList.offer(dis3Sum);
        pList.offer(dis4Sum);
        pList.offer(totalCnt - not5Sum);

        currMin = pList.poll();
        pList.poll();
        pList.poll();
        pList.poll();
        currMax = pList.poll();
        minDiff = Math.min(minDiff, currMax - currMin);
    }
}
// d1 d2의 제약
// 1. 1 <= d1, d2
// 2. d1 <= y
// 3. d2 <= size - 1 - y
// 4. d1 + d2 <= szie - 1 - x



/*
5번 선거구의 경계구역이 넘어가는 경우는 존재 X
=> size : N일때 계산해야 하는 구역
(0, 1) ~ (0, size - 2)
~
(size - 2, 1) ~ (size - 2, size - 2)
 */

//while (!checkList.isEmpty())
//        System.out.println(checkList.poll());
//        System.out.println();
//        for (int i = 0 ; i < size ; i++) System.out.println(Arrays.toString(Map[i]));
