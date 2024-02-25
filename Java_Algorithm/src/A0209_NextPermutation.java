import java.util.*;

public class A0209_NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];
        // NP는 자리를 뽑아가면서 만드는 순열이 아님
        // 숫자를 담아내는 number[]는 필요하지 않음

        for (int i = 0 ; i < N ; i++)
            input[i] = sc.nextInt();
        // step0 : 정렬 ( 오름차순 ) -> 가장 Base인 작은 순열
        Arrays.sort(input);

        do {
            // 순열 이용한 처리 로직
//            System.out.println(Arrays.toString(input));
        } while(NextP(input));
        System.out.println("end");
    }
    // Permutation의 뒤쪽부터 작은 변화를 준다
    public static boolean NextP(int[] p) {
        // 현재 순열의 다음 순열의 생성 ( true / false )
        // p : 현재 순열의 상태를 받아냄
        final int N = p.length;

        // step 1 : 교환 위치 찾기 (뒤쪽부터 꼭대기를 찾으면, 꼭대기 이전이 교환위치)
        int i = N - 1; // Top
        while (i > 0 && p[i - 1] > p[i]) --i;
        // While문 종료 조건 (앞 or 뒤)
        // 1. i가 0이 되어서 종료 -> 가장 큰 마지막 순열에 도달 함 -> 종료조건
        if (i == 0) return false; // 현 순열의 상태가, 가장 마지막 순열
        // 2. p[i - 1] <= p[i]를 찾음. 교환 위치를 찾은 상태

        // step 2 : 교환 위치 (i - 1)에 넣을 값을 뒤쪽부터 찾기 ( 큰 값 중 최소값 )
        int j = N - 1;
        while(p[i-1] >= p[j]) --j;
        // 반드시 종료조건이 존재함 ( 꼭대기 보다 바로 아래에 있는 i - 1 : 본인보다 큰 값 존재! )

        //  step 3 : 교환 위치 (i - 1) 값과 찾은 위치 (j) 교환
        swap(p, i-1, j); // 꼭대기 (i)위치부터 맨 뒤까지 오름차순 정렬
        int K = N - 1;
        while ( i < K ) swap(p, i++, K--);

        return true;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
