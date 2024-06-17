import java.io.*;
import java.util.*;

public class Main {
    static class Solution {
        boolean Up, Down, Mixed;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            int past, current;
            past = current = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                current = Integer.parseInt(st.nextToken());
                if (current > past)
                    Up = true;
                else
                    Down = true;
                if (Up && Down) {
                    Mixed = true;
                    break;
                }
                past = current;
            }
            if (Mixed) {
                System.out.println("mixed");
            } else {
                if (Up)
                    System.out.println("ascending");
                else
                    System.out.println("descending");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.run();
    }
}
