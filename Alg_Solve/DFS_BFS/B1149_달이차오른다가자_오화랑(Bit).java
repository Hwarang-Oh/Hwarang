import java.io.*;
import java.util.*;


public class B1149_달이차오른다가자_오화랑 {
    static class State {
        int x, y, spend, key;
        public State(int x, int y, int spend, int key) {
            this.x = x;
            this.y = y;
            this.spend = spend;
            this.key = key;
        }
    }
    static int[][] Map;
    static boolean[][] visited;
    static int[][] keyVisited;
    static int N, M;
    static int minTime = Integer.MAX_VALUE;
    static boolean canGo;
    static Queue<State> queue = new ArrayDeque<>();
    static int[][] move = { {1, 0}, {0, -1}, {-1, 0}, {0, 1} };
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        visited = new boolean[N][M];
        keyVisited = new int[N][M];
        String eachR;
        int startX, startY;
        startX = startY = 0;
        for (int i = 0; i < N; i++) {
            eachR = input.readLine();
            for (int j = 0; j < M; j++) {
                switch (eachR.charAt(j)) {
                    // 입구(1개) & 출구(1개 이상)
                    case '0' : { Map[i][j] = 100; startX = i; startY = j; break; }
                    case '1' : Map[i][j] = 200; break;
                    case '.' : Map[i][j] = -100; break; case '#' : Map[i][j] = -200; break;
                    case 'a' : Map[i][j] = 1; break; case 'b' : Map[i][j] = 2; break;
                    case 'c' : Map[i][j] = 3; break; case 'd' : Map[i][j] = 4; break;
                    case 'e' : Map[i][j] = 5; break; case 'f' : Map[i][j] = 6; break;
                    case 'A' : Map[i][j] = -1; break; case 'B' : Map[i][j] = -2; break;
                    case 'C' : Map[i][j] = -3; break; case 'D' : Map[i][j] = -4; break;
                    case 'E' : Map[i][j] = -5; break; case 'F' : Map[i][j] = -6; break;
                }
            }
        }
        queue.offer(new State(startX, startY, 0,0));
        visited[startX][startY] = true;
        keyVisited[startX][startY] = 0;

        State tempState;
        int currX, currY, currT, currKey;
        int nextX, nextY;
        while (!queue.isEmpty()) {
            tempState = queue.poll();
            currX = tempState.x;
            currY = tempState.y;
            currT = tempState.spend;

            if (Map[currX][currY] == 200) {
                minTime = currT;
                canGo = true;
                break;
            }

            for (int[] eachM : move) {
                currKey = tempState.key;
                nextX = currX + eachM[0];
                nextY = currY + eachM[1];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (Map[nextX][nextY] == -200) continue;
                if (visited[nextX][nextY] && (~keyVisited[nextX][nextY] & currKey) == 0) continue;

                if (Map[nextX][nextY] < 0) { // 일반 구역 혹은 Door 구역 Case
                    if (Map[nextX][nextY] == -100) { // 일반 구역은 제한 없이 도달 O
                        queue.offer(new State(nextX, nextY,currT + 1, currKey));
                        visited[nextX][nextY] = true;
                        keyVisited[nextX][nextY] = currKey;
                    }
                    else {
                        if ((currKey & (1 << (-Map[nextX][nextY] - 1))) != 0) {
                            queue.offer(new State(nextX, nextY, currT + 1, currKey));
                            visited[nextX][nextY] = true;
                            keyVisited[nextX][nextY] = currKey;
                        }
                    }
                }
                else {
                    if (Map[nextX][nextY] < 100) {
                        if ((currKey & (1 << (Map[nextX][nextY] - 1))) == 0) {
                            currKey |= 1 << (Map[nextX][nextY] - 1);
                        }
                    }
                    queue.offer(new State(nextX, nextY, currT + 1, currKey));
                    visited[nextX][nextY] = true;
                    keyVisited[nextX][nextY] = currKey;
                }
            }
        }
        if (canGo) System.out.println(minTime);
        else System.out.println(-1);
    }
}


// 0 -> 100, 1 -> 200
// . -> -100, # -> -200
// Key 상태 = "000000"
// 1 2 3 4 5 6
// -1 -2 -3 -4 -5 -6



// 미로는 직사각형 -> 여행길을 떠나기 위해 미로를 탈출하고자 함
// 미로 구성
// 빈칸 (.) => 언제나 이동
// 벽 (#) => 절대 이동 불가
// 열쇠 (a,b,c,d,e,f) => 이곳에 처음 들어가면 열쇠를 집는다.
// 문 (A, B, C, D, E, F) => 해당하는 열쇠가 있을 때 만 이동할 수 있다.
// 현재 위치 : 민식이가 서있는 곳 ('0')
// 출구 : 달이 차오르기 때문에, 민식이가 가야하는 곳 => 이곳에 오면 미로 탈출 ( 1 )
// 한번의 움직임 : 현재 위치에서 수평이나 수직으로 한 칸 이동하는 것
// 첫재 줄에 미로의 세로 크기 / 가로 크기 N M 이 주어짐 (50 이하)
// 문에 대응하는 열쇠가 없을 수도 있다. '0'과 '1'은 1개
// => 민식이가 미로 탈출 ( 최소값 ) , 민식이가 미로 탈출불가 ( -1 )
