import java.io.*;
import java.util.*;

public class B2884_알람시계_화랑 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        if (min >= 45)
            min -= 45;
        else {
            min += 15;
            switch (hour){
                case 0 : hour = 23; break;
                default: hour -= 1;
            }
        }
        System.out.printf("%d %d", hour, min);
    }
}
