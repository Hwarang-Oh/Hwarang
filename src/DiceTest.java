import java.util.Arrays;
import java.util.Scanner;

// 주사위 던지기 (던지는 횟수는 6번 이하라고 하자)
public class DiceTest {
    static int N, numbers[];
    static boolean[] isSelected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 주사위를 던지는 횟수
        numbers = new int[N];
        int mode =sc.nextInt();
        switch (mode) {
            case 1: // 중복 순열
                dice1(0);
                break;
            case 2: // 순열 : 중복 관리
                isSelected = new boolean[7];
                dice2(0);
                break;
        }
    }
    // 순열 + 중복 순열 => 고정된 수 순열 -> 입력된 수에 대한 순열
    // 현재는 주사위 던지기 ( 1 ~ 6으로 뽑을 후보가 결정되어 있음 )
    // 가변적인 input 배열이 들어오는 대로 처리를 해주려면?
    // 그대로 들어온 input 배열의 위치에 따라 isSelected로 관리해주기!
    // 중복 순열
    private static void dice1(int cnt) { // cnt : 기존까지 던진 주사위 횟수
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 1 ; i <= 6; i++) { // 모든 주사위의 눈의 수를 시도
//            if(isSelected[i]) continue;
            numbers[cnt] = i;
//            isSelected[i] = true;
            dice1(cnt + 1);
//            isSelected[i] = false;
        }
    }
    // 순열
    private static void dice2(int cnt) { // cnt : 기존까지 던진 주사위 횟수
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 1 ; i <= 6; i++) { // 모든 주사위의 눈의 수를 시도
            if(isSelected[i]) continue;
            numbers[cnt] = i;
            isSelected[i] = true;
            dice2(cnt + 1);
            isSelected[i] = false;
        }
    }
    // 중복 조합 
}
