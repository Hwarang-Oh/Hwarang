import java.io.*;
import java.util.*;

public class B26170_사과빨리먹기_오화랑 {
    static int[][] Map = new int[5][5];
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0 ; i < 5 ; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0 ; j < 5 ; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(input.readLine());
        int sRow = Integer.parseInt(st.nextToken());
        int sCol = Integer.parseInt(st.nextToken());
    }
}
