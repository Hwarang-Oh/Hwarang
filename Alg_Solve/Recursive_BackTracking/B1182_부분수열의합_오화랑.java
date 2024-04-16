import java.io.*;
import java.util.*;

public class B1182_부분수열의합_오화랑 {
    static int makeCount;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int numC = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] numbers = new int[numC];


        st = new StringTokenizer(input.readLine());
        for (int i = 0 ; i < numC ; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);
        subSet(numC, numbers, target, 0, 0);

        if (target == 0) System.out.println(makeCount - 1);
        else System.out.println(makeCount);

    }
    public static void subSet(int numC, int[] numbers, int target, int cnt, int currSum) {
        if (cnt == numC) {
            if (currSum == target) makeCount++;
            return;
        }
        if (numbers[cnt] > 0 && currSum > target) return;

        subSet(numC, numbers, target, cnt + 1, currSum + numbers[cnt]);
        subSet(numC, numbers, target, cnt + 1, currSum);
    }
}




// 0
// -2 -3 5 -7 8
// -7 -3 -2 5 8


// -7 -5 -3 -2 9

// 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수
// 정수의 개수를 나타내는 N과 정수 S가 주어짐 (1 <= N <= 20, |S| <= 1,000,000)
// 5 0
// -7 -3 -2 -5 8
// 어떻게 풀 수 있을까? ( 강의 시간에 나온 문제 )
// NP?, PowerSet -> BackTrack?, DP?