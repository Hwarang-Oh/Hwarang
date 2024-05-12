import java.io.*;

public class B2448_별찍기11_오화랑 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(input.readLine());
        // drawStar(size, 0);
        System.out.print(sb);
        // drawStart(size, size / 2, size / 2 + size);
    }

    public static void drawStar(int size, int startPoint1, int startPoint2) {
        if (size > 3) {

        }

        for (int i = size - 2; i <= size; i++) {
            if (i == size) {
                for (int t = 1; t < startPoint; t++)
                    sb.append(" ");
                for (int t = 1; t < size * 2; t++) {
                    if (t % 6 == 0)
                        sb.append(" ");
                    else
                        sb.append("*");
                }
            } else if (i == size - 1) {
                for (int t = 1; t < startPoint; t++)
                    sb.append(" ");
                for (int t = 1; t < size * 2; t++) {
                    if (t % 2 == 1 || t % 6 == 0)
                        sb.append(" ");
                    else
                        sb.append("*");
                }
            } else {
                for (int t = 1; t < startPoint; t++)
                    sb.append(" ");
                for (int t = 1; t < size * 2; t++) {
                    if (t % 3 == 0 && t % 6 != 0)
                        sb.append("*");
                    else
                        sb.append(" ");
                }
            }

            sb.append("\n");
        }
    }
}

// 규칙을 유추한 뒤에 별을 찍자
// N은 항상 3 * 2^k (k : 0 ~ 10) => 3, 6, 12, 24, 48, 96, 192, 384, 768, 1536, 3072
/*
 * 6
 * * 5 (6) 7
 ***** 4 5 6 7 8
 * * 3 (4 5 6 7 8) 9
 * * * *
 ***** *****
 */