import java.io.*;
import java.util.*;


public class B2042_구간합구하기_오화랑 {
    static long[] numArr;
    static long[] rawArr;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();
        int nNum = Integer.parseInt(st.nextToken());
        int oNum = Integer.parseInt(st.nextToken());
        int qNum = Integer.parseInt(st.nextToken());
        numArr = new long[nNum + 1];
        rawArr = new long[nNum + 1];

        int currLoc, eachRep;
        long eachNum;
        for (int i = 1 ; i <= nNum ; i++) {
            currLoc = i;
            eachNum = Long.parseLong(input.readLine());
            rawArr[currLoc] = eachNum;
            while (currLoc <= nNum) {
                numArr[currLoc] += eachNum;
                eachRep = currLoc & -currLoc;
                currLoc += eachRep;
            }
        }
//        System.out.println(Arrays.toString(numArr));

        int opt, loc;
        long eachSum1, eachSum2;
        eachSum1 = eachSum2 = 0;
        for (int i = 0 ; i < oNum + qNum ; i++) {
            st = new StringTokenizer(input.readLine());
            opt = Integer.parseInt(st.nextToken());
            loc = Integer.parseInt(st.nextToken());

            switch (opt) {
                case 1 : {
                    long to = Long.parseLong(st.nextToken());
                    eachNum = to - rawArr[loc];
                    rawArr[loc] = to;
                    while (loc <= nNum) {
                        numArr[loc] += eachNum;
                        eachRep = loc & -loc;
                        loc += eachRep;
                    }
                    break;
                }

                case 2 : {
                    int to = Integer.parseInt(st.nextToken());
                    while(to > 0) {
                        eachSum1 += numArr[to];
                        eachRep = to & -to;
                        to -= eachRep;
                    }
                    loc = loc - 1;
                    while(loc > 0) {
                        eachSum2 += numArr[loc];
                        eachRep = loc & - loc;
                        loc -= eachRep;
                    }
                    sb.append(eachSum1 - eachSum2).append("\n");
                    eachSum1 = eachSum2 = 0;
                }
            }
        }
        System.out.print(sb);
    }
}
// 5 -> 6 -> 8 -> 16 -> 32
