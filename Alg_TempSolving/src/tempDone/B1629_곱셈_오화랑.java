package tempDone;

import java.io.*;
import java.util.*;

public class B1629_곱셈_오화랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        long N = Integer.parseInt(st.nextToken());
        long T = Integer.parseInt(st.nextToken());
        long modN = Integer.parseInt(st.nextToken());
        System.out.println(getMod(N, T, modN));
    }

    public static long getMod(long N, long T, long modN) {
        long res;
        if (T == 1)
            return N % modN;

        else if (T % 2 == 0) {
            res = getMod(N, T / 2, modN);
            return (res * res) % modN;
        }

        else {
            res = getMod(N, (T - 1) / 2, modN);
            return ((res * res) % modN * N) % modN;
        }
    }
}
