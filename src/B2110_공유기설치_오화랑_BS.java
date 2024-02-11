import java.util.*;
import java.io.*;

public class B2110_공유기설치_오화랑_BS {
    static int houseNum;
    static int routerNum;
    static int[] houseList;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        houseNum = Integer.parseInt(st.nextToken());
        routerNum = Integer.parseInt(st.nextToken());
        houseList = new int[houseNum];

        for (int i = 0; i < houseNum; i++)
            houseList[i] = Integer.parseInt(input.readLine());
        Arrays.sort(houseList);

        int start = 1 ; int end = houseList[houseNum - 1] - houseList[0];
        int midPoint = 0;

        while (start <= end) { // 최소 간격이 커질 수록 -> 설치할 수 있는 공유기는 적어짐
            midPoint = (start + end) / 2;

            if (getRouterNum(midPoint) >= routerNum) start = midPoint + 1;
            else end = midPoint - 1;
        }
        System.out.println(end);
    }
    public static int getRouterNum(int midPoint) {
        int recentHouse = houseList[0];
        int routerCount = 1;
        for (int i = 1 ; i < houseNum ; i++) { // 2번째 ~ 끝까지
            if (houseList[i] - recentHouse >= midPoint) {
                recentHouse = houseList[i];
                routerCount++;
            }
        }
        return routerCount;
    }
}
/*
5 3
1
2
8
4
9
 */


/*
공유기 설치 문제 : 최소 거리를 미리 설정 => 1, 2, 3, 4, 5 ...
=> 최소 거리에 근거해서 공유기가 설치되는 개수를 구함
=> 설치되는 개수가 M개와 같으면 해당 최소거리를
 */
// 1 2 3 4 5 15 21 37 80 90
// => 1 15 21 37 80 90 -> 6개 설치 가능 (최소 거리 5)
// => 문제는 최소 거리 6으로 해도 6개 설치 가능함.
// 최소 거리가 늘어날 수록 -> 설치 가능 개수는 적어짐
// 처음으로 설치 가능 개수가 Target보다 작아질 때 채택

// 우선순위 Queue를 활용해서 선택을 하는 방법은 조합과 크게 다른 점이 없음.

//static PriorityQueue<Integer> routerSelected = new PriorityQueue<>();
//public static int[] getNextRoute(int start, int end) { // 1st -> 처음 / 끝을 설정한 상태에서 최적값
//    int target = (houseList[start] + houseList[end]) / 2;
//    int tempS = start ; int tempE = end; int midPoint = (tempS + tempE) / 2;
//    while (tempS <= tempE) {
//        midPoint = (tempS + tempE) / 2;
//        if (houseList[midPoint] < target) tempS = midPoint + 1;
//        else if (houseList[midPoint] >= target) tempE = midPoint - 1;
//    }
//    if(target - houseList[tempE] > houseList[tempE + 1] - target)
//        tempE++;
//    midPoint = tempE;
//    int currMin = Math.min(houseList[midPoint] - houseList[start], houseList[end]- houseList[midPoint]);
//    int[] currInfo = {currMin, midPoint};
//    return currInfo;
//}



//10 4
//        1
//        2
//        3
//        4
//        5
//        15
//        20
//        37
//        80
//        90


// 이진 탐색?
// 1 3 5 7 9 11 13 15 17 19
// 5를 찾아라 ->