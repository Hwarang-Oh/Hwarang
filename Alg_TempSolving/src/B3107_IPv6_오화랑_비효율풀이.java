import java.io.*;
import java.util.*;

public class B3107_IPv6_오화랑_비효율풀이 {
    static class Solution {
        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            String[] targetIPv6 = input.readLine().split("::");
            System.out.println(Arrays.toString(targetIPv6));

            if (targetIPv6.length == 0) {
                for (int i = 1; i <= 8; i++) {
                    sb.append("0000");
                    if (i < 8)
                        sb.append(":");
                }
            }

            else if (targetIPv6.length == 1) {
                String[] mainPart = targetIPv6[0].split(":");
                int zeroCount = 8 - mainPart.length;
                int count = 1;
                for (String each : mainPart) {
                    int eachLength = each.length();
                    each = "0".repeat(4 - eachLength).concat(each);
                    sb.append(each);
                    if (count < 8)
                        sb.append(":");
                    count++;
                }
                for (int i = 1; i <= zeroCount; i++) {
                    sb.append("0000");
                    if (i < zeroCount)
                        sb.append(":");
                }
            }

            else {
                String[] leftPart = targetIPv6[0].split(":");
                String[] rightPart = targetIPv6[1].split(":");

                if (leftPart[0] == "") {
                    int zeroCount = 8 - rightPart.length;
                    int count = 1;
                    for (int i = 1; i <= zeroCount; i++) {
                        sb.append("0000").append(":");
                    }

                    for (String each : rightPart) {
                        int eachLength = each.length();
                        each = "0".repeat(4 - eachLength).concat(each);
                        sb.append(each);
                        if (count < rightPart.length)
                            sb.append(":");
                        count++;
                    }
                }

                else {
                    int zeroCount = 8 - leftPart.length - rightPart.length;
                    int count = 1;
                    for (String each : leftPart) {
                        int eachLength = each.length();
                        each = "0".repeat(4 - eachLength).concat(each);
                        sb.append(each).append(":");
                    }
                    for (int i = 1; i <= zeroCount; i++) {
                        sb.append("0000").append(":");
                    }
                    for (String each : rightPart) {
                        int eachLength = each.length();
                        each = "0".repeat(4 - eachLength).concat(each);
                        sb.append(each);
                        if (count < rightPart.length)
                            sb.append(":");
                        count++;
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.run();
    }
}