import java.io.*;
import java.util.*;

public class B2169_로봇조종하기_오화랑 {
    static int[][] Map;
    static int[][] toRightMap;
    static int[][] fromRightMap;
    static int[][] finalMap;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map = new int[N + 1][M + 1]; // for calculating Memo -> 0 Row : All Zero Value
        toRightMap = new int[N + 1][M + 1];
        fromRightMap = new int[N + 1][M + 1];
        finalMap = new int[N + 1][M + 1];

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(input.readLine());
            if (i == 1) {
                for (int j = 1 ; j <= M ; j++)  {
                    Map[i][j] = Integer.parseInt(st.nextToken());
                    toRightMap[i][j] = toRightMap[i][j - 1] + Map[i][j];
                }
                for (int j = M ; j >= 1 ; j--)  fromRightMap[i][j] = toRightMap[i][j];
            }
            else {
                toRightMap[i][0] = -100_000_000;
                for (int j = 1 ; j <= M; j++) {
                    // Raw District Value
                    Map[i][j] = Integer.parseInt(st.nextToken());
                    // Memo MaxValue : toRight Cumulative Sum
                    toRightMap[i][j] = Math.max(toRightMap[i][j - 1] + Map[i][j], finalMap[i - 1][j] + Map[i][j]);
                }
                fromRightMap[i][M] = finalMap[i - 1][M] + Map[i][M];
                for (int j = M - 1 ; j >= 1; j--) {
                    // Memo MaxValue : fromRight Cumulative Sum
                    fromRightMap[i][j] = Math.max(fromRightMap[i][j + 1] + Map[i][j], finalMap[i - 1][j] + Map[i][j]);
                }
            }
            for (int j = 1; j <= M; j++) {
                finalMap[i][j] = Math.max(toRightMap[i][j], fromRightMap[i][j]);
                toRightMap[i][j] = finalMap[i][j];
                fromRightMap[i][j] = finalMap[i][j];
            }
        }
        System.out.println(finalMap[N][M]);
    }
}

// new Idea : 한쪽 방향으로 탐색을 진행하면, 돌아가는 방법은 존재하지 않는다.
// 아래쪽으로 내려가면 위쪽으로 올라오는 방법은 존재하지 않는다.
// 즉 한 줄에서 최대한 많이 먹고 내려가야 한다.
// 그렇다고, 해당 문제를 Greedy로 접근하는 것은 불가능하다
// n번째 줄에서 최대를 먹고 내려온 지점에서, 진행하는 n + 1번째 줄의 선택이 최선이 아닐 수 있기 때문이다.
// Greedy BackTracking은 말도 안되고, 순수 BackTracking? 혹은 DP로 접근 시도












// 각각의 지역은 탐사가치가 존재 -> 1,1 ~ N, M으로 보내고자 함
// 위의 조건을 만족하면서 탐사한 지역들의 가치의 합이 최대가 되도록 하는 Programm 작성
// 첫째 줄에 N, M 1 ~ 1000이 주어진다. 배열의 각 수는 절대값이 100이 넘지 않는 정수

// 한번 탐사한 곳은 방문하지 않는다
// BFS 탐색의 입장에서 보았을 때, 탐색을 한 공간이어도 내가 더 괜찮은 비용으로 왔다면 한번 더 갈 수 있음.
// BFS 탐색으로 푸는 방법을 따로 알아보는 시간을 반드시 가져야 한다!!

/*

public class B2169_로봇조종하기_오화랑 {
    static class state {
        int x, y, value;
        public state(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    static int[][] Map;
    static boolean[][] visited;
    static int[][] howVisited;
    static int maxValue;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        visited = new boolean[N][M];
        howVisited = new int[N][M];
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < M ; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
                howVisited[i][j] = -200_000;
            }
        }
        getCost(N, M);
        System.out.println(maxValue);
    }
    public static void getCost(int N, int M) {
        int[][] move = { {0, -1}, {1, 0}, {0, 1} };
        PriorityQueue<state> stateList = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.value, o1.value));
        stateList.offer(new state(0, 0, Map[0][0]));
        visited[0][0] = true;
        howVisited[0][0] = Map[0][0];

        state tempState;
        int currX, currY, nextX, nextY, nextValue;
        while (!stateList.isEmpty()) {
            tempState = stateList.poll();
            currX = tempState.x;
            currY = tempState.y;
            System.out.printf("pair : %d %d, value : %d%n", currX, currY, tempState.value);
            if (currX == N - 1 && currY == M - 1) {
                maxValue = tempState.value;
                break;
            }
            for (int[] eachM : move) {
                nextX = currX + eachM[0];
                nextY = currY + eachM[1];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                nextValue = tempState.value + Map[nextX][nextY];
                if (visited[nextX][nextY] &&
                        howVisited[nextX][nextY] >= nextValue) continue;
                stateList.offer(new state(nextX, nextY, nextValue));
                visited[nextX][nextY] = true;
                howVisited[nextX][nextY] = nextValue;
            }
        }
    }
}
 */