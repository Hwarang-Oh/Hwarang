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
        int margin = 0;
        while (!queue.isEmpty()) {
            nowX = queue.poll(); nowY = queue.poll();
            for (int[] eachMove : move) {
                nextX = nowX + eachMove[0];
                nextY = nowY + eachMove[1];
                if (nextX < 0 || nextY < 0 || nextX >= ocean.length || nextY >= ocean.length) continue;
                if (visited[nextX][nextY] || ocean[nextX][nextY] > sizeShark) continue;

                queue.offer(nextX);
                queue.offer(nextY);
                moveCheck[nextX][nextY] = moveCheck[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
                if (ocean[nextX][nextY] > 0 && ocean[nextX][nextY] < sizeShark) { // 만약 사냥에 성공했다면 -> BFS => 최단 보장, Search 순서로
                    if (huntInfo.isEmpty()) {
                        margin = moveCheck[nextX][nextY];
                        huntInfo.offer(new int[] {nextX, nextY});
                    }
                    if (moveCheck[nextX][nextY] == margin) huntInfo.offer(new int[] {nextX, nextY});
                    else {
                        int[] temp = huntInfo.poll();
                        nextX = temp[0]; nextY = temp[1];
                        backTrack(ocean, sizeShark, nextX, nextY);
                        timeCount += moveCheck[nextX][nextY];
                        visited = new boolean[ocean.length][ocean.length];
                        moveCheck = new int[ocean.length][ocean.length];
                        huntInfo.clear();
                        hunt(ocean, sizeShark, eatCount + 1, nextX, nextY);
                    }
                }
            }
        }
    }
    public static void backTrack(int[][] ocean, int sizeShark, int currX, int currY) {
        if (moveCheck[currX][currY] == 0) return;
        int[][] move = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
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
/* -> 이동하면서, DP처럼 이동을 갱신할 수 있을까?
4
4 3 2 1
0 0 0 0
0 0 9 0
1 2 3 4

4 3 2 3
3 2 1 2
2 1 0 1
3 2 1 2

 */




// 0. 먹을 수 있는 물고기X -> 엄마 상어 -> 종료
// 1. 먹을 수 있는 물고기 1개 -> 해당 물고기를 먹으러 간다.
// 2. 먹을 수 있는 물고기 1개 이상 => 가장 가까운 물고기
// 2 - 1. 지나가야 하는 칸의 최솟값
// 2 - 2. 지나가야 하는 칸의 최소값이 같은게 많다면 => 가장 위쪽 & 가장 왼쪽
// 조건 : 이동시간 1초 -> 이동과 동시에 섭취 가능 -> 섭취시 아기 상어 몸집 + 1
// 조건 : 본인보다 큰 물고기가 있는 공간은 접근할 수 없다.
// 출력 : 아기 상어의 이동시간 ( 최소 )

/* -> 이동하면서, DP처럼 이동을 갱신할 수 있을까? 
4
4 3 2 1
0 0 0 0
0 0 9 0
1 2 3 4

4 3 2 3
3 2 1 2
2 1 0 1
3 2 1 2

 */