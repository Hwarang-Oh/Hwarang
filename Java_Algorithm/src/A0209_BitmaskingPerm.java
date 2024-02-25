import java.util.*;

public class A0209_BitmaskingPerm {
    static int N, R, input[], numbers[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        input = new int[N];
        numbers = new int[R];

        for (int i = 0 ; i < N ; i++)
            input[i] = sc.nextInt();

        for (int i = 1 ; i <= R ; i++)
            perm(0,0, i);
    }
    public static void perm(int cnt, int flag, int R) {
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 0 ; i < N ; i++) {
            if ((flag & 1 << i) != 0) continue;
            numbers[cnt] = input[i]; // 수 선택

            perm(cnt + 1 , flag | 1<<i, R);
        }
    }
}
