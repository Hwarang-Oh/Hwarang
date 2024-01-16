import java.util.Scanner;

public class Solution {
    public static int maxBuildingCheck(int[][] area, int dim) {
        int nearGreenCount;
        int currentBuilding;
        int MAXVALUE = 2 * dim - 1;
        int currentGreen = 0;
        int maxBuilding = 0;

        for (int row = 1; row < dim + 1; row++) {
            for (int col = 1; col < dim + 1; col++) {
                nearGreenCount = 0;
                currentBuilding = 0;
                if (area[row][col] == 0) {
                    nearGreenCount += (area[row - 1][col - 1] + area[row - 1][col]
                            + area[row - 1][col + 1] + area[row][col - 1]
                            + area[row][col + 1] + area[row + 1][col - 1]
                            + area[row + 1][col] + area[row + 1][col + 1]);
                    if (nearGreenCount > 0)
                        currentBuilding = 2;
                    else {
                        for (int index = 1; index < dim + 1; index++)
                            currentGreen += (area[row][index] + area[index][col]);
                        currentBuilding = MAXVALUE - currentGreen;
                    }}
                if (currentBuilding > maxBuilding)
                    maxBuilding = currentBuilding;
            }}
        return maxBuilding;}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testcase = input.nextInt();
        int dim, tempCol, result;
        int[][] area;

        for(int cases = 1 ; cases < testcase + 1 ; cases++){
            dim = input.nextInt();
            input.nextLine();
            area = new int [dim + 2][dim + 2];
            for (int row = 1 ; row < dim + 1 ; row++) {
                tempCol = 1;
                String temp = input.nextLine();
                for (int index = 0 ; index < temp.length() ; index++) {
                    char x = temp.charAt(index);
                    if (x == 'B') {
                        area[row][tempCol] = 0;
                        tempCol++;
                    }
                    else if (x == 'G') {
                        area[row][tempCol] = 1;
                        tempCol++;
                    }}}
            result = maxBuildingCheck(area, dim);
            System.out.println(dim);
        }
    }
}
