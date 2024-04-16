import java.io.*;
import java.util.*;

public class B11724_연결요소의개수_오화랑 {
    static Stack<Integer> gStack = new Stack<Integer>();
    static boolean[] visited;
    static int compCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int vertexNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int[][] graph = new int[vertexNum + 1][vertexNum + 1];
        visited = new boolean[vertexNum + 1];

        int from, to;
        for (int i = 0 ; i < edgeNum ; i++) {
            st = new StringTokenizer(input.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        dfs(graph, 1);
        for (int left = 2 ; left < graph.length ; left++) {
            if(!visited[left]) dfs(graph, left);
        }

        System.out.println(compCnt);
    }
    public static void dfs(int[][] graph, int start) {
        if (gStack.isEmpty()) compCnt++;
        gStack.add(start);
        visited[start] = true;

        for (int next = 1 ; next < graph.length ; next++) {
            if ( graph[start][next] == 1 && !visited[next])
                dfs(graph, next);
        }
        gStack.pop();
    }
}
