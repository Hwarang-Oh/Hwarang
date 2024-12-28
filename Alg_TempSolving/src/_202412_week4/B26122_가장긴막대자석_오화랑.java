package _202412_week4;

import java.io.*;

// IMP : https://www.acmicpc.net/problem/26122
// IMP : 2024.12.24
// IMP : 정말 정신이 나가게 하는 문제 -> 과연 문제의 의도가 무엇일까..? => Code 최적화 여지가 많이 남아 있다. 

/**
 * IMP : 막대 자석 문자열
 * * N의 개수와 S의 개수는 동일 -> 문자열 앞쪽 절반을 구성하는 문자는 N or S
 * * SNS, NNNSS, NSNS -> 막대 자석 문자열 X
 * * 가장 긴 막대 자석 문자열을 찾고자 함 (부분 문자열 중에! => 문자열의 연속된 일부)
 * * K <= 300,000 => 결국 1번의 loop 내의 탐색으로 가야 한다.
 * * 못찾으면 0, 찾으면 길이
 * IMP : 상태는 총 4가지 정도로 생각할 수 있다.
 * * 1. N이 앞 부분을 만드는 경우 (이는 동시에 뒷 부분을 만들고 있는 것)
 * * 2. N이 뒷 부분을 만드는 경우 (이는 동시에에 앞 부분을 만들고 있는 것)
 * * 3. S가 앞 부분을 만드는 경우
 * * 4. S가 뒷 부분을 만드는 경우
 */

public class B26122_가장긴막대자석_오화랑 {

    static class Solution {
        int K;
        int totalMaxCount;
        String target;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            K = Integer.parseInt(input.readLine());
            target = input.readLine();

            int state = target.charAt(0) == 'N' ? 0 : 1;
            int nPastCount = 0;
            int nCurrentCount = 0;
            int sPastCount = 0;
            int sCurrentCount = 0;
            int magCount;
            for (int i = 0; i < K; i++) {
                if (state == 0) {
                    if (target.charAt(i) == 'N') {
                        nCurrentCount++;
                        magCount = Math.min(nCurrentCount, sPastCount);
                        totalMaxCount = Math.max(totalMaxCount, magCount * 2);
                        if (nCurrentCount == sPastCount)
                            sPastCount = 0;
                    } else {
                        state = 1;
                        nPastCount = nCurrentCount;
                        nCurrentCount = 0;
                        sCurrentCount++;
                        totalMaxCount = Math.max(totalMaxCount, 2);
                    }
                } else {
                    if (target.charAt(i) == 'N') {
                        state = 0;
                        sPastCount = sCurrentCount;
                        sCurrentCount = 0;
                        nCurrentCount++;
                        totalMaxCount = Math.max(totalMaxCount, 2);
                    } else {
                        sCurrentCount++;
                        magCount = Math.min(nPastCount, sCurrentCount);
                        totalMaxCount = Math.max(totalMaxCount, magCount * 2);
                        if (sCurrentCount == nPastCount)
                            nPastCount = 0;
                    }
                }
            }
            System.out.println(totalMaxCount);
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
