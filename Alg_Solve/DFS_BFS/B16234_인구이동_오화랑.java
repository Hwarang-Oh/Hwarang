import java.io.*;
import java.util.*;

public class B16234_인구이동_오화랑 {
    static boolean isVisited[][];
    static int land[][];
    static boolean isMove;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int size = Integer.parseInt(st.nextToken());
        int diffL = Integer.parseInt(st.nextToken());
        int diffH = Integer.parseInt(st.nextToken());
        int dayCount = 0;
        land = new int[size][size];

        for (int i = 0 ; i < size ; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0 ; j < size ; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        do {
            isVisited = new boolean[size][size];
            isMove = false;
            for (int i = 0 ; i < size ; i++) {
                for (int j = 0 ; j < size ; j++) {
                    if (isVisited[i][j]) continue;
                    move(i,j,diffL,diffH);
                }
            }
            if (isMove) dayCount++;
        } while (isMove);
        System.out.println(dayCount);
    }
    public static void move(int rowS, int colS, int diffL, int diffH) {
        int [][] search = { {1, 0}, {0, -1}, {-1, 0}, {0, 1} };
        Queue<Integer> adjList = new ArrayDeque<>();
        int adj_peopleCount, adj_landCount;
        adj_peopleCount = adj_landCount = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        isVisited[rowS][colS] = true;
        queue.offer(rowS); queue.offer(colS);

        int currX, currY, nextX, nextY, currDiff;
        while(!queue.isEmpty()) {
            currX = queue.poll(); currY = queue.poll();
            adj_peopleCount += land[currX][currY];
            adj_landCount++;
            adjList.offer(currX) ; adjList.offer(currY);

            for (int[] s : search) {
                nextX = currX + s[0];
                nextY = currY + s[1];
                if (nextX < 0 || nextY < 0 || nextX >= land.length || nextY >= land.length) continue;
                if (isVisited[nextX][nextY]) continue;
                currDiff = Math.abs(land[currX][currY] - land[nextX][nextY]);
                if (currDiff >= diffL && currDiff <= diffH) {
                    isVisited[nextX][nextY] = true;
                    queue.offer(nextX); queue.offer(nextY);
                    adjList.offer(nextX); adjList.offer(nextY);
                }
            }
        }
        if (adj_landCount > 1) {
            isMove = true;
            int newCount = adj_peopleCount / adj_landCount;
            int newX, newY;
            while (!adjList.isEmpty()) {
                newX = adjList.poll(); newY = adjList.poll();
                land[newX][newY] = newCount;
            }
        }
    }
}
