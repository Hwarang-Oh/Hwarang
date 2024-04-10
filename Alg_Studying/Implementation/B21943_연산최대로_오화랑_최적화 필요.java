import java.io.*;
import java.util.*;

public class B21943_연산최대로_오화랑 {
    static int[] numArr;
    static int[] selected;
    static int maxResult = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int nCnt = Integer.parseInt(input.readLine());
        numArr = new int[nCnt];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0 ; i < nCnt ; i++) numArr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        int sCnt = Integer.parseInt(st.nextToken());
        int mCnt = Integer.parseInt(st.nextToken());
        selected = new int[nCnt];
        getSet(0, nCnt, mCnt);
        System.out.println(maxResult);
    }

    public static void getSet(int cnt, int nCnt, int mCnt) {
        if (cnt == nCnt) {
            int currResult = 1;
            int[] sumArr = new int[mCnt + 1];
            for (int i = 0 ; i < nCnt ; i++) sumArr[selected[i]] += numArr[i];
            for (int i = 0 ; i <= mCnt ; i++) {
                currResult *= sumArr[i];
                if (currResult == 0) return;
            }
            maxResult = Math.max(maxResult, currResult);
            return;
        }
        for (int i = 0 ; i <= mCnt ; i++) {
            selected[cnt] = i;
            getSet(cnt + 1, nCnt, mCnt);
        }
    }
}

// 분할하고 -> 계산한다
