
/**
 * B15654_N과M5_오화랑
 */
import java.io.*;
import java.util.*;

public class B15654_N과M5_오화랑 {
    static int[] numbers, selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        selected = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(input.readLine());
        int i = 0;
        while (st.hasMoreTokens())
            numbers[i++] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);
        permutate(0, 0, N, M);
        System.out.println(sb);
    }

    public static void permutate(int curr, int count, int N, int M) {
        if (count == M) {
            for (int num : selected)
                sb.append(num).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = curr; i < N; i++) {
            if (visited[i])
                continue;
            selected[count] = numbers[i];
            visited[i] = true;
            permutate(curr, count + 1, N, M);
            visited[i] = false;
        }
    }
}