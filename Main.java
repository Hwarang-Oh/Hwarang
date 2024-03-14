import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String name = input.readLine();
        boolean[] notAarr = new boolean[name.length()];
        int[] distArr = new int[name.length()];

        int totalCost = 0;
        int notA = 0;
        for (int i = 0 ; i < name.length() ; i++) {
            totalCost += Math.min(name.charAt(i) - 'A', 'Z'- name.charAt(i) + 1);
            if (name.charAt(i) != 'A') {
                notA++;
                notAarr[i] = true;
            }
            distArr[i] = Math.min(i, Math.abs(i-name.length()));
        }

        int minIndex;

        for (int i = 0 ; i < notA ; i++) {
            minIndex = getMinCostIndex(distArr, notAarr);
            totalCost += distArr[minIndex];
            notAarr[minIndex] = false;
            if (minIndex == 0){

            }


            calculateDist(distArr, minIndex);
        }
        System.out.println(totalCost);
    }

    public static int getMinCostIndex(int[] distArr, boolean[] notAarr) {
        int minIndex = 0;
        int minCost = Integer.MAX_VALUE;
        for (int i = 0 ; i < distArr.length ; i++) {
            if (!notAarr[i]) continue;
            if (distArr[i] < minCost) {
                minCost = distArr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    public static void calculateDist(int[] distArr, int minIndex) {
        for (int i = 0 ; i < distArr.length ; i++) {
            distArr[i] = Math.min(Math.abs(minIndex - i), Math.abs(Math.abs(minIndex - i)-distArr.length));
        }
    }


}
