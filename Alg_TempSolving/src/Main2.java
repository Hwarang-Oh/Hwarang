import java.io.*;
import java.util.*;

public class Main2 {
    static class PossRun {
        long start, end;

        public PossRun(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "[ Start : " + this.start + " End : " + this.end + " ]";
        }
    }

    static class Solution {
        int N;
        long T;
        ArrayList<PossRun> runningList;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st1 = new StringTokenizer(input.readLine());
            StringTokenizer st2 = null;
            this.N = Integer.parseInt(st1.nextToken());
            this.T = (long) (Double.parseDouble(st1.nextToken()) * 10000);
            this.runningList = new ArrayList<>(this.N);

            st1 = new StringTokenizer(input.readLine());
            st2 = new StringTokenizer(input.readLine());
            long location, speed;
            long start, end;
            for (int i = 0; i < this.N; i++) {
                location = Long.parseLong(st1.nextToken());
                speed = Long.parseLong(st2.nextToken());

                long delta = speed * this.T;

                if (speed > 0 && this.T > 0 && delta / speed != this.T) {
                    // Handle overflow by setting to max/min values
                    start = Long.MIN_VALUE;
                    end = Long.MAX_VALUE;
                } else {
                    start = location * 10000 - delta;
                    end = location * 10000 + delta;
                }

                start = start < 1 ? 1 : start;
                end = end > 1_000_000_000L * 10000 ? 1_000_000_000L * 10000 : end;
                runningList.add(new PossRun(start, end));
            }
            System.out.println(checkMake());
        }

        int checkMake() {
            long totalStart = 1;
            long totalEnd = 1_000_000_000L * 10000;
            for (PossRun each : runningList) {
                if (each.start > totalStart)
                    totalStart = each.start;
                if (each.end < totalEnd)
                    totalEnd = each.end;
                if (totalStart > totalEnd) {
                    return 0;
                }
            }
            System.out.println(totalStart / 10000.0);
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.run();
    }
}
