import java.io.*;
import java.util.*;

public class S1767_프로세서연결하기_오화랑 {
    static int[][] core;
    static ArrayList<int[]> pros = new ArrayList<>();
    static int[][] used;
    static boolean canConnect;
    static PriorityQueue<int[]> minLine = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            int diff = Integer.compare(o2[0], o1[0]);
            return diff != 0 ? diff : Integer.compare(o1[1], o2[1]);
        }
    });


    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(input.readLine());
        for (int t = 1 ; t <= testCase ; t++) {
            int size = Integer.parseInt(input.readLine());
            core = new int[size][size];
            sb.append("#").append(t).append(" ");

            int eachCore;
            for (int i = 0 ; i < size ; i++) {
                st = new StringTokenizer(input.readLine());
                for (int j = 0 ; j < size ; j++) {
                    eachCore = Integer.parseInt(st.nextToken());
                    if ((i == 0 || j == 0) && eachCore == 1) core[i][j] = 2;
                    else {
                        core[i][j] = eachCore;
                        if (core[i][j] == 1) pros.add(new int[] {i,j});
                    }
                }
            }
//            for (int i = 1 ; i <= pros.size() ; i++) {
//                used = new int[i][];
//                connect(0,0,i);
//                if (!canConnect) break;
//                else canConnect = false;
//            }
            for (int i = pros.size() ; i >= 0 ; i--) {
                used = new int[i][];
                connect(0,0,i);
                if (canConnect) break;
            }
            sb.append(minLine.poll()[1]).append("\n");
            pros.clear();
            minLine.clear();
            canConnect = false;
        }
        System.out.print(sb);
    }
    public static void connect(int cnt, int start, int useCnt) {
        // 1개, 2개, 3개, 4개, 5개 ... 12개 ->  중간에 완성 불가 시 다음 단계 X
        // 일단은 각 선택 개수에 맞는 조합을 구하는 Code
        if (cnt == useCnt) {
            check(0);
            return;
        }
        for (int i = start ; i < pros.size() ; i++) {
            used[cnt] = pros.get(i);
            connect(cnt + 1, i + 1, useCnt);
        }
    }
    public static void check(int cnt){
        if (cnt == used.length) {
            canConnect = true;
            minLine.offer(new int[] {cnt, lineFind()});
            return;
        }

        for (int i = 0 ; i < 4 ; i++) {
            if (coloring(used[cnt], cnt + 3, i)) {
                check(cnt + 1);
                decoloring(used[cnt], cnt + 3, i);
            }
        }
    }
    public static boolean coloring(int[] currPro, int color, int dir) {
        int[][] move = {{0,-1}, {-1,0}, {0,1}, {1,0}};
        int nextX = currPro[0]; int nextY = currPro[1];
        while (true) {
            nextX += move[dir][0];
            nextY += move[dir][1];
            if (nextX < 0 || nextY < 0 || nextX >= core.length || nextY >= core.length) return true;
            if (core[nextX][nextY] == 0) core[nextX][nextY] = color;
            else {
                decoloring(currPro, color, dir);
                return false;
            }
        }
    }
    public static void decoloring (int[] currPro, int color, int dir){
        int[][] move = {{0,-1}, {-1,0}, {0,1}, {1,0}};
        int nextX = currPro[0]; int nextY = currPro[1];

        while (true) {
            nextX += move[dir][0];
            nextY += move[dir][1];
            if (nextX < 0 || nextY < 0 || nextX >= core.length || nextY >= core.length) return;
            if (core[nextX][nextY] == color) core[nextX][nextY] = 0;
            else return;
        }
    }
    public static int lineFind() {
        int count = 0;
        for (int i = 0 ; i < core.length ; i++) {
            for (int j = 0 ; j < core.length ; j++) {
                if (core[i][j] > 2) count++;
            }
        }
        return count;
    }
}
