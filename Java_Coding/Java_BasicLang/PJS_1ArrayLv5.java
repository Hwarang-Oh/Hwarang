import java.io.*;
import java.util.*;

public class PJS_1ArrayLv5 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int totalTime = Integer.parseInt(input.readLine());
        int [] speed = new int [totalTime];
        int [] height = new int [totalTime];

        StringTokenizer st1 = new StringTokenizer(input.readLine());
        StringTokenizer st2 = new StringTokenizer(input.readLine());
        for (int i = 0 ; i < totalTime ; i++){
            speed[i] = Integer.parseInt(st1.nextToken());
            height[i] = Integer.parseInt(st2.nextToken());
        }
        int accSpeed = 0;
        int result = -1;

        for (int i = 2 ; i < totalTime ; i++) {

            if (i >= 2 && (height[i-2] - height[i]) >= 2000) {
                for (int j =  i - 2 ; j < i ; j++) {
                    accSpeed += speed[j];
                }
                if (accSpeed >= 2200){
                    result = i + 1;
                    break;
                }
                accSpeed = 0;
            }

            if (i >= 3 && (height[i-3] - height[i]) >= 3000) {
                for (int j =  i - 3 ; j < i ; j++) {
                    accSpeed += speed[j];
                }
                if (accSpeed >= 3000){
                    result = i + 1;
                    break;
                }
                accSpeed = 0;
            }

            if (i >= 4 && (height[i-4] - height[i]) >= 4000) {
                for (int j =  i - 4 ; j < i ; j++) {
                    accSpeed += speed[j];
                }
                if (accSpeed >= 3600){
                    result = i + 1;
                    break;
                }
                accSpeed = 0;
            }
        }
        System.out.println(result);
    }
}

/*
8
700 900 900 950 850 800 800 600
8000 9000 8000 7000 6000 5000 6500 6000

8
800 900 1000 1100 800 900 800 600
8000 9000 8000 7000 6000 8000 7500 7000

8
700 900 800 600 800 1000 1300 600
8000 9000 8000 7000 7500 7000 7500 5000

8
700 900 600 600 500 900 800 600
8000 9000 8000 7000 7000 7000 7500 7000
 */