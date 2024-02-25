import java.util.Scanner;

public class A0205_PowerSetTest {
    static int N, input[];
    static boolean isSelected[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N];

        for (int i = 0 ; i < N ; i++)
            input[i] = sc.nextInt();
        generateSubSet(0);
    }
    public static void generateSubSet(int cnt) {

        if (cnt == N) {
            for (int i = 0; i < N ; i++) {
                System.out.print((isSelected[i]? input[i] : "X") + " ");
            }
            System.out.println();
            return;
        }

        isSelected[cnt] = true; // 부분집합 포함
        generateSubSet(cnt + 1); // 다음 자리
        isSelected[cnt] = false; // 부분집합 포함 X
        generateSubSet(cnt + 1); // 다음 자리

    }
}
