import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2239_스도쿠_오화랑 {
    static class zeroInfo {
        int x, y, whichS;
        public zeroInfo(int x, int y, int whichS) {
            this.x = x;
            this.y = y;
            this.whichS = whichS;
        }

        @Override
        public String toString() {
            return "zeroInfo{" +
                    "x=" + x +
                    ", y=" + y +
                    ", whichS=" + whichS +
                    '}';
        }
    }
    static int[][] sudoku = new int[9][9];
    static int[][] rowMemo = new int[9][10];
    static int[][] colMemo = new int[9][10];
    static int[][] squareMemo = new int[9][10];
    static ArrayList<zeroInfo> zeroList = new ArrayList<>();
    static Stack<zeroInfo> zeroStack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String eachR;
        int whichS;
        for (int i = 0 ; i < 9 ; i++) {
            eachR = input.readLine();
            for (int j = 0 ; j < 9 ; j++) {
                whichS = -1;
                sudoku[i][j] = Character.getNumericValue(eachR.charAt(j));
                switch (i) {
                    case 0: case 1: case 2: {
                        switch (j) {
                            case 0: case 1: case 2: whichS = 0; break;
                            case 3: case 4: case 5: whichS = 1; break;
                            case 6: case 7: case 8: whichS = 2; break;
                        } break;
                    }
                    case 3: case 4: case 5: {
                        switch (j) {
                            case 0: case 1: case 2: whichS = 3; break;
                            case 3: case 4: case 5: whichS = 4; break;
                            case 6: case 7: case 8: whichS = 5; break;
                        } break;
                    }
                    case 6: case 7: case 8: {
                        switch (j) {
                            case 0: case 1: case 2: whichS = 6; break;
                            case 3: case 4: case 5: whichS = 7; break;
                            case 6: case 7: case 8: whichS = 8; break;
                        } break;
                    }
                }
                if (sudoku[i][j] > 0) {
                    rowMemo[i][sudoku[i][j]] = 1;
                    colMemo[j][sudoku[i][j]] = 1;
                    squareMemo[whichS][sudoku[i][j]] = 1;
                }
                else zeroList.add(new zeroInfo(i, j, whichS));
            }
        }
        for (int i = 0 ; i < zeroList.size() ; i++) makeSudoku(zeroList.get(i), 1, i);

        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                sb.append(sudoku[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    public static void makeSudoku(zeroInfo eachZero, int start, int cnt) {
        boolean canMake = false;
        int row = eachZero.x;
        int col = eachZero.y;
        int whichS = eachZero.whichS;

        for (int i = start ; i <= 9 ; i++) {
            if (rowMemo[row][i] == 0 && colMemo[col][i] == 0 && squareMemo[whichS][i] == 0) {
                rowMemo[row][i] = 1;
                colMemo[col][i] = 1;
                squareMemo[whichS][i] = 1;
                sudoku[row][col] = i;
                canMake = true;
                break;
            }
        }
        if (!canMake) {
            int pastX = zeroList.get(cnt - 1).x;
            int pastY = zeroList.get(cnt - 1).y;
            int pastS = zeroList.get(cnt - 1).whichS;
            int currSelect = sudoku[pastX][pastY];
            rowMemo[pastX][sudoku[pastX][pastY]] = 0;
            colMemo[pastY][sudoku[pastX][pastY]] = 0;
            squareMemo[pastS][sudoku[pastX][pastY]] = 0;
            sudoku[pastX][pastY] = 0;
            makeSudoku(zeroList.get(cnt - 1), currSelect + 1, cnt - 1);
            makeSudoku(zeroList.get(cnt), 1, cnt);
        }
    }
}
/*
143628579
572139468
986754231
391542786
468917352
725863914
237481695
619275843
854396127
 */