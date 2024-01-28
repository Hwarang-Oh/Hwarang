import java.io.*;
import java.util.*;

public class PJS_BasicLv5 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int temp1 = Integer.parseInt(st.nextToken());
        int temp2 = Integer.parseInt(st.nextToken());
        int standDiff = Math.abs(temp1 - temp2);
        int mem;

        for (int i = 0 ; i < 5 ; i++) {
            mem = Integer.parseInt(input.readLine());
            if (Math.abs(mem - temp2) + 1 < standDiff){
                standDiff = Math.abs(mem - temp2) + 1;
            }
        }
        if (standDiff > 600) {
            System.out.println(-1);
        }else System.out.println(standDiff);
    }
}
