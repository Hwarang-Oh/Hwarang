import java.io.*;
import java.util.*;

public class B9205_맥주마시면걸어가기_오화랑 {
    static class pair {
        int x, y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static pair house, concert;
    static boolean[] visited;
    static String state;
    static ArrayList<pair> conList = new ArrayList<>();
    static Queue <pair> moveList = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int testCase = Integer.parseInt(input.readLine());
        int cNum, eachX, eachY;
        for (int t = 0 ; t < testCase ; t++) {
            cNum = Integer.parseInt(input.readLine());
            visited = new boolean[cNum + 2];
            conList = new ArrayList<>();
            moveList = new ArrayDeque<>();
            for (int i = 0 ; i < cNum + 2 ; i++) {
                st = new StringTokenizer(input.readLine());
                eachX = Integer.parseInt(st.nextToken());
                eachY = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    house = new pair(eachX, eachY);
                    moveList.offer(house);
                    visited[0] = true;
                }
                else if (i == cNum + 1) concert = new pair(eachX, eachY);
                else conList.add(new pair(eachX, eachY));
            }
            canGo(cNum);
        }
        System.out.print(sb);
    }
    public static void canGo(int cNum) {
        while(!moveList.isEmpty()) {
            pair temp = moveList.poll();
            if (Math.abs(concert.x - temp.x) + Math.abs(concert.y - temp.y) <= 1000){
                sb.append("happy").append("\n");
                return;
            }
            for (int i = 0 ; i < cNum ; i++) {
                if (visited[i + 1]) continue;
                if (Math.abs(temp.x - conList.get(i).x) + Math.abs(temp.y - conList.get(i).y) > 1000) continue;
                moveList.offer(conList.get(i));
                visited[i + 1] = true;
            }
        }
        sb.append("sad").append("\n");
    }
}