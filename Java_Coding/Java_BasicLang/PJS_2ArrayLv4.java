import java.io.*;
import java.util.*;

public class PJS_2ArrayLv4 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader input = new BufferedReader(new FileReader("input.txt")); -> 파일로 읽기
        StringTokenizer st;
        int testCase = Integer.parseInt(input.readLine());

        for (int eachCase = 0; eachCase < testCase; eachCase++) {
            int size = Integer.parseInt(input.readLine());
            st = new StringTokenizer(input.readLine());

            int wk_row = Integer.parseInt(st.nextToken()) - 1;
            int wk_col = Integer.parseInt(st.nextToken()) - 1;
            int bq_row = Integer.parseInt(st.nextToken()) - 1;
            int bq_col = Integer.parseInt(st.nextToken()) - 1;
            int[] wk = { wk_row, wk_col };
            int[] bq = { bq_row, bq_col };

            int result = checkMate(size, wk, bq);
            System.out.printf("#%d %d%n", eachCase + 1, result);
        }
        input.close(); // Close the BufferedReader to release resources
    }

    static int checkMate(int size, int[] wk, int[] bq) {
        int[][] moveList = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (int[] eachMove : moveList) {
            int[] temp = { bq[0], bq[1] };
            for (int i = 0; i < size; i++) {
                temp[0] += eachMove[0];
                temp[1] += eachMove[1];
                if (temp[0] >= size || temp[1] >= size || temp[0] < 0 || temp[1] < 0)
                    break;

                if (temp[0] == wk[0] && temp[1] == wk[1])
                    return 1;
            }
        }
        return 0;
    }
}
