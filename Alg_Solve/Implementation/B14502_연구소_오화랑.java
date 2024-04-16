import java.io.*;
import java.util.*;

public class B14502_연구소_오화랑 {
    static int[][] Map;
    static ArrayList<int []> blankList = new ArrayList<>();
    static ArrayList<int []> virusList = new ArrayList<>();
    static int maxSafe = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Map = new int[R][C];
        int each;
        for (int i = 0 ; i < R ; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0 ; j < C ; j++) {
                each = Integer.parseInt(st.nextToken());
                Map[i][j] = each;
                if (each == 0) blankList.add(new int[] {i, j});
                if (each == 2) virusList.add(new int[] {i, j});
            }
        }
        int[] selected = new int[blankList.size()];
        for (int i = 0 ; i < 3 ; i++) selected[blankList.size() - 3 + i] = 1;

        do { getSafe(selected, R, C); } while(nextC(selected));
        System.out.println(maxSafe);
    }
    public static boolean nextC(int[] selected) {
        final int size = selected.length;
        int target = size - 1;
        while (target > 0 && selected[target - 1] >= selected[target]) --target;
        if (target == 0) return false;

        int swapLoc = size - 1;
        while(selected[target - 1] >= selected[swapLoc]) --swapLoc;
        swap(selected, target - 1, swapLoc);

        int back = size - 1;
        while (target < back) swap(selected, target++, back--);
        return true;
    }
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void getSafe(int[] selected, int R, int C) {
        for (int i = 0 ; i < selected.length ; i++){
            if (selected[i] == 1) {
                Map[blankList.get(i)[0]][blankList.get(i)[1]] = 3; // 임시벽 3
            }
        }
        for (int [] eachV : virusList) {
            int currX = eachV[0];
            int currY = eachV[1];
            dfs(currX, currY, R, C);
        }
        int safeCount = 0;
        for (int i = 0 ; i < R ; i++) {
            for (int j = 0 ; j < C ; j++) {
                if (Map[i][j] == 0) safeCount++;
                else if (Map[i][j] == 4 || Map[i][j] == 3) Map[i][j] = 0;
            }
        }
        maxSafe = Math.max(maxSafe, safeCount);
    }
    public static void dfs(int currX, int currY, int R, int C) {
        int [][] virusMove = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        for (int[] vMove : virusMove) {
            int nextX = currX + vMove[0];
            int nextY = currY + vMove[1];
            if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
            if (Map[nextX][nextY] != 0) continue;
            Map[nextX][nextY] = 4;
            dfs(nextX, nextY, R, C);
        }
    }
}

// Next Combination의 위력! -> 3개를 맘대로 뽑아낼 수 있다.
// 0인 자리를 뽑고, 바이러스의 위치를 기억하고 DFS로 바이러스 전염을 표현하고, 지워내면서 최대값을 구하면 된다.
// Point는 Visited 관리를 하지 않을 수 있도록, 다른 숫자로 관리하는 것임
// 여기서 전염되는 Virus는 4로 표현을 했는데, 전염시킬 때 다른 원래 바이러스를 만나면 멈춰도 괜찮다. 어짜피 그 바이러스에서 다시 시작을
// 할 것이기 때문이다. => 그런게 없었다면, 2를 만났을때는 4로 바꾸지 않고 진행할 수 있는 Code를 준비했어야 했다.