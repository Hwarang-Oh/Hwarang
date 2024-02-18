import java.io.*;
import java.util.*;

public class B15686_치킨배달_오화랑 {
    static ArrayList<int []> houseList;
    static ArrayList<int []> chickenList;
    static int[][] selectedList;
    static int minTotalDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int size = Integer.parseInt(st.nextToken());
        int maxChicken= Integer.parseInt(st.nextToken());
        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();
        selectedList = new int[maxChicken][maxChicken];

        int tempValue; int [] tempList;
        for (int i = 1 ; i <= size ; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 1 ; j <= size ; j++) {
                tempValue = Integer.parseInt(st.nextToken());
                switch (tempValue) {
                    case 1: { tempList = new int[2];
                        tempList[0] = i;
                        tempList[1] = j;
                        houseList.add(tempList);
                        break;}
                    case 2 : { tempList = new int[2];
                        tempList[0] = i;
                        tempList[1] = j;
                        chickenList.add(tempList);}
                }
            }
        }
        calChicken(0,0, maxChicken);
        System.out.println(minTotalDist);
    }
    public static void calChicken(int start, int cnt, int maxChicken) {
        if (cnt == maxChicken) {
            minTotalDist = calDistance();
            return;
        }
        for (int i = start ; i < chickenList.size() ; i++) {
            selectedList[cnt] = chickenList.get(i);
            calChicken(i + 1, cnt + 1, maxChicken);
        }
    }

    public static int calDistance() {
        int currMin = 0; int tempDist; int eachDist;
        for (int[] eachHouse : houseList) {
            eachDist = Integer.MAX_VALUE;
            for (int[] selChicken : selectedList) {
                tempDist = Math.abs(eachHouse[0] - selChicken[0]) + Math.abs(eachHouse[1] - selChicken[1]);
                eachDist = Math.min(eachDist, tempDist);
            }
            currMin += eachDist;
            if (currMin >= minTotalDist)
                return minTotalDist;
        }
        return currMin;
    }
}

// 제발 순열 / 조합 / 부분집합 좀 잘 알아두자 => 이거 몰라서 틀리면 얼마나 억울한가?

//for (int i = 0 ; i < chickenList.size() ; i++) {
//    selectedList[cnt] = chickenList.get(i);
//    calChicken(cnt + 1, maxChicken);
//}
// -> 중복 조합! -> 중복을.. 원하지 않는다면?
//


// Chicken, House 존재
// 각 House와 Chicken의 최단 거리 => 치킨거리
// 치킨 거리의 합이 최소가 되게 하는 최대 치킨집 한계 M
// N^2 크기의 도시 집의 개수는 2N개를 넘지 않으며, 치킨 집의 개수는 13개보다 작음
// 13개 보다 작다는 것에 주목할 필요가 있음 => Combination 문제의 가능성 존재
// 과연 모든 좌표를 활용해야 할까?? => 집과 치킨집의 좌표를 구한 다음
// 치킨 집 중 M개를 선택한 다음 치킨 거리를 구하고 => 최소 치킨거리?
// ㅁ ㅁ ㅁ ( m = 3 )
//