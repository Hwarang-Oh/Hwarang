import java.io.*;

public class B2577_숫자의개수_오화랑 {

    static class Solution {
        int result;
        int[] used = new int[10];

        void init() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int A = Integer.parseInt(input.readLine());
            int B = Integer.parseInt(input.readLine());
            int C = Integer.parseInt(input.readLine());
            result = A * B * C;

            String temp = String.valueOf(result);
            for (int i = 0; i < temp.length(); i++) {
                used[Character.getNumericValue(temp.charAt(i))]++;
            }

            for (int eachUsed : used) {
                sb.append(eachUsed).append("\n");
            }

            System.out.print(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.init();
    }
}
