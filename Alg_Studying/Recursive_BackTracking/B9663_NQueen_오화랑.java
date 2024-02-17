import java.io.*;
import java.util.*;

public class B9663_NQueen_오화랑 {
    static int chessCount;
    static int[][] coloring = {
            {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}
    };
    static int tempX, tempY;
    static boolean canPick;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] chessBoard = new int[size][size];
        Nqueen(0,size, chessBoard);
        System.out.println(chessCount);

    }
    public static void Nqueen(int cnt, int size, int[][] chessBoard) {
        if (cnt == size){ chessCount++; return; }
        // cnt는 0부터 시작하기에, size에 도달한 것은 모든 Queen을 배치한 것
        // 해당 경우가 끝났으므로, chessCount++하고 다른 경우의 수 탐색

        canPick = false;
        for (int i = 0 ; i < size ; i++) {
            if (chessBoard[cnt][i] == 0)
                canPick = true;
        }
        if (!canPick) return; // cnt번째의 Queen이 들어갈 칸이 존재하지 않으면 return

        for (int i = 0 ; i < size ; i++) {
            if (chessBoard[cnt][i] != 0) continue;
            chessBoard[cnt][i] = cnt + 1;
            coloring(cnt, i, size, chessBoard);
            Nqueen(cnt + 1, size, chessBoard); // cnt번째의 Queen이 들어가서 cnt + 1번째 Queen 호출
            decoloring(cnt, i, size, chessBoard);
            chessBoard[cnt][i] = 0;
        }
    }
    // coloring : cnt번째 Queen의 영향 범위를 coloring한 것 -> cnt번으로 chessBoard 색칠
    // 해당 경우의 수로 탐색이 끝나거나, 진행이 불가하면 decoloring으로 0으로 바꿔줌
    public static void coloring(int cnt, int loc, int size, int[][] chessBoard) {
        for (int[] color : coloring) {
            tempX = cnt; tempY = loc;
            while (true) {
                tempX += color[0];
                tempY += color[1];
                if (tempX < 0 || tempY < 0 || tempX >= size || tempY >= size) break;
                if (chessBoard[tempX][tempY] != 0) continue;
                chessBoard[tempX][tempY] = cnt + 1;
            }
        }
    }
    // 조금 더 최적화한다면, decoloring과 coloring 함수는 통합시킬 수 있을 것 같음
    public static void decoloring(int cnt, int loc, int size, int[][] chessBoard) {
        for (int[] decolor : coloring) {
            tempX = cnt; tempY = loc;
            while (true) {
                tempX += decolor[0];
                tempY += decolor[1];
                if (tempX < 0 || tempY < 0 || tempX >= size || tempY >= size) break;
                if (chessBoard[tempX][tempY] == cnt + 1) chessBoard[tempX][tempY] = 0;
            }
        }
    }
}
// 순수하게 2차원 배열을 이용한 것은 조금 비효율적인 코드 => 1차원 배열을 이용한 풀이가 존재할 수 있음
// 1개의 Queen이 깔렸을 때 => 해당 row, col , 대각선은 모두 봉쇄 => 색을 칠할까?
// 10초의 제한 시간? => 조금은 시간 계산에 여유가 있는 재귀 문제
// 최소 15번의 함수호출
