import java.io.*;
import java.util.*;

public class PJS_1ArrayLv4 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int [] arr = new int [num];
        StringTokenizer st = new StringTokenizer(input.readLine());

        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = arr[arr.length - 1];
        int lower = arr[arr.length - 1];

        for (int i = 0; i < num ; i++){
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < arr[arr.length - 1]) {
                lower = arr[i];
            }
        }
        System.out.printf("%d %d%n", max , lower);
        System.out.println((lower == arr[arr.length - 1]) ? -1 : max - lower);
    }
}
