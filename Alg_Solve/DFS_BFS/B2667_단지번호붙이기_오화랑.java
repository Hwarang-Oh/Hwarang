import java.io.*;
import java.util.*;

public class B2667_단지번호붙이기_오화랑 {
    static int count;
    static ArrayList<Integer> countList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(input.readLine());
        int[][] map = new int [size][size];

        String temp;
        for (int i = 0 ; i < size ; i++) {
            temp = input.readLine();
            for (int j = 0 ; j < size ; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        search(map, size);
        Collections.sort(countList);
        for (int eachCount : countList)
            System.out.println(eachCount);
    }
    public static void search (int[][] map, int size) {
        int complexNum = 2;

        for (int i = 0 ; i < size ; i++) {
            for (int j = 0 ; j < size ; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = complexNum;
                    count++;
                    count(map, i, j, complexNum);
                    countList.add(count);
                    count = 0;
                    complexNum++;
                }
            }
        }
        System.out.println(complexNum - 2);
    }
    public static void count(int[][] map, int sRow, int sCol, int complexNum){
        int[][] searchWay = {
                {1, 0}, {0, 1}, {-1, 0}, {0,-1}
        };

        int tempX; int tempY;
        for (int[] search : searchWay) {
            tempX = sRow + search[0];
            tempY = sCol + search[1];
            if (tempX < 0 || tempY < 0 || tempX >= map.length || tempY >= map.length)
                continue;
            if (map[tempX][tempY] == 1) {
                map[tempX][tempY] = complexNum;
                count++;
                count(map, tempX, tempY, complexNum);
            }
        }
    }
}
