import java.io.*;
import java.util.*;

public class B1629_곱셈_오화랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int modN = Integer.parseInt(st.nextToken());

        
    }

    public static getMod(int N, int start, int end int modN) {
        if (start == end) {
            return 
        }

        int mid = (start + end) / 2
        getMod(N, start, mid, modN);
        getMod(N, mid + 1, end, modN)
    }
}
