import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17609_회문_오화랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numC = Integer.parseInt(input.readLine());
        String target;
        for (int i = 0 ; i < numC ; i++) {
            target = input.readLine();
            if (target.length() % 2 == 0)
                sb.append(evenCheck(target,0,target.length() - 1, target.length() / 2, 0)).append("\n");
            else
                sb.append(oddCheck(target, target.length() - 1, target.length() / 2)).append("\n");
        }
        System.out.print(sb);
    }
    public static int evenCheck(String target, int start, int end, int mid, int stack) {
        for (int i = start; i <= mid; i++) {
            if (target.charAt(i) != target.charAt(end - i)) {
                return 2;
            }
        }
        if (stack > 0) return 1;
        return 0;
    }
    public static int oddCheck(String target, int end, int mid) {
        for (int i = 0 ; i < mid ; i++) {
            if (target.charAt(i) != target.charAt(end - i)) {
                return Math.min(evenCheck(target, i, end - i - 1, (end - 1) / 2, 1),
                        evenCheck(target, i + 1, end - i, (end + 1) / 2, 1));
            }
        }
        return 0;
    }
}

// 회문 -> 팰린드롬 문자열
// 유사회문 -> 하나를 삭제했을 때 -> 팰린드롬 문자열
/*
7
abba
summuus
xabba
xabbay
comcom
comwwmoc
comwwtmoc
 */

