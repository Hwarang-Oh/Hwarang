package tempDone;

import java.io.*;
import java.util.*;

public class B13549_숨박꼭질3_오화랑_다시풀기요구됨 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int spend = 0;
        if (start >= end) {
            spend = start - end;
            System.out.println(spend);
            return;
        }
        Queue<Integer> locationList = new ArrayDeque<>();
        boolean[] visited = new boolean[2 * end + 1];
        visited[0] = true;
        visited[start] = true;
        if (start == 0) {
            if (end == 1) {
                System.out.println(end - start);
                return;
            }
            spend++;
            locationList.offer(1);
        } else
            locationList.offer(start);

        int qSize, temp;
        boolean find = false;
        while (true) {
            qSize = locationList.size();
            while (qSize > 0) {
                temp = locationList.poll();
                locationList.offer(temp);
                while (temp <= end) {
                    temp *= 2;
                    if (visited[temp])
                        break;
                    if (temp == end) {
                        find = true;
                        break;
                    }
                    locationList.offer(temp);
                    visited[temp] = true;
                }
                qSize--;
                if (find)
                    break;
            }
            if (find)
                break;

            spend++;
            qSize = locationList.size();
            while (qSize > 0) {
                temp = locationList.poll();
                if (temp - 1 == end || temp + 1 == end) {
                    find = true;
                    break;
                }
                if (!visited[temp - 1]) {
                    locationList.offer(temp - 1);
                    visited[temp - 1] = true;
                }
                if (!visited[temp + 1]) {
                    locationList.offer(temp + 1);
                    visited[temp + 1] = true;
                }
                qSize--;
            }
            if (find)
                break;
        }
        System.out.println(spend);
    }
}

// Greedy한 방식으로는 다루지 못하는 Case가 너무 많음.
/*
 * public class B13549_숨박꼭질3_오화랑 {
 * public static void main(String[] args) throws IOException {
 * BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
 * StringTokenizer st = new StringTokenizer(input.readLine());
 * int start = Integer.parseInt(st.nextToken());
 * int end = Integer.parseInt(st.nextToken());
 * int spend;
 * 
 * if (start > end) {
 * spend = start - end;
 * System.out.println(spend);
 * return;
 * }
 * System.out.println(spendToMidPoint(start, end));
 * }
 * 
 * public static int spendToMidPoint(int start, int end) {
 * if (start == end)
 * return 0;
 * 
 * int toEndMidPoint = end / 2;
 * int diff = end - (2 * toEndMidPoint);
 * int eachSpend;
 * 
 * if (start > toEndMidPoint) {
 * eachSpend = Math.min(end - start, start - toEndMidPoint);
 * return end - start > start - toEndMidPoint + diff ? start - toEndMidPoint +
 * diff : end - start;
 * 
 * } else if (start == toEndMidPoint) {
 * eachSpend = 0;
 * } else {
 * eachSpend = spendToMidPoint(start, toEndMidPoint);
 * }
 * 
 * return eachSpend + diff;
 * }
 * }
 */