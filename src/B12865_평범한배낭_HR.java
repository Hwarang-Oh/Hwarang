import java.util.*;
import java.io.*;

public class B12865_평범한배낭_HR {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(st.nextToken());
        int bagMax = Integer.parseInt(st.nextToken());
        int [][] wvList = new int[num + 1][2];
        int [][] madeList = new int [num + 1][bagMax + 1];

        for (int i = 1 ; i <= num ; i++) {
            st = new StringTokenizer(input.readLine());
            wvList[i][0] = Integer.parseInt(st.nextToken()); // weight
            wvList[i][1] = Integer.parseInt(st.nextToken()); // value
        }
        int temp;
        for (int i = 1 ; i <= num ; i++) {
            for (int w = 1 ; w <= bagMax ; w++) {
                if (wvList[i][0] <= w) { // 고른 물건의 무게가 현재 가방 용량보다 minSame => 선택 or Not
                    temp = wvList[i][1] + madeList[i - 1][w - wvList[i][0]]; // 고른 물건 선택
                    if (temp > madeList[i -1][w]) // 선택 > 선택X
                        madeList[i][w] = temp;
                    else
                        madeList[i][w] = madeList[i -1][w];
                }
                else
                    madeList[i][w] = madeList[i-1][w];
            }
        }
        System.out.println(madeList[num][bagMax]);
    }
}

// 들어온 Input
// 6 13
// 4 8
// 3 6
// 5 12

// Weight 7의 MindSet
// 7 -> f(4, 7) : 4개의 물건, 7kg 내외의 maxValue
// 6 13 선택 -> f(3,1) : 3개의 물건, 1kg 내외의 maxValue Problem
// 6 13 선택X -> f(3,7) : 3개의 물건, 7kg 내외의 maxValue Problem
// 4 8 선택 -> f(3, 3) : 3개의 물건, 3kg 내외의 maxValue Problem
// 4 8 선택X -> f(3, 7) : 3개의 물건, 7kg 내외의 maxValue Problem
