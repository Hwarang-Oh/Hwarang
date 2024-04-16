import java.io.*;

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
                sb.append(oddCheck(target, 0,target.length() - 1, target.length() / 2,0)).append("\n");
        }
        System.out.print(sb);
    }
    public static int evenCheck(String target, int start, int end, int mid, int stack) {
        if (stack == 0) {
            for (int i = 0; i <= mid - start; i++) {
                if (target.charAt(start + i) != target.charAt(end - i)) {
                    return Math.min(oddCheck(target, start + i, end - i - 1, (start + end - 1) / 2, 1),
                            oddCheck(target, start + i + 1, end - i, (start + end + 1) / 2, 1));
                }
            }
            return 0;
        }
        else {
            for (int i = 0; i <= mid - start; i++) {
                if (target.charAt(start + i) != target.charAt(end - i)) {
                    return 2;
                }
            }
            return 1;
        }
    }
    public static int oddCheck(String target, int start, int end, int mid, int stack) {
        if (stack == 0) {
            for (int i = 0; i < mid - start; i++) {
                if (target.charAt(start + i) != target.charAt(end - i)) {
                    return Math.min(evenCheck(target, start + i, end - i - 1, (start + end - 1) / 2, 1),
                            evenCheck(target, start + i + 1, end - i, (start + end + 1) / 2, 1));
                }
            }
            return 0;
        }
        else {
            for (int i = 0; i <= mid - start; i++) {
                if (target.charAt(start + i) != target.charAt(end - i)) {
                    return 2;
                }
            }
            return 1;
        }
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

