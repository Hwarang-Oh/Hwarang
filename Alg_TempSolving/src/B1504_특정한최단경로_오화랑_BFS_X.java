
/*
 * 최단 경로 문제와 다른 점
 * 최단 경로 -> V : 20,000 E : 300,000 (단방향)
 * v1 -> v2 로 가는 경로가 여러개일 수 있음
 * 
 * 특정한 최단 경로 -> V : 2 ~ 800 , E : 200,000 (양방향)
 * v1 ~ v2 의 경로는 단 1개
 * 1번 이동했던 간선도 다시 이동할 수 있음
 * 1번 정점 -> N번 정점 까지의 Shortest Route
 * 1 ~ v1 => v1 ~ v2 이렇게 최단을 구하면 되지 않을까? -> V1 - V2 경로를 반드시 지나야 하는 것으로 이해해버림 -> 이거 아님
 * 최대 거리 : 2억 -> 굳이 Long 할 필요는 X
 * 1 ~ v1 -> v1 ~ v2 -> v2 ~ V
 * 1 ~ V -> v1, v2을 반드시 지나야 한다.
 */

import java.io.*;
import java.util.*;

public class B1504_특정한최단경로_오화랑_BFS_X {

    static class adjV { // Adjacency List 구현
        int next, cost;

        public adjV(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    static class state { // each Move State
        int curr, dist, cond;

        public state(int curr, int dist, int cond) {
            this.curr = curr;
            this.dist = dist;
            this.cond = cond;
        }
    }

    static ArrayList<ArrayList<adjV>> graph; // Adjacency List

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        int v1, v2, c;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(input.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new adjV(v2, c));
            graph.get(v2).add(new adjV(v1, c));
        }

        st = new StringTokenizer(input.readLine());
        int haveTov1 = Integer.parseInt(st.nextToken());
        int haveTov2 = Integer.parseInt(st.nextToken());
        System.out.println(getDist(1, V, haveTov1, haveTov2));
    }

    public static int getDist(int start, int end, int haveTov1, int haveTov2) {
        PriorityQueue<state> PQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
        boolean[] visited = new boolean[end + 1];
        int[] condition = new int[end + 1];

        PQ.offer(new state(start, 0, 0)); // 1번 Node에서 진행함.
        condition[1] = 0;
        visited[1] = true;

        state temp;
        int currV, currD, currC;
        while (!PQ.isEmpty()) {
            temp = PQ.poll();
            currV = temp.curr;
            currD = temp.dist;
            if (currV == end && temp.cond == 3) {
                return currD;
            }
            for (adjV each : graph.get(currV)) {
                currC = temp.cond;
                if (visited[each.next] && (~condition[each.next] & currC) == 0)
                    continue;
                if (each.next == haveTov1) {
                    currC |= 1 << 0;
                } else if (each.next == haveTov2) {
                    currC |= 1 << 1;
                }
                visited[each.next] = true;
                condition[each.next] = currC;
                PQ.offer(new state(each.next, currD + each.cost, currC));
            }
        }
        return -1;
    }
}
