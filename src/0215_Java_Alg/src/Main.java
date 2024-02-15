import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int jewNum = Integer.parseInt(st.nextToken());
        int bagNum = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> jewList = new PriorityQueue<>(jewNum, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff = Integer.compare(o2[1],o1[1]);
                return diff != 0 ? diff : Integer.compare(o1[0],o2[0]);
            }});
        ArrayList<Integer> bagList = new ArrayList<>(bagNum + 1);

        for (int i = 0; i < jewNum; i++) {
            st = new StringTokenizer(input.readLine());
            int[] temp = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            jewList.offer(temp);
        }

        for (int i = 0; i < bagNum; i++)
            bagList.add(Integer.parseInt(input.readLine()));
        bagList.add(0); // for 방지 -1 Index Problem in BT
        Collections.sort(bagList);

        int [] eachJewl = new int[2];
        int target;
        int start; int end; int mid;
        long valueCount = 0;
        
        for (int i = 0 ; i < jewNum ; i++) { // 가장 가치가 큰 보석부터 탐색한다.
            eachJewl = jewList.poll();
            target = eachJewl[0];
            start = 0 ; end = bagList.size() - 1;
            if (target > bagList.get(end)) continue;
            valueCount += eachJewl[1];
            while (start <= end) { // 가지고 있는 가방 중, 커버할 수 있는 가장 작은 용량을 사용한다. 
                mid = (start + end) / 2;
                if (bagList.get(mid) < target) start = mid + 1;
                else end = mid - 1;
            }
            bagList.remove(end + 1);
            // 쓴 가방은 버린다.
        }
        System.out.println(valueCount);
    }
}