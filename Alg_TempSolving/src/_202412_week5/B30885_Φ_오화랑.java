package _202412_week5;

import java.io.*;
import java.util.*;

/**
 * IMP : https://www.acmicpc.net/problem/30885
 * IMP : 2025.01.02
 */

/**
 * * 미생물 여러 마리를 나열하면, 한 마리만 남을 때 까지 규칙에 따라 서로 흡수함
 * IMP : 1. 하루에 한 번, 맨 앞에 있는 미생물 부터 차례대로, 인접한 미생물 중 자신보다 크기가 작거나 같은 것을 흡수
 * * 미생물을 흡수한 경우, 미생물의 크기는 흡수한 미생물 크기의 합만큼 커진다.
 * IMP : 2. 흡수당한 미생물은 사라지며 행동할 수 없다.
 * IMP : 3. 흡수 과정은 하루에 1번만 발생한다. ( 한번 흡수를 해서 커지게 되면, 그 다음에 의한 흡수 과정은 더이상 진행 불가 )
 * Type : 미생물의 수 1 <= N <= 500,000
 * Type : 미생물의 초기 크기는 모두 다르다. 초기 크기 ( 1 <= N <= 500,000 )
 * ! 합쳐졌을 때, Int 범위를 초과할 수 있기 때문에, 미생물의 크기는 long Type으로 관리하는 것이 좋아 보임.
 * 
 * ? Method 1 : Queue를 Size만큼 반복을 돌아야 할까? -> 근데 최악의 경우에는 결국 2500억 횟수임 ( 시간 복잡도가
 * 너무 많이 감 )
 * * => 하지만, Queue의 Size가 계산을 하다 보면, 계속 1 / 2이 될 것이라 기대할 수 있음 => 어쩌면.. n^2 / 2^n
 * 으로 시간 복잡도가 괜찮을 수도?
 * ? 구현 문제 + 자료 구조를 활용하는 문제다. => 아마 중간 삽입이 없기 때문에 Linked List를 활용하는 것이 가장 최적화 일
 * 수 있다.
 * ? ArrayDeque를 활용하면. 구현이 그래도 나쁘지 않은 편으로 된다.
 */

public class B30885_Φ_오화랑 {
    static class Micro {
        long size;
        int loc;
        boolean alive;

        public Micro(long size, int loc, boolean alive) {
            this.size = size;
            this.loc = loc;
            this.alive = alive;
        }

        public String toString() {
            return this.size + "\n" + this.loc;
        }
    }

    static class Solution {
        int N;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(input.readLine());

            ArrayDeque<Micro> queue = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int i = 1; i <= N; i++) {
                int startSize = Integer.parseInt(st.nextToken());
                queue.offer(new Micro(startSize, i, true));
            }

            int minLoc = 1;
            int maxLoc = N;
            while (queue.size() > 1) {
                long currentAdd = 0;
                Micro current = queue.poll();

                if (current.loc == minLoc) {
                    Micro next = queue.peek();
                    if (current.size >= next.size) {
                        current.size += next.size;
                        next.alive = false;
                        queue.poll();
                    }
                    queue.offer(current);
                    continue;
                }

                if (current.loc == maxLoc) {
                    Micro prev = queue.peekLast();
                    if (current.size >= prev.size) {
                        current.size += prev.size;
                        prev.alive = false;
                        queue.pollLast();
                    }
                    queue.offer(current);
                    continue;
                }

                Micro next = queue.peek();
                Micro prev = queue.peekLast();
                if (current.size >= next.size) {
                    currentAdd += next.size;
                    next.alive = false;
                    queue.poll();
                    if (next.loc == maxLoc)
                        maxLoc = current.loc;
                }
                if (current.size >= prev.size) {
                    currentAdd += prev.size;
                    prev.alive = false;
                    queue.pollLast();
                    if (prev.loc == minLoc)
                        minLoc = current.loc;
                }
                current.size += currentAdd;
                queue.offer(current);

            }
            System.out.println(queue.peek());
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}