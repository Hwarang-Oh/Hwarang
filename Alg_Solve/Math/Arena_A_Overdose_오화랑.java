import java.io.*;
import java.util.*;

public class Arena_A_Overdose_오화랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(input.readLine());
        for (int t = 0 ; t < testCase ; t++) {
            int back = 0;
            int mid = 0;
            int front = 0;
            int count = 0;
            String temp = input.readLine();
            for (int i = 0 ; i < temp.length() ; i++) {
                switch (temp.charAt(i )) {
                    case '0': mid = 0; back = i; break;
                    case '1': mid = 1; back = i; break;
                }
                count++;
            }
            front = count - 1 - back;
            sb.append(overdose(back, mid, front)).append("\n");
        }
        System.out.print(sb);
    }
    public static int overdose(int bNum, int middle, int fNum) {
        if (bNum == 0) {
            if (middle == 0 && fNum == 0) return 0;
            else return 1;
        }
        else {
            if (middle == 0) {
                if (bNum % 2 == 0 && fNum == 0) return 0;
                else if (bNum % 2 == 0) return 1;
                else if (bNum % 2 == 1 && fNum == 0) return 1;
                else return 0;
            }
            else {
                if (bNum % 2 == 0) return 1;
                else return 0;
            }
        }
    }
}
// 0! = 1, 1! = 1;
// !0 = 1, !1 = 0;
// !!n!! = n! -> n!! -> !n!! -> !!n!!;
