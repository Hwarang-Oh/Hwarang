import java.io.*;
import java.util.*;

// IMP : https://www.acmicpc.net/problem/15721
// IMP : 2024.12.23

// 0 1 2 3
// 0 1 0 1 0 0 1 1 (45, 78) 6
// 0 1 0 1 0 0 0 1 1 1 (456, 789) 7
// 0 1 0 1 0 0 0 0 1 1 1 1 (4567, 891011) 8
// 0 1 0 1 0 0 0 0 0 1 1 1 1 1 (9)
// 0 1 0 1 0 0 0 0 0 0 1 1 1 1 1 1 (10)

public class B15721_번데기_오화랑 {
    public static class Solution {
        int P;
        int targetCount;
        int targetType;
        int bCount;
        int dCount;
        boolean complete;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            P = Integer.parseInt(input.readLine());
            targetCount = Integer.parseInt(input.readLine());
            targetType = Integer.parseInt(input.readLine());
            int stage = 1;

            while (!complete) {
                stageCount(stage++);
            }
            System.out.println(getTargetMember());
        }

        void stageCount(int stage) {
            int stageSpeak = (stage + 1) * 2 + 4;
            int stageBranch = stage + 5;
            for (int i = 0; i < stageSpeak; i++) {
                if (i == 0)
                    bCount++;
                else if (i == 1)
                    dCount++;
                else if (i == 2)
                    bCount++;
                else if (i == 3)
                    dCount++;
                else if (i < stageBranch)
                    bCount++;
                else
                    dCount++;

                if (madeCheck()) {
                    complete = true;
                    break;
                }
            }
        }

        boolean madeCheck() {
            if (targetType == 0)
                return targetCount == bCount;
            else
                return targetCount == dCount;
        }

        int getTargetMember() {
            int allCount = bCount + dCount;
            if (allCount % P == 0)
                return P - 1;
            return allCount % P - 1;
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
