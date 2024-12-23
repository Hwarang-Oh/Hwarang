import java.io.*;
import java.util.*;

// IMP : https://www.acmicpc.net/problem/11008
// IMP : 2024.12.23
/**
 * IMP : while문과 Java의 문자열 Method replaceAll을 활용한 깔끔한 풀이도 존재함.
 * ! 그렇다고, 시간복잡도 측면에서 유리한 것은 아니지만.. 좋은 풀이 같다.
 */

public class B11008_복붙의달인_오화랑 {

    static class Solution {
        int T;
        int targetLength;
        int pasteLength;
        String target;
        String pasteWord;

        void run() throws IOException {
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            T = Integer.parseInt(input.readLine());
            for (int t = 0; t < T; t++) {
                st = new StringTokenizer(input.readLine());
                target = st.nextToken();
                pasteWord = st.nextToken();

                targetLength = target.length();
                pasteLength = pasteWord.length();
                int timeCount = 0;
                int sameCount;
                for (int i = 0; i < targetLength; i++) {
                    if (target.charAt(i) == pasteWord.charAt(0)) {
                        sameCount = paste(i);
                        if (sameCount == pasteLength)
                            timeCount++;
                        else
                            timeCount += sameCount;
                        i += (sameCount - 1);
                    } else
                        timeCount++;
                }
                sb.append(timeCount).append("\n");
            }
            System.out.println(sb);
        }

        int paste(int startLine) {
            int sameCount = 0;
            for (int i = 0; i < pasteLength; i++) {
                if (i + startLine >= targetLength)
                    break;
                if (target.charAt(i + startLine) == pasteWord.charAt(i))
                    sameCount++;
                else
                    break;
            }
            return sameCount;
        }
    }

    static class OtherSolution {
        int T;
        String target;
        String pasteWord;

        void run() throws IOException {
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            T = Integer.parseInt(input.readLine());

            for (int t = 0; t < T; t++) {
                st = new StringTokenizer(input.readLine());
                target = st.nextToken();
                pasteWord = st.nextToken();
                target = target.replaceAll(pasteWord, "1");
                sb.append(target.length()).append("\n");
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        new OtherSolution().run();
    }
}