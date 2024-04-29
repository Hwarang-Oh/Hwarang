import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String name = input.readLine();
        boolean[] notAarr = new boolean[name.length()]; // A가 아닌 친구들 -> 정신개조 필요한 애들
        int[] distArr = new int[name.length()]; // dist ARR -> 실시간으로 바꿔줘야 함 ㅇㅇ

        int totalCost = 0; // 말그대로..
        int notA = 0; // Not A인 친구들 개수 -> 이만큼 정신개조 돌 예정
        for (int i = 0; i < name.length(); i++) {
            totalCost += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1); // 다 똑같을듯
            if (name.charAt(i) != 'A') {
                notA++;
                notAarr[i] = true;
            }
            distArr[i] = Math.min(i, Math.abs(i - name.length())); // 시작점 0번째 인덱스 // 0 1 2 3 4 3 2 1 // D B A A A B
        }

        int minIndex;

        for (int i = 0; i < notA; i++) {
            minIndex = getMinCostIndex(distArr, notAarr);
            totalCost += distArr[minIndex];
            notAarr[minIndex] = false;
            if (minIndex == 0) {

            }
            calculateDist(distArr, minIndex);
        }
        System.out.println(totalCost);
    }

    public static int getMinCostIndex(int[] distArr, boolean[] notAarr) {
        int minIndex = 0;
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < distArr.length; i++) {
            if (!notAarr[i])
                continue;
            if (distArr[i] < minCost) {
                minCost = distArr[i];
                minIndex = i; //
            }

        }
        return minIndex;
    }

    public static void calculateDist(int[] distArr, int minIndex) {
        for (int i = 0; i < distArr.length; i++) {
            distArr[i] = Math.min(Math.abs(minIndex - i), Math.abs(Math.abs(minIndex - i) - distArr.length));
        }
    }

}
