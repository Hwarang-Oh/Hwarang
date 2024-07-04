import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2448
public class B2448_별찍기11_오화랑 {
    static class Solution {
        StringBuilder sb = new StringBuilder();
        int N; // Input Size : 3 * 2^k Value
        // Recursive하게 starTree를 그려냄 -> 한 번에 StringBuilder에 넣을 수 없기에 Array에 저장
        char[][] starTree;

        void run() {
            try (Scanner sc = new Scanner(System.in)) {
                // try with resources 구문을 통해, Scanner를 사용하고 close를 해준다.
                this.N = sc.nextInt();
            }
            // 실제로 필요한 부분은 Row : N, Col : 2 * N => Zero Base로 처리하기 불편해서 + 1해서 사용
            this.starTree = new char[this.N + 1][2 * this.N + 1];
            drawStarTree(N, N);
            for (int i = this.N; i >= 1; i--) {
                for (int j = 1; j <= 2 * this.N; j++) {
                    if (this.starTree[i][j] == '*')
                        sb.append(this.starTree[i][j]);
                    else
                        sb.append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }

        void drawStarTree(int N, int drawPoint) {
            // 각 Point마다 3가지 과정을 거친다.
            // 1. left StarTree를 완성한다.
            // 2. left StarTree를 Center StarTree에 복사한다.
            // 3. right StarTree를 완성한다.
            if (N == 3) {
                this.starTree[N][drawPoint] = '*';
                this.starTree[N - 1][drawPoint - 1] = '*';
                this.starTree[N - 1][drawPoint + 1] = '*';
                for (int i = drawPoint - 2; i <= drawPoint + 2; i++)
                    this.starTree[N - 2][i] = '*';
                return;
            }
            int leftPoint = drawPoint - N / 2;
            int rightPoint = drawPoint + N / 2;
            drawStarTree(N / 2, leftPoint);
            drawCenter(N, leftPoint, drawPoint);
            drawStarTree(N / 2, rightPoint);
        }

        void drawCenter(int N, int leftPoint, int drawPoint) {
            int startRow = N / 2;
            for (int i = 1; i <= N / 2; i++) {
                for (int j = 1; j <= N; j++) {
                    this.starTree[startRow + i][leftPoint + j] = this.starTree[i][leftPoint - N / 2 + j];
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution Solution = new Solution();
        Solution.run();
    }
}