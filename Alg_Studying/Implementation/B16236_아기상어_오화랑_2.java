import java.io.*;
import java.util.*;

public class B16236_아기상어_오화랑 {
    static int timeCount;
    static boolean[][] visited;
    static int[][] moveCheck;

    static PriorityQueue<int[]> huntInfo = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            int diff = Integer.compare(o1[0],o2[0]);
            return diff != 0 ? diff : Integer.compare(o1[1],o2[1]);
        }});

    public static void main(String[] args) throws IOException{
         BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
         int size = Integer.parseInt(input.readLine());
         int[][] ocean = new int[size][size];
         visited = new boolean[size][size];
         moveCheck = new int[size][size];

         int rowS = 0, colS = 0;
         for (int i = 0 ; i < size ; i++) {
             st = new StringTokenizer(input.readLine());
             for (int j = 0 ; j < size ; j++) {
                 ocean[i][j] = Integer.parseInt(st.nextToken());
                 if (ocean[i][j] == 9) { rowS = i; colS = j;}
             }
         }
         
         hunt(ocean, 2, 0, rowS, colS);
         System.out.println(timeCount);
    }

    public static void hunt(int[][] ocean, int sizeShark, int eatCount, int rowS, int colS) {
        int[][] move = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(rowS); queue.offer(colS);
        ocean[rowS][colS] = 0;
        visited[rowS][colS] = true;
        if (eatCount == sizeShark) { eatCount = 0; sizeShark++; }

        int nowX, nowY, nextX, nextY;
        
        while (!queue.isEmpty()) {
            nowX = queue.poll(); nowY = queue.poll();
            for (int[] eachMove : move) {
                nextX = nowX + eachMove[0]; nextY = nowY + eachMove[1];
                if (nextX < 0 || nextY < 0 || nextX >= ocean.length || nextY >= ocean.length) continue;
                if (visited[nextX][nextY] || ocean[nextX][nextY] > sizeShark) continue;
                queue.offer(nextX); queue.offer(nextY);
                moveCheck[nextX][nextY] = moveCheck[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
                
                if (ocean[nextX][nextY] > 0 && ocean[nextX][nextY] < sizeShark) { // 만약 사냥에 성공했다면 -> BFS => 최단 보장, Search 순서로
                	System.out.printf("%d %d %d%n", nextX, nextY, ocean[nextX][nextY]);
            		backTrack(ocean, sizeShark, nextX, nextY);
                    timeCount += moveCheck[nextX][nextY];
                    visited = new boolean[ocean.length][ocean.length];
                    moveCheck = new int[ocean.length][ocean.length];
                    hunt(ocean, sizeShark, eatCount + 1, nextX, nextY);
                }
            }
        }
    }
    
    public static void backTrack(int[][] ocean, int sizeShark, int currX, int currY) {
        if (moveCheck[currX][currY] == 0) return;
        int[][] move = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
        if (ocean[currX][currY] < sizeShark) ocean[currX][currY] = 0;

        int pastX, pastY;
        for (int[] eachMove : move) {
            pastX = currX + eachMove[0];
            pastY = currY + eachMove[1];
            if (pastX < 0 || pastY < 0 || pastX >= ocean.length || pastY >= ocean.length) continue;
            if (moveCheck[currX][currY] - 1 == moveCheck[pastX][pastY]) backTrack(ocean, sizeShark, pastX, pastY);
        }
    }
}