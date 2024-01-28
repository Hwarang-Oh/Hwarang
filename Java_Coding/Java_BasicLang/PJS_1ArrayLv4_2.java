import java.io.*;

public class PJS_1ArrayLv4_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int[] num_arr = new int [num];

        int count;
        for (int i = 0 ; i < num ; i++)
            num_arr[i] = Integer.parseInt(input.readLine());
        for (int standNum : num_arr) {
            count = 0;
            for (int eachNum : num_arr) {
                if (standNum < eachNum)
                    count++;
            }
            System.out.printf("%d ", count + 1);
        }
    }
}

// 6
// 800
// 1000
// 900
// 1500
// 500
// 1000