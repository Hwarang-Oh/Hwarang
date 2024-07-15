import java.io.*;
import java.util.*;

public class B14003_가장긴증가하는부분수열5_오화랑 {
    static class Solution {
        int N;
        int[] numList, cntList;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            this.N = Integer.parseInt(input.readLine());
            this.numList = new int[this.N];
            this.cntList = new int[this.N];
            StringTokenizer st = new StringTokenizer(input.readLine());
            numList[0] = Integer.parseInt(st.nextToken());
            cntList[0] = 1;
            for (int i = 1; i < this.N; i++) {

            }
        }
    }

    public static void main(String[] args) throws IOException {

    }

}