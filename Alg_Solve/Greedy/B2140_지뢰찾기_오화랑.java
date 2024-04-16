import java.io.*;
import java.util.Arrays;

public class B2140_지뢰찾기_오화랑 {
    static int[][] Map;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(input.readLine());
        Map = new int[size][size];

        String tempRow;
        char each;
        for (int i = 0; i < size; i++) {
            tempRow = input.readLine();
            for (int j = 0; j < size; j++) {
                each = tempRow.charAt(j);
                if (each == '#') Map[i][j] = -2; // 닫힌 칸 # -> -2
                else Map[i][j] = Character.getNumericValue(each);
            }
        }
        int lineMine = findAbsoluteMine();
        int innerMine = innerMine(size - 4);
        System.out.println(lineMine + innerMine);
    }

    public static int findAbsoluteMine() {
        int totalMineCount = 0;
        int[][] search = {{1, -1}, {1, 0}, {1, 1}, {0, 1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

        int currX = 1; int currY = 1; int nextX, nextY; boolean canMine;

        // Top Line
        for (int i = 1 ; i < size - 1 ; i++) {
            canMine = true;
            for (int[] s : search) {
                nextX = currX + s[0];
                nextY = i + s[1];
                if (Map[nextX][nextY] == 0) { canMine = false; break; }
            }
            if (canMine) {
                for (int[] s : search) {
                    nextX = currX + s[0];
                    nextY = i + s[1];
                    Map[nextX][nextY]--;
                }
                totalMineCount++;
            }
        }

        // Bot Line
        currX = size - 2;
        for (int i = 1 ; i < size - 1 ; i++) {
            canMine = true;
            for (int[] s : search) {
                nextX = currX + s[0];
                nextY = i + s[1];
                if (Map[nextX][nextY] == 0) { canMine = false; break; }
            }
            if (canMine) {
                for (int[] s : search) {
                    nextX = currX + s[0];
                    nextY = i + s[1];
                    Map[nextX][nextY]--;
                }
                totalMineCount++;
            }
        }

        // Left Line
        for (int i = 2 ; i < size - 2 ; i++) {
            canMine = true;
            for (int[] s : search) {
                nextX = i + s[0];
                nextY = currY + s[1];
                if (Map[nextX][nextY] == 0) { canMine = false; break; }
            }
            if (canMine) {
                for (int[] s : search) {
                    nextX = i + s[0];
                    nextY = currY + s[1];
                    Map[nextX][nextY]--;
                }
                totalMineCount++;
            }
        }

        // Right Line
        currY = size - 2;
        for (int i = 2 ; i < size - 2 ; i++) {
            canMine = true;
            for (int[] s : search) {
                nextX = i + s[0];
                nextY = currY + s[1];
                if (Map[nextX][nextY] == 0) { canMine = false; break; }
            }
            if (canMine) {
                for (int[] s : search) {
                    nextX = i + s[0];
                    nextY = currY + s[1];
                    Map[nextX][nextY]--;
                }
                totalMineCount++;
            }
        }
        return totalMineCount;
    }
    public static int innerMine(int innerSize) {
        if (innerSize <= 0) return 0;
        return innerSize * innerSize;
    }
}


// 문제를 읽었을 때, 테두리의 영향을 받지 않는 영역은 모두 Mine으로 채울 수 있다는 것을 알 수 있다.
// 결국, 테두리만 채우면 Mine의 최대 개수를 구할 수 있다.
// 테두리를 채우는 방법은 완전탐색을 가장 먼저 생각할 수 있다. => 경우의 수가 너무 많음 (100 * 100까지 갈 수 있음)
// => 새로운 방법이 없을까? -> 규칙? Greedy?
// 테두리에 있어서, 나올 수 있는 최대 수는 3
// 모서리의 지뢰 유무는 정해져 있음. => 모서리가 정해져 있기에, 정해진 쪽의 옆쪽부터 채워나갈 수 있음.


// 문제 유형은 상어 초등학교 혹은 월드컵과 유사하다고 볼 수 있다.
// 테두리는 전부 개방되어 있기에, 심어 있는 경우의 수는 1가지라고 볼 수 있다.
// 테두리에 있는 값은 3보다 클 수 없다.
// 해당 보드에서는 자의적으로 최대 개수의 지뢰를 설치할 수 있는 곳이 존재한다.
/*
N 8
1 1 1 1 1 1 1 1
1 # # # # # # 1
1 # ! ! ! ! # 1
1 # ! ! ! ! # 1
1 # ! ! ! ! # 1
1 # ! ! ! ! # 1
1 # # # # # # 1
1 1 1 1 1 1 1 1

N 9
1 1 1 1 1 1 1 1 1
1 # # # # # # # 1
1 # ! ! ! ! ! # 1
1 # ! ! ! ! ! # 1
1 # ! ! ! ! ! # 1
1 # ! ! ! ! ! # 1
1 # ! ! ! ! ! # 1
1 # # # # # # # 1
1 1 1 1 1 1 1 1 1

N
10
1 1 1 1 1 1 1 1 1 1
1 # # # # # # # # 1
1 # ! ! ! ! ! ! # 1
1 # ! ! ! ! ! ! # 1
1 # ! ! ! ! ! ! # 1
1 # ! ! ! ! ! ! # 1
1 # ! ! ! ! ! ! # 1
1 # ! ! ! ! ! ! # 1
1 # # # # # # # # 1
1 1 1 1 1 1 1 1 1 1


 */
