import java.io.*;
import java.util.*;

public class B2170_선긋기_오화랑 {
    static class line {
        int srt, end;
        public line(int srt, int end) {
            this.srt = srt;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int nCnt = Integer.parseInt(input.readLine());
        PriorityQueue<line> lineList = new PriorityQueue<>(nCnt, (o1, o2) -> {
            int diff = Integer.compare(o1.srt, o2.srt);
            return diff != 0 ? diff : Integer.compare(o1.end, o2.end);
        });

        int s, e;
        for (int i = 0 ; i < nCnt ; i++) {
            st = new StringTokenizer(input.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            lineList.offer(new line(s, e));
        }

        line temp = lineList.poll();
        int totalLine = 0;
        int start = temp.srt;
        int last = temp.end;
        while (!lineList.isEmpty()) {
            if (lineList.peek().srt <= last) {
                if (lineList.peek().end <= last) lineList.poll();
                else {
                    temp = lineList.poll();
                    last = temp.end;
                }
            }
            else {
                totalLine += (last - start);
                temp = lineList.poll();
                start = temp.srt;
                last = temp.end;
            }
        }
        totalLine += (last - start);
        System.out.println(totalLine);
    }
}
