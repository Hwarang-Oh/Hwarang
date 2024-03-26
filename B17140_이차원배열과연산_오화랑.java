import java.io.*;
import java.util.*;

public class B17140_이차원배열과연산_오화랑 {
    static class pair {
        int num, cnt;
        public pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
    static int[][] Array = new int[3][3];
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0 ; i < 3 ; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0 ; j < 3 ; j++)  {
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int spend = 0;
        while(true) {
            if (r < Array.length && c < Array[0].length) {
                if (Array[r][c] == k) break;
            }
            makeNextArray(Array.length, Array[0].length);
            if (spend++ > 100) {
                spend = -1;
                break;
            }
        }
        System.out.println(spend);
    }
    public static void makeNextArray(int rSize, int cSize) {
        ArrayList<PriorityQueue<Integer>> pqList = new ArrayList<>();
        if (rSize >= cSize) {
            for (int i = 0; i < rSize; i++) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (int j = 0; j < cSize; j++) {
                    pq.offer(Array[i][j]);
                }
                pqList.add(pq);
            }
        }
        else {
            for (int i = 0 ; i < cSize ; i++) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pqList.add(pq);
            }
            for (int i = 0 ; i < rSize ; i++) {
                for (int j = 0 ; j < cSize ; j++) {
                    pqList.get(j).offer(Array[i][j]);
                }
            }
        }

        ArrayList<PriorityQueue<pair>> PairList = new ArrayList<>();
        int maxSize = 0;
        int num, cnt;
        for (PriorityQueue<Integer> eachPQ : pqList) {
            PriorityQueue<pair> pairPQ = new PriorityQueue<>(new Comparator<pair>() {
                @Override
                public int compare(pair o1, pair o2) {
                    int diff = Integer.compare(o1.cnt, o2.cnt);
                    return diff != 0 ? diff : Integer.compare(o1.num, o2.num);
                }});

            num = cnt = 0;
            while (!eachPQ.isEmpty()) {
                if (num == 0) {
                    if (num == eachPQ.peek()) eachPQ.poll();
                    else {
                        num = eachPQ.poll();
                        cnt = 1;
                    }
                } else {
                    if (num == eachPQ.peek()) {
                        eachPQ.poll();
                        cnt++;
                    } else {
                        pairPQ.offer(new pair(num, cnt));
                        num = eachPQ.poll();
                        cnt = 1;
                    }
                }
            }
            pairPQ.offer(new pair(num,cnt));
            maxSize = Math.max(maxSize, pairPQ.size() * 2);
            PairList.add(pairPQ);
            if (maxSize >= 100) maxSize = 100;
        }

        int eachPQSize;
        pair tempPair;
        if (rSize >= cSize) {
            Array = new int[rSize][maxSize];
            for (int i = 0 ; i < rSize ; i++) {
                eachPQSize = PairList.get(i).size() * 2;
                for (int j = 0 ; j < eachPQSize ; j += 2) {
                    tempPair = PairList.get(i).poll();
                    Array[i][j] = tempPair.num;
                    Array[i][j + 1] = tempPair.cnt;
                }
            }
        }
        else {
            Array = new int[maxSize][cSize];
            for (int i = 0 ; i < cSize ; i++) {
                eachPQSize = PairList.get(i).size() * 2;
                for (int j = 0 ; j < eachPQSize ; j += 2) {
                    tempPair = PairList.get(i).poll();
                    Array[j][i] = tempPair.num;
                    Array[j + 1][i] = tempPair.cnt;
                }
            }
        }
    }
}
