import java.io.*;
import java.util.*;

public class PJS_BasicLv4_2 {
    public static void main(String[] args) throws IOException {
        System.out.println("월과 일을 입력하세요.");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(input.readLine());
        int month = Integer.parseInt(ST.nextToken());
        int day = Integer.parseInt(ST.nextToken());
        int totalDay = 0;
        switch (month - 1) {
            case 11 : totalDay += 30;  case 10 : totalDay += 31; case 9 : totalDay += 30;
            case 8 : totalDay += 31; case 7 : totalDay += 31; case 6 : totalDay += 30; case 5 : totalDay += 31;
            case 4 : totalDay += 30; case 3 : totalDay += 31; case 2 : totalDay += 28; case 1 : totalDay += 31;
            default : totalDay += 0;
        }
        for (int i = 1 ; i <= day ; i++) {
            totalDay++;
        }
        System.out.printf("%d월 %d일은 %d번째 날입니다.", month, day, totalDay);
    }
}
