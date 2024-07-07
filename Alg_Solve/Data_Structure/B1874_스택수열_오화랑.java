import java.io.*;
import java.util.*;

/**
 * B1874_스택수열_오화랑
 * https://www.acmicpc.net/problem/1874
 */
public class B1874_스택수열_오화랑 {
    static class Solution {
        int N;
        ArrayDeque<Integer> target, numbers;
        Stack<Integer> making = new Stack<>();
        StringBuilder sb = new StringBuilder();

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            this.N = Integer.parseInt(input.readLine());
            this.target = new ArrayDeque<>(this.N);
            this.numbers = new ArrayDeque<>(this.N);
            for (int i = 0; i < this.N; i++) {
                this.numbers.offer(i + 1);
                this.target.offer(Integer.parseInt(input.readLine()));
            }
            if (makeTarget()) {
                System.out.print(sb);
            } else
                System.out.println("NO");
        }

        boolean makeTarget() {
            int currT;
            while (!target.isEmpty()) {
                currT = target.peek();
                if (making.isEmpty() || making.peek() < currT) {
                    making.push(numbers.poll());
                    sb.append("+\n");
                } else if (making.peek() == currT) {
                    making.pop();
                    target.poll();
                    sb.append("-\n");
                } else {
                    if (making.pop() == currT) {
                        sb.append("-\n");
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}