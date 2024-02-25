import java.io.*;
import java.util.*;

public class S3124_최소스패닝트리_K_오화랑 {
    ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(input.readLine());

        int V, E, from, to, weight;
        for (int t = 1 ; t <= testCase ; t++) {
            st = new StringTokenizer(input.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            PriorityQueue<int []> edgeList = new PriorityQueue<>(E, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[2], o2[2]);
                }
            });

            int[] parents = new int[V + 1];
            for (int i = 1 ; i <= V ; i++) makeSet(parents, i);

            for (int i = 0 ; i < E ; i++) {
                st = new StringTokenizer(input.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());
                edgeList.offer(new int[] {from ,to ,weight});
            }

            int edgeCnt = 0; // 사용한 간선의 수
            long edgeWeight = 0;
            int[] eachEdge;
            while (!edgeList.isEmpty()) {
                eachEdge = edgeList.poll();
                if (findSet(parents, eachEdge[0]) == findSet(parents, eachEdge[1])) continue;
                union(parents, eachEdge[0], eachEdge[1]);
                edgeCnt++;
                edgeWeight += eachEdge[2];
                if (edgeCnt == V - 1) break;
            }
            System.out.printf("#%d %d%n", t, edgeWeight);
        }
    }
    public static void makeSet(int[] parents, int vertex) {
        parents[vertex] = vertex;
    }
    public static int findSet(int[] parents, int vertex) {
        if (parents[vertex] == vertex) return vertex;
        else return parents[vertex] = findSet(parents, parents[vertex]);
    }
    public static void union(int[] parents, int vertex1, int vertex2) {
        parents[findSet(parents, vertex2)] = findSet(parents, vertex1);
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