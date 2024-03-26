import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
        while(Array[r][c] != k) {
            spend++;

        }
        System.out.println(spend);
    }
    public void makeNextArray(int rSize, int cSize) {
        ArrayList<PriorityQueue<Integer>> pqList = new ArrayList<>();
        if (rSize >= cSize) {
            for (int i = 0; i < rSize; i++) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (int j = 0; j < cSize; i++) {
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

        ArrayList<PriorityQueue<pair>> tempList = new ArrayList<>();
        int pqSize = 0;
        for (PriorityQueue<Integer> eachPQ : pqList) {

            PriorityQueue<pair> pairPQ = new PriorityQueue<>(new Comparator<pair>() {
                @Override
                public int compare(pair o1, pair o2) {
                    int diff = Integer.compare(o1.cnt, o2.cnt);
                    return diff != 0 ? diff : Integer.compare(o1.num, o2.num);
                }
            });

            int num, cnt;
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
            pqSize = Math.max(pqSize, pairPQ.size() * 2);
            tempList.add(pairPQ);
        }

        if (rSize >= cSize) {
            Array = new int[rSize][pqSize];
            int eachPQSize;
            pair tempPair;
            for (int i = 0 ; i < rSize ; i++) {
                eachPQSize = tempList.get(i).size() * 2;
                for (int j = 0 ; j < eachPQSize ; j += 2) {
                    tempPair = tempList.get(i).poll();
                    Array[i][j] = tempPair.num;
                    Array[i][j + 1] = tempPair.cnt;
                }
            }
        }
        else {
            Array = new int[pqSize][cSize];
            for (int i = 0 ; i < pqSize ; i++) {
                for (int j = 0 ; j < cSize ; j++) {
                    
                }
            }
        }
    }
}

// 크기가 3 * 3인 Array가 있다. 배열의 인덱스는 1부터 시작 -> 1초가 지날때마다 배열 연산 적용
// R -> 배열 A의 모든 행에 대한 정렬 수행 -> 행의 개수 >= 열의 개수인 경우에 적용
// C -> 배열 A의 모든 열에 대해 정렬 수행 -> 행의 개수 < 열의 개수인 경우에 적용
// 정렬 : 각각의 수가 몇 번 나왔는 지 알아야 한다. 그 다음, 수의 등장 횟수가 커지는 순으로 그러한 것이 여러가지면 수가 커지는 수내
// 정렬을 마치고 배열 A에 결과를 다시 넣어야 함. => 수와 등장 횟수를 모두 넣으면서 순서는 수가 먼저
// 3 1 1 => 3이 1번 1이 2번 => 정렬 결과 => 3 1 1 2 => 2 1 3 1 1 2
// 계속 늘어남 => 행 또는 열의 크기가 100을 넘어가는 경우에는 청므 100개를 제외한 나머지는 버린다. =>
// A[r][c]가 k가 되기 위한 최소 시간 탐색 -> 100 초가 지나도 k가 되지 않으면 -1;
