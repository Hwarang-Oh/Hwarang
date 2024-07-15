import java.io.*;
import java.util.*;

/*
 * Greedy 방식을 채용한 풀이법 -> 실패
 * 가장 긴 증가하는 부분 수열 -> LIS
 * => 10 20 10 30 20 50
 * => 10 ( 1: 10 )
 * => 10 20 ( 2 : 10 20 )
 * => 10 20 10 ( 2 : 10 20 )
 * => 10 20 10 30 ( 3: 10 20 30 )
 * => 10 20 10 30 20 (3 : 10 20 30 )
 * => 10 20 10 30 20 50 ( 4: 10 20 30 50 )
 * -> 이렇게 보면, 간단한 문제로 보이지만...
 * 10 20 5 10 15 30 40 50 
 * -> 10 20 30 40 50 (5개)
 * -> 5 10 15 30 40 50 (6개)
 *  
 */

// https://www.acmicpc.net/problem/14003
public class B14003_가장긴증가하는부분수열5_오화랑_실패 {
    static class poss {
        int size;
        ArrayDeque<Integer> list;

        public poss(int size, ArrayDeque<Integer> list) {
            this.size = size;
            this.list = list;
        }
    }

    static class Solution {
        int N;
        poss LIS = new poss(0, new ArrayDeque<>());
        PriorityQueue<poss> possList = new PriorityQueue<>(new Comparator<poss>() {
            @Override
            public int compare(poss o1, poss o2) {
                int first = Integer.compare(o1.list.peekLast(), o2.list.peekLast());
                int second = Integer.compare(o2.size, o1.size);
                return first != 0 ? first : second;
            }
        });

        PriorityQueue<poss> next = new PriorityQueue<>(new Comparator<poss>() {
            @Override
            public int compare(poss o1, poss o2) {
                int first = Integer.compare(o1.list.peekLast(), o2.list.peekLast());
                int second = Integer.compare(o2.size, o1.size);
                return first != 0 ? first : second;
            }
        });

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            this.N = Integer.parseInt(input.readLine());
            StringTokenizer st = new StringTokenizer(input.readLine());
            int each, size;
            poss temp;
            for (int i = 0; i < this.N; i++) {
                each = Integer.parseInt(st.nextToken());
                if (possList.isEmpty()) {
                    // System.out.println("First In");
                    temp = new poss(0, new ArrayDeque<>());
                    temp.list.add(each);
                    temp.size++;
                    possList.add(temp);
                    LIS.size = temp.size;
                    LIS.list = temp.list;
                    // System.out.println(temp);
                    continue;
                }

                if (possList.peek().list.peekLast() > each) {
                    // System.out.println("In Because Small");
                    temp = new poss(0, new ArrayDeque<>());
                    temp.list.add(each);
                    temp.size++;
                    possList.add(temp);
                    // System.out.println(temp);
                    continue;
                }

                while (!possList.isEmpty()) {
                    temp = possList.poll();
                    if (temp.list.peekLast() < each) {
                        temp.size++;
                        temp.list.offer(each);
                    }
                    next.offer(temp);
                }

                temp = next.poll();
                size = LIS.size = temp.size;
                LIS.list = temp.list;
                possList.offer(temp);
                // System.out.println("Next Possible");
                while (!next.isEmpty()) {
                    temp = next.poll();
                    if (temp.size <= size)
                        continue;
                    else {
                        size = LIS.size = temp.size;
                        LIS.list = temp.list;
                        possList.add(temp);
                    }
                }
            }
            // System.out.println("result");
            System.out.println(LIS.size);
            while (!LIS.list.isEmpty())
                sb.append(LIS.list.poll()).append(" ");
            System.out.println(sb);
        }

    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}
