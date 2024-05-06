import java.io.*;
import java.util.*;

public class TempJava {
    static class meeting {
        int sT, eT;

        public meeting(int sT, int eT) {
            this.sT = sT;
            this.eT = eT;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int mNum = Integer.parseInt(input.readLine());
        /*
         * PriorityQueue<meeting> meetList = new PriorityQueue<>(mNum,
         * Comparator.comparingInt((meeting meet) -> meet.eT).thenComparingInt(meet ->
         * meet.sT));
         */
        ArrayList<meeting> meetList = new ArrayList<>(mNum);
        for (int i = 0; i < mNum; i++) {
            st = new StringTokenizer(input.readLine());
            meetList.add(new meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

        }
        meetList.sort(Comparator.comparingInt((meeting meet) -> meet.eT).thenComparingInt(meet -> meet.sT));

        int meetCount = 0;
        int nextStartTime = 0; // 2,147,483,647 > 2,147,483,647 - 1 (MAX)
        for (meeting each : meetList) {
            if (each.sT >= nextStartTime) {
                nextStartTime = each.eT;
                meetCount++;
            }
        }
        System.out.println(meetCount);
    }
}
/*
 * PriorityQueue<meeting> meetList = new PriorityQueue<>(
 * (o1, o2) -> Integer.compare(o1.eT, o2.eT) != 0 ? Integer.compare(o1.eT,
 * o2.eT)
 * : Integer.compare(o1.sT, o2.sT));
 */
/*
 * PriorityQueue<meeting> meetings = new PriorityQueue<>((o1, o2) -> {
 * int diff = Integer.compare(o1.eT, o2.eT);
 * return diff != 0 ? diff : Integer.compare(o1.sT, o2.sT);
 * });
 */