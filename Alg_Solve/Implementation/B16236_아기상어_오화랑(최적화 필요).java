import java.io.*;
import java.util.*;

public class Main {
    static class pair{
        int x, y, move;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.move = 0;
        }
        public pair(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
        @Override
        public String toString() {
            return "pair{" +
                    "x=" + x +
                    ", y=" + y +
                    ", move=" + move +
                    '}';
        }
    }
    static PriorityQueue<pair> pq = new PriorityQueue<>(new Comparator<pair>() {
        @Override
        public int compare(pair o1, pair o2) {
            int diff = Integer.compare(o1.move, o2.move);
            int diff2 = Integer.compare(o1.x, o2.x);
            return diff != 0 ? diff : diff2 != 0 ? diff2 : Integer.compare(o1.y, o2.y);
        }
    });
    static int totalTime;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(input.readLine());
        int[][] ocean = new int[N][N];

        pair start = new pair(0,0);
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0 ; j < N; j++) {
                ocean[i][j] = Integer.parseInt(st.nextToken());
                if (ocean[i][j] == 9) {start = new pair(i,j);}
            }
        }
        hunt(ocean, 2, 0, start);
        System.out.println(totalTime);
    }
    public static void hunt(int[][] ocean, int sSize, int eatCount, pair start) {
        int[][] search = { {-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] visited = new boolean[ocean.length][ocean.length];
        Queue<pair> queue = new ArrayDeque<>();

        queue.offer(start);
        ocean[start.x][start.y] = 0;
        visited[start.x][start.y] = true;
        int nextX, nextY, nextMove;
        while (!queue.isEmpty()) {
            pair current = queue.poll();
            for (int[] s : search) {
                nextX = current.x + s[0]; nextY = current.y + s[1];
                if (nextX < 0 || nextY < 0 || nextX >= ocean.length || nextY >= ocean.length) continue;
                if (ocean[nextX][nextY] <= sSize && !visited[nextX][nextY]) {
                    nextMove = current.move + 1;
                    queue.offer(new pair(nextX,nextY, nextMove));
                    visited[nextX][nextY] = true;
                    if (ocean[nextX][nextY] > 0 && ocean[nextX][nextY] < sSize)
                        pq.offer(new pair(nextX, nextY, nextMove));
                }
            }
        }
        eat(ocean, sSize, eatCount);
    }

    public static void eat(int ocean[][], int sSize, int eatCount) {
        if (pq.isEmpty()) return;
        pair target = pq.poll();
        totalTime += target.move; // 시간 더하기
        if (++eatCount == sSize) { sSize++; eatCount = 0; }
        pq.clear(); target.move = 0;
        hunt(ocean, sSize, eatCount, target);
    }
}
// Debug
//        for (int i = 0 ; i < N ; i++)
//        System.out.println(Arrays.toString(ocean[i]));
//        System.out.printf("%d %d", sRow, sCol);



// N * N 크기의 공간, 물고기 M마리, 아기 상어 1마리, 1칸에는 최대 1마리가 존재함.
// 초기, 아기상어의 크기는 2 => 아기 상어는 1초에 상하좌우로 인접한 1칸 씩 이동한다.
// 아기상어 : 본인 보다 큰 물고기가 있는 칸은 이동X, 나머지 칸은 모두 지나갈 수 있다.
// 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.
// Point : 본인이랑 크기가 같은 물고기가 있는 칸은 지나가도, 먹는건 불가!!
// 아기상어는 본인의 크기와 같은 개수의 물고기를 먹을 때 마다 크기가 1 증가

// 1. 먹을 수 있는 물고기가 공간에 없다면, 아기 상어는 엄마 상어에게 도움을 요청
// 2. 먹을 수 있는 물고기가 1마리라면, 해당 물고기를 먹으러 간다.
// 3. 먹을 수 있는 물고기가 1마리보다 많다면, 가장 가까운 물고기를 먹으러 간다.
    // 3 - 1. 거리 : 지나가야 하는 칸의 최솟값.
    // 3 - 2. 거리가 같다면, 가장 위쪽 -> 가장 왼쪽
// 아기상어의 이동은 1초, 먹는 시간 X
// 아기 상어가 엄마 상어를 부르기 전 까지의 시간을 구하여라


