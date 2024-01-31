import java.io.*;
import java.util.*;

public class BOJ_15650_HR {
    static StringBuilder sb = new StringBuilder();
    static boolean[] used;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        numbers = new int[length];
        used = new boolean[numCnt + 1];
        cal(length, numCnt, 1, 0);
        System.out.println(sb);
    }
    public static void cal(int length, int numCnt, int start, int cnt) {
        if (cnt == length) {
            for (int num : numbers)
                sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = start ; i <= numCnt ; i++) {
            if (used[i]) continue;
            numbers[cnt] = i;
            used[i] = true;
            cal(length, numCnt, numbers[cnt],cnt + 1);
            used[i] = false;
        }
    }
}
