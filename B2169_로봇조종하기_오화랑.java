import java.io.*;
import java.util.*;

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
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        visited = new boolean[N][M];
        howVisited = new int[N][M];
        Arrays.fill(howVisited, -200_000);
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < M ; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void getCost(int N, int M) {
        int[][] move = { {0, -1}, {1, 0}, {0, 1} };
        PriorityQueue<state> stateList = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.value, o1.value));
        stateList.offer(new state(0, 0, Map[0][0]));
        visited[0][0] = true;
        howVisited[0][0] = Map[0][0];
    }
}
// 각각의 지역은 탐사가치가 존재 -> 1,1 ~ N, M으로 보내고자 함
// 위의 조건을 만족하면서 탐사한 지역들의 가치의 합이 최대가 되도록 하는 Programm 작성
// 첫째 줄에 N, M 1 ~ 1000이 주어진다. 배열의 각 수는 절대값이 100이 넘지 않는 정수

// 한번 탐사한 곳은 방문하지 않는다
// BFS 탐색의 입장에서 보았을 때, 탐색을 한 공간이어도 내가 더 괜찮은 비용으로 왔다면 한번 더 갈 수 있음.

