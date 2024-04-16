import java.io.*;
import java.util.*;

public class S3289_서로소집합_오화랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(input.readLine());
        int num, optNum, parents[];

        for (int t = 1 ; t <= testCase ; t++) {
            st = new StringTokenizer(input.readLine());
            sb.append("#").append(t).append(" ");

            num = Integer.parseInt(st.nextToken());
            optNum = Integer.parseInt(st.nextToken());
            parents = new int[num + 1];
            for (int i = 1; i <= num; i++) makeSet(parents, i);

            int vertex1, vertex2;
            for (int i = 0; i < optNum; i++) {
                st = new StringTokenizer(input.readLine());
                switch (st.nextToken()) {
                    case "0":
                        vertex1 = Integer.parseInt(st.nextToken());
                        vertex2 = Integer.parseInt(st.nextToken());
                        union(parents, vertex1, vertex2);
                        break;
                    case "1":
                        vertex1 = Integer.parseInt(st.nextToken());
                        vertex2 = Integer.parseInt(st.nextToken());
                        if (findSet(parents, vertex1) == findSet(parents, vertex2)) sb.append(1);
                        else sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void makeSet(int[] parents, int vertex) {
        parents[vertex] = vertex;
    }
    public static int findSet(int[] parents, int vertex) {
        if (vertex == parents[vertex]) return vertex;
        else return parents[vertex] = findSet(parents, parents[vertex]);
    }
    public static void union(int[] parents, int vertex1, int vertex2) {
        if (findSet(parents, vertex1) == findSet(parents, vertex2)) return;
        parents[findSet(parents,vertex2)] = findSet(parents, vertex1);
    }
}
// {1} {2} {3} ... {n} => n개의 집합
// 합집합 연산 + 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산
// 연산을 수행하는 프로그램을 작성하시오.
// 첫번째 줄에 test case 수
// 두번째 줄 ~ 합집합 연산 , 같은 집합 확인 연산
// 1 a b 입력에 대해 -> 같은 집합이면 1, 아니면 0
// 각 테케 N <= 1,000,000 , M <= 100,000

