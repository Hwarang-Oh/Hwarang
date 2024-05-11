import java.io.*;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13260_문자열자르기_오화랑 {

    static PriorityQueue<Integer> cutPoint = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int size = Integer.parseInt(st.nextToken());
        int cNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());
        for (int i = 0 ; i < cNum ; i++) {
            cutPoint.offer(Integer.parseInt(st.nextToken()));
        }

    }
    public static int getCost(int start, int end, ArrayDeque<Integer> cutList) {
        int cutPoint = start;
        int range = end - start;
        int lLeft = 0;
        while(!cutList.isEmpty()) {
            lLeft += cutList.peek() - cutPoint;
        }
        return 0;
    }
}
