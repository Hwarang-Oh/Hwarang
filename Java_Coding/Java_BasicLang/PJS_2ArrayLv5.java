import java.io.*;

public class PJS_2ArrayLv5 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(input.readLine());
        int[][] mine = new int[size][size];

        String line, eachMove;
        int[][] dynamite = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
        int moveCount;
        int currX = 0;
        int currY = 0;
        int rockCount = 0;

        for (int i = 0; i < size; i++) {
            line = input.readLine();
            for (int j = 0; j < size; j++) {
                if (line.charAt(j) == '0') {
                    currX = i;
                    currY = j;
                }
                mine[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        moveCount = Integer.parseInt(input.readLine());
        for (int i = 0; i < moveCount; i++) {
            eachMove = input.readLine();
            if (eachMove.equals("U")) {
                switch (mine[currX - 1][currY]) {
                    case 3:
                    case 2:
                        mine[currX - 1][currY]--;
                    case 1: {
                        mine[currX - 1][currY]--;
                        rockCount++;
                        currX--;
                    }
                    case 0:
                        currX--;
                }
            } else if (eachMove.equals("D")) {
                switch (mine[currX + 1][currY]) {
                    case 3:
                    case 2:
                        mine[currX + 1][currY]--;
                        break;
                    case 1: {
                        mine[currX + 1][currY]--;
                        rockCount++;
                        currX++;
                        break;
                    }
                    case 0:
                        currX++;
                }
            } else if (eachMove.equals("L")) {
                switch (mine[currX][currY - 1]) {
                    case 3:
                    case 2:
                        mine[currX][currY - 1]--;
                        break;
                    case 1: {
                        mine[currX][currY - 1]--;
                        rockCount++;
                        currY--;
                        break;
                    }
                    case 0:
                        currY--;
                }
            } else if (eachMove.equals("R")) {
                switch (mine[currX][currY + 1]) {
                    case 3:
                    case 2:
                        mine[currX][currY + 1]--;
                        break;
                    case 1: {
                        mine[currX][currY + 1]--;
                        rockCount++;
                        currY++;
                        break;
                    }
                    case 0:
                        currY++;
                }
            } else if (eachMove.equals("X")) {
                int tempx = currX;
                int tempy = currY;
                for (int[] boom : dynamite) {
                    tempx += boom[0];
                    tempy += boom[1];
                    if (tempx > mine.length - 1 | tempy > mine.length - 1 | tempx < 0 | tempy < 0) {
                        tempx = currX;
                        tempy = currY;
                        continue;
                    }
                    if (mine[tempx][tempy] > 0) {
                        mine[tempx][tempy] = 0;
                        rockCount++;
                    }
                    tempx = currX;
                    tempy = currY;
                }
            }
        }
        System.out.printf("광부 위치 : (%d,%d)%n", currX, currY);
        System.out.printf("부순 암석 개수 : %d", rockCount);
    }
}