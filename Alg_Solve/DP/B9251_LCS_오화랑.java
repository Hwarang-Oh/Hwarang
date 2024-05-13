import java.io.*;

public class B9251_LCS_오화랑 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String N = input.readLine();
        String M = input.readLine();
        int[][] memo = new int[N.length() + 1][M.length() + 1];

        for (int i = 0; i < N.length(); i++) {
            for (int j = 0; j < M.length(); j++) {
                if (N.charAt(i) == M.charAt(j))
                    memo[i + 1][j + 1] = memo[i][j] + 1;
                else
                    memo[i + 1][j + 1] = Math.max(memo[i][j + 1], memo[i + 1][j]);
            }
        }
        System.out.println(memo[N.length()][M.length()]);
    }
}

// 문제 이름 그대로 LCS (최장 공통 부분수열) => 두 수열이 주어졌을 때, 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제
// LIS와 약간 다른 것이다. (최장 증가 부분수열 )
