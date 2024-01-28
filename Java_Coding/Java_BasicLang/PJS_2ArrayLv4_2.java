import java.io.*;
import java.util.StringTokenizer;

public class PJS_2ArrayLv4_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(input.readLine());
        int[][] web = new int[size][size];

        int[][] search = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (int i = 0 ; i < size ; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0 ; j < size ; j++) {
                web[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        boolean visit_1 = false;
        int maxCount = 1;
        int mcX = 0; int mcY = 0;

        for (int i = 0 ; i < size ; i++) {
            for (int j = 0 ; j < size ; j++) {
                if (web[i][j] == 0) {
                    count = 1;
                    for (int[] eachSearch : search) {
                        int tempX = i;
                        int tempY = j;
                        for (int s = 0 ; s < size ; s++) {
                            tempX += eachSearch[0];
                            tempY += eachSearch[1];
                            if (tempX >= size | tempY >= size | tempX < 0 | tempY < 0)
                                break;
                            if (web[tempX][tempY] == 1 & !visit_1)
                                visit_1 = true;
                            else if (web[tempX][tempY] == 1 & visit_1)
                                break;
                            else {
                                visit_1 = false;
                                count++;
                            }
                        }
                    }
                    if (count > maxCount) {
                        maxCount = count;
                        mcX = i;
                        mcY = j;
                    }

                }
            }
        }
        System.out.println(maxCount);
        System.out.printf("%d, %d",mcX,mcY);
    }
}