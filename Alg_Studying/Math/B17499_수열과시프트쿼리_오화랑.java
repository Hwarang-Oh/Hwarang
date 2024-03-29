import java.io.*;
import java.util.*;

public class B17499_수열과시프트쿼리_오화랑 {
    static int[] numList;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(st.nextToken());
        int opt = Integer.parseInt(st.nextToken());
        numList = new int[size];
        st = new StringTokenizer(input.readLine());
        for (int i = 0 ; i < size ; i++) numList[i] = Integer.parseInt(st.nextToken());

        int eachOpt, to, num;
        int stack = 0;
        for (int i = 0 ; i < opt ; i++) {
            st = new StringTokenizer(input.readLine());
            eachOpt = Integer.parseInt(st.nextToken());
            switch (eachOpt) {
                case 1 : {
                    to = Integer.parseInt(st.nextToken());
                    num = Integer.parseInt(st.nextToken());
                    stack %= size;
                    if (stack + to > size) numList[stack + to - size - 1] += num;
                    else numList[stack + to - 1] += num;
                    break;
                }
                case 2 : {
                    num = Integer.parseInt(st.nextToken());
                    if (stack - num < 0) stack = stack + size - num;
                    else stack -= num;
                    break;
                }
                case 3 : {
                    num = Integer.parseInt(st.nextToken());
                    if (stack + num >= size) stack = stack - size + num;
                    else stack += num;
                    break;
                }
            }
        }
        for (int i = 0 ; i < size ; i++) {
            if (stack + i >= size) sb.append(numList[stack - size + i]).append(" ");
            else sb.append(numList[stack + i]).append(" ");
        }
        System.out.print(sb);
    }
}
