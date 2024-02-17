import java.io.*;
import java.util.*;

public class S9229_한빈이와SpotMart_오화랑{
    static int tcMax = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(input.readLine());
        int num; int maxWeight;

        for (int tc = 1 ; tc <= testCase ; tc++) {
            st = new StringTokenizer(input.readLine());
            num = Integer.parseInt(st.nextToken());
            maxWeight = Integer.parseInt(st.nextToken());
            int [] weightList = new int [num];

            st = new StringTokenizer(input.readLine());
            for (int i = 0 ; i < num ; i++)
                weightList[i] = Integer.parseInt(st.nextToken());
            sumCheck(weightList, maxWeight, num);
            sb.append("#").append(tc).append(" ").append(tcMax).append("\n");
            tcMax = -1;
        }
        System.out.println(sb);
    }
    public static void sumCheck(int[] weightList, int maxWeight, int num) {
        int tempWeight = 0;
        for (int i = 0 ; i < num ; i++) {
            tempWeight = weightList[i];
            for (int j = i + 1 ; j < num ; j++) {
                tempWeight += weightList[j];
                if (tempWeight <= maxWeight)
                    tcMax = Math.max(tcMax, tempWeight);
                tempWeight -= weightList[j];
            }
        }
    }
}
