package tempDone;

import java.io.*;
import java.util.*;

/*
 * 팰린드롬?
 * 2000개의 숫자 -> Stack으로 각각 판단?
 * 질문은 최대 100만개
 * 하지만 Each 연산이 그렇게 많지 않음 -> 가능할까?
 * => 1692ms 걸림 <-> 다른 답안들 : 1000ms
 * => 어디서 비효율이 나타났을까? ( 고민이 필요한 부분 )
 */

public class B10942_팰린드롬_오화랑_최적화필요 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int nSize = Integer.parseInt(input.readLine());
        int[] numbers = new int[nSize + 1];
        st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= nSize; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int qSize = Integer.parseInt(input.readLine());
        int start, end, mid, size, isPalindrome;
        Stack<Integer> temp = new Stack<>();
        for (int i = 0; i < qSize; i++) {
            st = new StringTokenizer(input.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            size = end - start + 1;
            mid = (start + end) / 2;
            isPalindrome = 1; // It is Palindrome

            if ((size) % 2 == 0) {
                for (int j = 0; j <= size / 2 - 1; j++) {
                    if (numbers[mid - j] != numbers[mid + j + 1]) {
                        isPalindrome = 0;
                        break;
                    }
                }
                sb.append(isPalindrome).append("\n");
            } else {
                for (int j = 1; j <= size / 2; j++) {
                    if (numbers[mid - j] != numbers[mid + j]) {
                        isPalindrome = 0;
                        break;
                    }
                }
                sb.append(isPalindrome).append("\n");
            }
        }
        System.out.print(sb);
    }
}
