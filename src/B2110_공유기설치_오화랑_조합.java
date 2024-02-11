import java.io.*;
import java.util.*;

public class B2110_공유기설치_오화랑_조합 {
    static int houseNum;
    static int routerNum;
    static int[] houseList;
    static int[] selected;
    static int TotalMaxMinDist = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        houseNum = Integer.parseInt(st.nextToken());
        routerNum = Integer.parseInt(st.nextToken());
        houseList = new int [houseNum];
        selected = new int [routerNum];

        for (int i = 0 ; i < houseNum ; i++)
            houseList[i] = Integer.parseInt(input.readLine());
        Arrays.sort(houseList);

        System.out.println(Arrays.toString(houseList));
        check(0, 0);

        System.out.println(TotalMaxMinDist);
    }
    public static void check(int start, int cnt) {
        if (cnt == routerNum) {
            TotalMaxMinDist = Math.max(TotalMaxMinDist, calDist());
            return;
        }
        for (int i = start ; i < houseNum ; i++) {
            selected[cnt] = houseList[i];
            check(i + 1, cnt + 1);
        }
    }
    public static int calDist() {
        int currMinDist = Integer.MAX_VALUE;
        for (int i = 1 ; i < routerNum ; i++) {
            currMinDist = Math.min(currMinDist, selected[i] - selected[i - 1]);
            if (currMinDist <= TotalMaxMinDist)
                return currMinDist;
        }
        return currMinDist;
    }
}

// 공유기의 개수 만큼 조합으로 뽑을 수 있을까?
// 공유기의 Combination은 N개 <= 20만개까지 가능하다 => 시간초과 100%
// 첫번째 풀이인 조합으로는 시간이 초과될 수 밖에 없음.
// Input이 많이 들어와도 어떻게 할 수 있는 방법은 없을까?
// 가장 최대의 최소거리를 가지기 위해서는.. => 정말 균등하게 공유기가 분포해야 함!
// 일단 완전 탐색으로 문제를 풀면, 시간초과가 날 수 밖에 없음

// 2 <= N <= 200,00 HouseList
// 2 <= C <= N CList
// N개의 줄에 이어서, 집의 좌표 제공

// 집 5개 , 공유기 3개 => 가장 인접한 두 공유기의 최대 거리?
// 1 2 8 4 9 -> 1 2 4 8 9 -> 1 4 9 -> 1 ~ 4 가장 인접 & 최대 거리 3

// 5 3 -> 1 2 8 4 9 => 1 2 4 8 9 => 1 4 8 or 1 4 9
// -> 1 2 4 1 => 1 1 2 4
// 10 4 -> 1 2 3 4 5 15 20 37 80 90 => 1 20 37 90