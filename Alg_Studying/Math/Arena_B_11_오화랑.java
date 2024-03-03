import java.io.*;

public class Arena_B_11_오화랑 {
    static String[] p11NumList = new String[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(input.readLine());
        p11NumList[1] = "0";
        p11NumList[2] = "11";
        p11NumList[3] = "121";
        p11NumList[4] = "1111";
        p11NumList[5] = "12221";

        String temp;
        for (int i = 6 ; i <= 10000 ; i++) {
            if (i % 2 == 0) {
                temp = p11NumList[i - 2];
                temp = temp.concat("11");
                p11NumList[i] = temp;
            }
            else {
                temp = p11NumList[i-4];
                temp = "11".concat(temp).concat("11");
                p11NumList[i] = temp;
            }
        }
        for (int t = 0 ; t < testCase ; t++) {
            int size = Integer.parseInt(input.readLine());
            sb.append(p11NumList[size]).append("\n");
        }
        System.out.print(sb);
    }
}
