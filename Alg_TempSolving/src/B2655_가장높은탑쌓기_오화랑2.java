import java.io.*;
import java.util.*;

public class B2655_가장높은탑쌓기_오화랑2 {

    static class cpt {
        int N, B, W, H;

        public cpt(int n, int b, int w, int h) {
            N = n;
            B = b;
            W = w;
            H = h;
        }

        @Override
        public String toString() {
            return "cpt [N=" + N + ", B=" + B + ", W=" + W + ", H=" + H + "]";
        }

    }

    static class state {
        int sumH;
        ArrayList<Integer> Lst;

        public state(int sumH, ArrayList<Integer> Lst) {
            this.sumH = sumH;
            this.Lst = Lst;
        }

        @Override
        public String toString() {
            return "state [sumH=" + sumH + ", Lst=" + Lst + "]";
        }

    }

    static int MaxSum = Integer.MIN_VALUE;
    static int MaxSumWeight;
    static HashMap<Integer, state> Map = new HashMap<>();
    static PriorityQueue<cpt> PQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.B, o1.B));

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(input.readLine());
        int B, H, W;
        ArrayList<Integer> lst;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(input.readLine());
            B = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            PQ.offer(new cpt(i, B, W, H));
            lst = new ArrayList<>();
            Map.put(W, new state(0, lst));
        }
        Map.put(0, new state(0, new ArrayList<>())); // Base Condition

        cpt temp;
        while (!PQ.isEmpty()) {
            temp = PQ.poll();
            System.out.println(temp);
            for (int w = 1; w < temp.W; w++) {
                if (Map.containsKey(w)) {
                    Map.get(temp.W).sumH = temp.H + Map.get(w).sumH;
                    Map.get(temp.W).Lst.add(temp.N);
                    for (int i = 0; i < Map.get(w).Lst.size(); i++)
                        Map.get(temp.W).Lst.add(Map.get(w).Lst.get(i));
                    break;
                }
            }
            System.out.println(Map.get(temp.W));
            if (Map.get(temp.W).sumH > MaxSum) {
                MaxSum = Map.get(temp.W).sumH;
                MaxSumWeight = temp.W;
            }
        }
        sb.append(Map.get(MaxSumWeight).Lst.size()).append("\n");
        for (int i = Map.get(MaxSumWeight).Lst.size() - 1; i >= 0; i--) {
            sb.append(Map.get(MaxSumWeight).Lst.get(i)).append("\n");
        }
        System.out.print(sb);
    }
}
