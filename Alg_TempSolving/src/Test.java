import java.io.*;
import java.util.*;

public class Test {
    static int[] made, parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(input.readLine());
        int M = Integer.parseInt(input.readLine());
        int[] numbers = new int[N];
        visited = new boolean[N];
        made = new int[M];

        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        Perm(0, M, numbers);
    }

    public static void Perm(int cnt, int M, int[] numbers) {
        if (cnt == M) {
            System.out.println(Arrays.toString(made));
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            made[cnt] = numbers[i];
            visited[i] = true;
            Perm(cnt + 1, M, numbers);
            visited[i] = false;
        }
    }

    public static void Comb(int cnt, int start, int M, int[] numbers) {
        if (cnt == M) {
            System.out.println(Arrays.toString(made));
            return;
        }
        for (int i = start; i < numbers.length; i++) {
            made[cnt] = numbers[i];
            Comb(cnt + 1, i + 1, M, numbers);
        }
    }

    public static void Power(int cnt, int[] numbers) {
        if (cnt == numbers.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < numbers.length; i++) {
                if (visited[i])
                    temp.add(numbers[i]);
            }
            if (temp.size() > 0)
                System.out.println(temp);
        }
        visited[cnt] = true;
        Power(cnt + 1, numbers);
        visited[cnt] = false;
        Power(cnt + 1, numbers);
    }
}