import java.io.*;
import java.util.*;

public class B16235_나무재테크_오화랑 {
    static class land {
        int food;
        int plusFood;
        int currX, currY;
        PriorityQueue<Integer> haveTree;
        public land(int currX, int currY, int plusFood) {
            this.currX = currX;
            this.currY = currY;
            this.plusFood = plusFood;
            this.food = 5;
            this.haveTree = new PriorityQueue<>();
        }
    }
    static land[][] Map;
    static ArrayList<land> isTree = new ArrayList<>();
    static int N;
    static int treeCount;
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Map = new land[N + 1][N + 1];
        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 1 ; j <= N ; j++) {
                Map[i][j] = new land(i, j, Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(input.readLine());
            int tX = Integer.parseInt(st.nextToken());
            int tY = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            Map[tX][tY].haveTree.add(age);
            isTree.add(Map[tX][tY]);
        }
        for (int i = 0 ; i < K ; i++) {
            spring_summer();
            fall();
            winter();
        }
        countTree();
        System.out.println(treeCount);
    }
    public static void spring_summer() {
        for (land eachLand : isTree) {
            int haveFood = eachLand.food;
            PriorityQueue<Integer> nextTree = new PriorityQueue<>();
            int deathFood = 0;
            while (!eachLand.haveTree.isEmpty()) {
                int tempTree = eachLand.haveTree.poll();
                if (haveFood >= tempTree) {
                    haveFood -= tempTree;
                    tempTree++;
                    nextTree.offer(tempTree);
                }
                else {
                    deathFood += tempTree / 2;
                }
            }
            eachLand.food = haveFood + deathFood;
            eachLand.haveTree = nextTree;
        }
    }
    public static void fall() {
        int[][] moveM = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        int currIsTree = isTree.size();

        for (int i = 0 ; i < currIsTree ; i++) {
            land eachland = isTree.get(i);
            PriorityQueue<Integer> nextTree = new PriorityQueue<>();
            while(!eachland.haveTree.isEmpty()) {
                int x = eachland.currX;
                int y = eachland.currY;
                int tempTree = eachland.haveTree.poll();
                int nextX, nextY;
                if (tempTree % 5 ==0) {
                    for (int d = 0 ; d < 8 ; d++) {
                        nextX = x + moveM[d][0];
                        nextY = y + moveM[d][1];
                        if (nextX < 1 || nextY < 1 || nextX > N || nextY > N) continue;
                        Map[nextX][nextY].haveTree.add(1);
                    }
                }
                nextTree.offer(tempTree);
            }
            eachland.haveTree = nextTree;
        }
    }
    public static void winter() {
        isTree = new ArrayList<>();
        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                Map[i][j].food += Map[i][j].plusFood;
                if (!Map[i][j].haveTree.isEmpty()) isTree.add(Map[i][j]);
            }
        }
    }
    public static void countTree() {
        for (int i = 0 ; i < isTree.size() ; i++) {
            treeCount += isTree.get(i).haveTree.size();
        }
    }
}

// r * c => 1 * 1 부터 시작
// 가장 처음에 양분은 모든 칸에 5가 들어 있다.
// Spring : 나무가 자신의 나이만큼 양분을 먹고 나이가 1 증가
// 하나의 칸에 여러 개의 나무 -> 어린 순으로 양분을 먹음
// 땅의 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없으면 -> 즉사

// Summer : 봄에 죽은 나무가 양분으로 변하게 된다.
// 각각의 죽은 나무마다 나이를 2로 나눈 값 => 소수점 버림

// Fall : 가을에는 나무가 번식
// 번식하는 나무는 나이가 5의 배수 -> 인접한 8개의 칸에 나이가 1인 나무 생성
// 땅을 벗어나면, continue;

// Winter : 땅을 돌아다니면서, 양분을 추가 => A[r][C]만큼 증가 input!!

// N : size
// M : 심은 나무의 개수
// K : K년이 지난후 살아남은 나무의 수 ( loop 개수 )
// 입력으로 주어지는 나무의 위치는 모두 다름
// 나무의 수는 최대 100개
// loop 1000개
// 시간 제한 0.3초 => 한방에 끝나야 한다