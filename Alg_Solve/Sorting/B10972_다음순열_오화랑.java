import java.io.*;
import java.util.*;

public class B10972_다음순열_오화랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(input.readLine());
        int[] currP = new int[size];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0 ; i < size ; i++) currP[i] = Integer.parseInt(st.nextToken());
        if (nextP(currP)) for (int i = 0 ; i < size ; i++) sb.append(currP[i]).append(" ");
        else sb.append(-1);
        System.out.println(sb);
    }
    public static boolean nextP(int[] currP){
        final int size = currP.length;

        int target = size - 1; // 바꿔지는 대상 탐색의 시작점은 끝
        while (target > 0 && currP[target - 1] > currP[target]) --target; // target - 1번째 숫자가 target번째 숫자보다 작으면 Stop (현재 경우 5번이 바꿔질 대상임)
        if (target == 0) return false; // 끝까지 와도, 그런 target번째가 존재하지 않다면 마지막 사전 순열임 -> -1

        int swapLoc = size - 1; // 바꾸는 대상 탐색의 시작점도 끝
        while (currP[target - 1] > currP[swapLoc]) --swapLoc; // target - 1번째보다 바로 1단계만 큰 숫자와 교체 (반드시 존재한다 -> 적어도 target번째가 target - 1번째보다 크게 존재하기 때문이다.)
        swap(currP, target - 1, swapLoc);

        int back = size - 1; // swap을 통해 target 뒤에 존재하는 숫자들의 오름차순 정렬이 필요함
        while (target < back) swap(currP, target++, back--);
        return true; // NextP가 존재한다.
    }
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
// step 3 : swap을 통해 target 뒤에 존재하는 숫자들의 오름차순 정렬이 필요함 -> 해당 부분 공부 필요