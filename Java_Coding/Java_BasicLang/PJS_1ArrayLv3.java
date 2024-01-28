import java.io.*;
import java.util.*;

public class PJS_1ArrayLv3  {
    public static void main(String[] args) throws IOException  {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(st.nextToken());
        int switch_num = Integer.parseInt(st.nextToken());
        int[] switch_array = new int[num];

        st = new StringTokenizer(input.readLine());
        int target;
        for (int loop = 0 ; loop < switch_num ; loop++) {
            target = Integer.parseInt(st.nextToken());
            for (int index = 0 ; index < num ; index++) {
                if ((index + 1) % target == 0) {
                    if (switch_array[index] == 0)
                        switch_array[index] = 1;
                    else
                        switch_array[index] = 0;
                }
            }
        }
        for (int index = 0 ; index < num ; index++) {
            System.out.print(switch_array[index] + " ");
        }
    }
}
