import java.io.*;
import java.util.Arrays;

public class B2140_지뢰찾기_오화랑 {
    static int[][] Map;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(input.readLine());
        Map = new int[size][size]; // 원래는 char[][]로 받는데, 뭔가 느낌이 안좋아서 int[][]로 시작

        String tempRow; char each;
        for (int i = 0 ; i < size ; i++) {
            tempRow = input.readLine();
            for (int j = 0 ; j < size ; j++) {
                each = tempRow.charAt(j);
                if (each == '#') Map[i][j] = -1; // 닫힌 칸 # -> -1
                else Map[i][j] = Character.getNumericValue(each); // 숫자형 char을 숫자로 변환해서 저장
            }
        }
    }
    public static void findAbsoluteMine() {
        for (int i = 1 ; i <= size - 2; i++) {}

        for (int i = 1 ; i <= size - 2; i++) {}

        for (int i = 1 ; i <= size - 2; i++) {}

    }
}

// 문제 유형은 상어 초등학교 혹은 월드컵과 유사하다고 볼 수 있다.
// 테두리는 전부 개방되어 있기에, 심어 있는 경우의 수는 1가지라고 볼 수 있다.
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

N 10
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
