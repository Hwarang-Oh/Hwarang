package _202412_week5;

/**
 * IMP : https://www.acmicpc.net/problem/6010
 * IMP : 2024.12.31
 */

/**
 * IMP : Method => Arrays.binarySearch()
 * Type : 0 or Positive Integer => 해당 target을 찾음 -> 그 위치의 Index
 * Type : Negative Integer => 해당 target을 찾아내지 못함
 * ! 하지만, 그 target이 존재했다면, 어디에 들어가야 좋은 지에 대한 위치 Index를 제공함
 * ! -(n + 1) : 그 Target이 존재했다면, n Index에 들어가야 한다는 정보를 제공함 
 * 
 * IMP : Method2 => Binary Search 직접 구현 
 * Type : Binary Search에 왕도는 딱히 없다. => 항상 먹히는 공식을 외우는 것은 좋은 습관
 * ? Lower Bound OR Upper Bound?
 */

import java.io.*;
import java.util.*;

public class B6010_MusicNotes_오화랑 {
    static class Solution {
        int N, Q;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            int[] beats = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                beats[i] = beats[i - 1] + Integer.parseInt(input.readLine());
            }

            int target, position;
            for (int i = 0; i < Q; i++) {
                target = Integer.parseInt(input.readLine());
                position = Arrays.binarySearch(beats, target);
                if (position >= 0)
                    sb.append(position + 1 % 3 == 0 ? 3 : position + 1 % 3).append("\n");
                else
                    sb.append(-position - 1 % 3 == 0 ? 3 : -position - 1 % 3).append("\n");
            }
            System.out.print(sb);
        }
    }

    static class OtherSolution {
        int N, Q;
        int[] beats;
        int[] mutes = { 3, 1, 2 };

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            StringBuilder sb = new StringBuilder();

            N = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            beats = new int[N + 1];
            for (int i = 1; i <= N; i++)
                beats[i] = beats[i - 1] + Integer.parseInt(input.readLine());

            int left, right, target;
            for (int i = 0; i < Q; i++) {
                target = Integer.parseInt(input.readLine());
                left = 0;
                right = N - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (beats[mid] >= target)
                        right = mid;
                    else
                        left = mid + 1;
                }
                System.out.println("target : " + target + " Index : " + left);
                sb.append(mutes[(left + 1) % 3]).append("\n");
            }
            System.out.print(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        new OtherSolution().run();
    }
}