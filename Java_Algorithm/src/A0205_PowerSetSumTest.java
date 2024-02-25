import java.util.Scanner;

public class A0205PowerSetSumTest {
    static int N, target, input[];
    static boolean isSelected[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        target = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N];

        for (int i = 0 ; i < N ; i++)
            input[i] = sc.nextInt();
        generateSubSet(0, 0);
    }
    public static void generateSubSet(int cnt, int currSum) { // currSum : 기존 부분집합의 누적합

        if (cnt == N) { // 모든 원소가 고려되었다면, 부분집합을 구성하는 원소들의 합이 목표합이 되는가?
            if (currSum == target) {
                for (int i = 0; i < N; i++)
                    if(isSelected[i]) System.out.print(input[i] + " ");
                System.out.println();
            }
            return;
        }
        isSelected[cnt] = true; // 부분집합 포함 -> 선택된 요소를 관리하는 것
        generateSubSet(cnt + 1, currSum + input[cnt]); // 다음 자리
        isSelected[cnt] = false; // 부분집합 포함 X
        generateSubSet(cnt + 1, currSum); // 다음 자리

    }
}
