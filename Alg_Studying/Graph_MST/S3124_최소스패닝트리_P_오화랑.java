import java.io.*;
import java.util.*;

public class S3124_최소스패닝트리_P_오화랑 {

    static ArrayList<ArrayList<int[]>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(input.readLine());

        int V, E, from, to, weight;
        for (int t = 1 ; t <= testCase ; t++) {
            st = new StringTokenizer(input.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>(V + 1);
            for (int i = 0 ; i <= V ; i++) graph.add(new ArrayList<>());
            boolean[] visited = new boolean[V + 1];
            int[] minEdge = new int[V + 1];
            Arrays.fill(minEdge, Integer.MAX_VALUE); // 최소값 갱신 위한 Max 초기화


            for (int i = 0 ; i < E ; i++) {
                st = new StringTokenizer(input.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());
                graph.get(from).add(new int[] {to, weight});
                graph.get(to).add(new int[] {from, weight});
            }
            PriorityQueue<int []> PQ = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[1], o2[1]);
                }
            });

            minEdge[1] = 0;
            long result = 0;
            int cnt = 0;
            PQ.offer(new int[] {1, minEdge[1]});
            while (true) {
                int[] temp = PQ.poll();
                if (visited[temp[0]]) continue;

                visited[temp[0]] = true;
                result += temp[1];
                if(++cnt == V) break;

                for (int[] next : graph.get(temp[0])) {
                    if (!visited[next[0]] && next[1] < minEdge[next[0]]) {
                        minEdge[next[0]] = next[1];
                        PQ.offer(next);
                    }
                }
            }
            System.out.printf("#%d %d%n", t, result);
        }
    }
}

// Test Case
// 정점의 개수 V : 100,000
// 간선의 개수 E : 200,000
// 다음 E개의 줄 : 각 간선의 정보를 나타내는 세 정수 A,B,C 주어짐
// A(from), B(to), C(weight, can be minus)
// 최소 Spanning Tree 만들기 -> 모든 정점을 연결하는 가중치가 가장 작은 그래프
// 정점의 개수는 많으나, 간선의 개수는 적은 편
// 그래도 절대적인 값이 많으니, Prim or Kruskal 알고리즘이 요구됨.
// 최적화는 해줘야 함.

/*
1
3 3
1 2 1
2 3 2
1 3 3
 */
