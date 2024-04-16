import java.util.Scanner;
import java.math.BigInteger;

public class BOJ_1914_HR {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        BigInteger moveCnt = new BigInteger("2");
        BigInteger cntMinus = new BigInteger("1");
        moveCnt = moveCnt.pow(num).subtract(cntMinus);

        System.out.println(moveCnt);
        if (num <= 20) {
            hanoi(num, 1,2,3);
            System.out.print(sb);
        }
    }
    public static void hanoi (int cnt, int from, int temp, int to) {
        if (cnt == 0) return;
        hanoi(cnt - 1, from, to, temp); // cnt - 1개의 원반을 2번째 기둥으로 옮긴다
        sb.append(from).append(" ").append(to).append("\n"); // cnt인 마지막 원반을 3번째 기둥으로 옮긴다.
        hanoi(cnt - 1, temp, from, to); // cnt -1개의 원반을 3번째 기둥으로 옮긴다.
    }
}

// 5개를 옮기는 과정 : 4개의 원판을 2번째 기둥으로 옮기고 ( 마치 2번째 기둥을 통해, 3번째 기둥으로 옮기듯이 반대로! )  ( 15번 )
// => 5개째 원반을 3번째 기둥으로 옮기고 (1번) => 4개의 원판을 3번째 기둥으로 옮긴다 ( 15번 )
// => 31번
// 4개의 원판을 옮기는 개수가 같은 이유는? => 5번째 기둥을 건들지 않다면, 평범한 기둥 상태와 다를게 없이 기능함.

//        sb.append(cnt + " : " + from + " -> " + to + "\n");
