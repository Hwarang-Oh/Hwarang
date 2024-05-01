import java.io.*;
import java.util.*;

public class Main2 {
    static class comp {
        int B, W, H;

        public comp(int b, int w, int h) {
            B = b;
            W = w;
            H = h;
        }

        @Override
        public String toString() {
            return "comp [B=" + B + ", W=" + W + ", H=" + H + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int num = Integer.parseInt(input.readLine());
        PriorityQueue<comp> PQ = new PriorityQueue<>(num, (o1, o2) -> Integer.compare(o2.B, o1.B));
        int b, w, h;
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(input.readLine());
            b = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            PQ.offer(new comp(b, w, h));
        }
        while (!PQ.isEmpty()) {
            System.out.println(PQ.poll());
        }

    }
}
