package _202412_week4;

import java.util.*;

// IMP : https://www.acmicpc.net/problem/22846
// IMP : 2024.12.26
// ? : PriorityQueue를 이용한 접근법은 실패
// ? : Point 접근 주도권을 근거로 Dynamic Programming 도전
// ? : 해당 Satte에서 이길 수 있는가?에 대한 Top - Down 접근법이 유효한 방법 
// Type : https://www.acmicpc.net/problem/11062 ( 유사한 문제, Game Theory )

/**
 * IMP : 모니터에 1로 시작
 * * 1. 순서에 맞춰서 자신의 차례에 모니터에 쓰여 있는 수의 약수를 하나 선택해 모니터에 있는 값이 더한다
 * * 2. 제한 K를 초과하면, 패배하게 된다.
 * * 3. 제한 K가 주어졌을 때 누가 이기게 되는 지 구하라.
 * ! Player는 최선의 전략으로 플레이를 하게 된다. ( 이게 진짜 X같은 묘사 )
 * 순서 : Kali -> Ringo -> Kali -> Ringo ...
 */

/**
 * IMP : 반드시 이루어지는 것을 찾아보자 ( 해당 Point의 접근 주도권 )
 * * 1. K -> 2에 먼저 도착한다.
 * * 2. R -> 3에 먼저 도착할 수 있다.
 * * 3. R -> 4에 먼저 도착할 수 있다.
 * * 4. 여기서 문제 : R -> 3을 선택하면 -> R -> 5에 먼저 도착할 수 있다.
 * * 4. R -> 4를 선택하면 -> K -> 5에 먼저 도착할 수 있다. => 이렇게 따지면, R에 의해 결정나는 것이라 R이 3,4,5
 */

public class B22846_인증된쉬운게임_오화랑 {

    static class Solution {
        int K;
        boolean[] state; // IMP : 해당 Point에 의도적으로 접근할 수 있는 주도권은 누구에게 있는가? ( Kali : 1, Ringo : -1 )

        void run() {
            Scanner input = new Scanner(System.in);
            K = input.nextInt();
            state = new boolean[K + 1];
            input.close();

            for (int i = K; i > 0; i--) {
                for (int d = 1; d <= Math.sqrt(i); d++) {
                    if (i % d == 0) {
                        if (i + d <= K && !state[i + d])
                            state[i] = true;

                        if (i + i / d <= K && !state[i + i / d])
                            state[i] = true;
                    }
                }
            }
            System.out.println(state[1] ? "Kali" : "Ringo");
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}