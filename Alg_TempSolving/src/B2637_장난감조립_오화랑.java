import java.io.*;
import java.util.*;

public class B2637_장난감조립_오화랑 {
    static class Pair {
        int num, need;

        public Pair(int num, int need) {
            this.num = num;
            this.need = need;
        }
    }

    static HashMap<Integer, Queue<Pair>> midMap = new HashMap<>();
    static HashMap<Integer, int[]> midMadeMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(input.readLine()); // parts_No
        int M = Integer.parseInt(input.readLine()); // parts_details_Num

        int mid, num, need;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            mid = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());
            need = Integer.parseInt(st.nextToken());
            if (!midMap.containsKey(mid)) {
                midMap.put(mid, new ArrayDeque<>());
                midMadeMap.put(mid, new int[N + 1]);
            }
            midMap.get(mid).offer(new Pair(num, need));
        }
        getBasic(N, N);
        for (int i = 1; i <= N; i++) {
            if (!midMadeMap.keySet().contains(i))
                sb.append(i).append(" ").append(midMadeMap.get(N)[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void getBasic(int madeNum, int N) {
        Queue<Pair> temp = midMap.get(madeNum);
        Pair tPair;
        while (!temp.isEmpty()) {
            tPair = temp.poll();
            if (!midMap.keySet().contains(tPair.num))
                midMadeMap.get(madeNum)[tPair.num] += tPair.need;
            else {
                if (!midMap.get(tPair.num).isEmpty())
                    getBasic(tPair.num, N);
                for (int i = 1; i <= N; i++)
                    midMadeMap.get(madeNum)[i] += (midMadeMap.get(tPair.num)[i] * tPair.need);
            }
        }
    }
}

// 어떤 장난감을 여러가지 부품으로 조립하여 만들고자 함.
// => 기본 부품 + 중간 부품 => 장난감 1개
// 5 중간 부품 => 기본 1 2개 + 기본 2 2개
// 6 중간 부품 => 중간 5 2개 + 기본 3 3개 + 기본 4 4개
// 7 완제품 => 중간 5 2개 + 중간 6 3개 + 기본 4 5개
// 두 중간 제품이 서로를 필요로 하는 경우느 존재 X
// DP 혹은 메모이제이션 성격이 보인다.

// 숫자를 기준으로 기존 부품이 결정된다는 생각은 하면 안된다. 기본 부품은 중간에 섞여 있을 수 있다.
/*
 * 
 * 7
 * 8
 * 5 1 2
 * 5 2 2
 * 7 5 2
 * 6 5 2
 * 6 3 3
 * 6 4 4
 * 7 6 3
 * 7 4 5
 * 
 * 1 16
 * 2 16
 * 3 9
 * 4 17
 * 
 */