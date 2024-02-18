import java.util.*;
import java.io.*;

public class B1202_보석도둑_오화랑_미완2 {
	public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int jewNum = Integer.parseInt(st.nextToken());
        int bagNum = Integer.parseInt(st.nextToken());
        int maxBag = Integer.MIN_VALUE;

        PriorityQueue<int[]> jewList = new PriorityQueue<>(jewNum, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff = Integer.compare(o1[0],o2[0]);
                return diff != 0 ? diff : Integer.compare(o2[1],o1[1]);
            }});
        PriorityQueue<Integer> bagList = new PriorityQueue<Integer>(bagNum);

        int eachWeight, eachValue;
        for (int i = 0; i < jewNum; i++) {
            st = new StringTokenizer(input.readLine());
            eachWeight = Integer.parseInt(st.nextToken());
            eachValue = Integer.parseInt(st.nextToken());
            int[] temp = new int[] {eachWeight, eachValue};
            jewList.offer(temp);
        }

        int eachBag;
        for (int i = 0; i < bagNum; i++) {
        	eachBag = Integer.parseInt(input.readLine());
            maxBag = Math.max(maxBag, eachBag);
            bagList.offer(eachBag);
        }

        PriorityQueue<int[]> tempJewelList = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1],o1[1]);
            }});

        long valueCount = 0; tempJewelList.offer(new int[] {0,0});
        while (!tempJewelList.isEmpty()){
            if (bagList.isEmpty()) break;

            if (!jewList.isEmpty()) {
                if (jewList.peek()[0] < bagList.peek()) tempJewelList.offer(jewList.poll());

                else if (jewList.peek()[0] == bagList.peek()){
                    tempJewelList.offer(jewList.poll());
                    valueCount += tempJewelList.poll()[1];
                    bagList.poll();
                }
                else { // jewList.peek()[0] > bagList.peek()
                    if (jewList.peek()[0] > maxBag) jewList.poll();
                    else {
                        if (tempJewelList.size() == 1) { bagList.poll(); continue; }
                        valueCount += tempJewelList.poll()[1];
                        bagList.poll();
                    }
                }
            }
            else {
                valueCount += tempJewelList.poll()[1];
                bagList.poll();
            }
        }
        System.out.println(valueCount);
    }
}

// 논리 구조 : 가치가 높은가? -> 담아갈 수 있는가?
// Double Queue로 해결해볼까?
// JewList -> 1 100 1 80 1 70 2 60 2 50

// 2 1
// 5 10
// 100 100
// 11

// 3 2
// 1 65
// 5 23
// 3 100
// 10
// 2

// 3 100 1 65
// 가성비 순으로 나열?
// 무게 높 -> 아래 -> 가성비 높 -> 아래
// 10 2