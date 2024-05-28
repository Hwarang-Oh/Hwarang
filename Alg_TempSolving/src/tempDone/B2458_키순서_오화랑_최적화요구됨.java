package tempDone;

import java.io.*;
import java.util.*;

public class B2458_키순서_오화랑_최적화요구됨 {
    static class compared {
        ArrayList<Integer> bigger;
        ArrayList<Integer> smaller;

        public compared(ArrayList<Integer> bigger, ArrayList<Integer> smaller) {
            this.bigger = bigger;
            this.smaller = smaller;
        }

        @Override
        public String toString() {
            return "compared [bigger=" + bigger + ", smaller=" + smaller + "]";
        }
    }

    static ArrayList<compared> Compared;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int sNum = Integer.parseInt(st.nextToken());
        int cNum = Integer.parseInt(st.nextToken());
        Compared = new ArrayList<>(sNum + 1);
        for (int i = 0; i < sNum + 1; i++) {
            Compared.add(new compared(new ArrayList<>(), new ArrayList<>()));
        }

        int bigOne, smallOne;
        for (int i = 0; i < cNum; i++) {
            st = new StringTokenizer(input.readLine());
            smallOne = Integer.parseInt(st.nextToken());
            bigOne = Integer.parseInt(st.nextToken());
            Compared.get(smallOne).bigger.add(bigOne);
            Compared.get(bigOne).smaller.add(smallOne);
        }

        boolean[] visited1, visited2;
        int eachCount;
        int possCount = 0;
        for (int i = 1; i <= sNum; i++) {
            visited1 = new boolean[sNum + 1];
            visited2 = new boolean[sNum + 1];
            eachCount = 0;
            largerDFS(i, visited1);
            smallerDFS(i, visited2);
            for (int j = 1; j <= sNum; j++) {
                if (visited1[j] || visited2[j])
                    eachCount++;
            }
            if (eachCount == sNum - 1)
                possCount++;
        }
        System.out.println(possCount);
    }

    public static void largerDFS(int each, boolean[] visited) {
        for (int eachBig : Compared.get(each).bigger) {
            if (visited[eachBig])
                continue;
            largerDFS(eachBig, visited);
            visited[eachBig] = true;
        }
    }

    public static void smallerDFS(int each, boolean[] visited) {
        for (int eachSmall : Compared.get(each).smaller) {
            if (visited[eachSmall])
                continue;
            smallerDFS(eachSmall, visited);
            visited[eachSmall] = true;
        }
    }
}