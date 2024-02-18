import java.io.*;
import java.util.*;

public class B6593_상범빌딩_오화랑 {
    static char[][] Building;
    static boolean[][] visited;
    static int[][] howManyTime;
    static int[] start, end;
    static int level, row, col; // 빌딩의 정보

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(input.readLine());
            level = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            if (level == 0 && row == 0 && col ==0) break;

            Building = new char[level * row][col]; // eachRow마다 level이 구분됨!
            visited = new boolean[level * row][col];
            howManyTime = new int[level * row][col];

            // Building 정보 읽어오기
            String temp; int startIndex; int endIndex;
            for (int i = 0 ; i < level ; i++) {
                for (int j = 0; j < row; j++) {
                    temp = input.readLine();
                    Building[i*row + j] = temp.toCharArray();
                    startIndex = temp.indexOf('S');
                    endIndex = temp.indexOf('E');
                    if (startIndex != -1) start = new int[]{i * row + j, startIndex};
                    if (endIndex != -1) end = new int[]{i * row + j, endIndex};
                }
                input.readLine();
            }

            // 탐색
            bfs(start[0],start[1]);
            if (howManyTime[end[0]][end[1]] > 0)
                sb.append("Escaped in ").append(howManyTime[end[0]][end[1]]).append(" minute(s).");
            else sb.append("Trapped!");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void bfs(int rowS, int colS) { // startRow, Col, eachRow -> 층이동
        int[][] searchMethod = {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {row, 0}, {-row, 0}
        };

        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(rowS); queue.offer(colS);
        howManyTime[rowS][colS] = 0;
        visited[rowS][colS] = true;

        int currX, currY, nextX, nextY;
        while (!queue.isEmpty()) {
            currX = queue.poll(); currY = queue.poll();
            for (int s = 0 ; s < 6 ; s++) {
                nextX = currX + searchMethod[s][0];
                nextY = currY + searchMethod[s][1];

                if (s == 2 && nextX % row == 0) continue; // row의 남쪽 이동으로 층을 넘나들 수 없다.
                if (s == 3 && currX % row == 0) continue; // row의 북쪽 이동으로 층을 넘나들 수 없다.

                if (nextX < 0 || nextY < 0 || nextX >= level * row || nextY >= col)
                    continue;

                if (Building[nextX][nextY] != '#' && !visited[nextX][nextY]) {
                    queue.offer(nextX); queue.offer(nextY);
                    howManyTime[nextX][nextY] = howManyTime[currX][currY] + 1;
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}

// 상범 빌딩의 층 수 L -> level
// 상범 빌딩의 한 층의 행 R
// 상범 빌딩의 한 층의 열 L
// 각 정육면체는 금으로 이루어져 못지나감 or 비어있어서 이동 가능
// 각 칸에서 6개의 칸 -> 동서남북상하 -> 1분의 시간을 들여 이동 가능
// 탈출? -> 한다면 몇분?
