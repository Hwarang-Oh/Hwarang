import java.util.*;
import java.io.*;

public class B1202_보석도둑_오화랑 {
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
        
//        ArrayList<Integer> bagList = new ArrayList<Integer>(bagNum);
        PriorityQueue<Integer> bagUpList = new PriorityQueue<Integer>(bagNum);
        PriorityQueue<Integer> bagDownList = new PriorityQueue<Integer>(bagNum, Collections.reverseOrder());

        for (int i = 0; i < jewNum; i++) {
            st = new StringTokenizer(input.readLine());
            int[] temp = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            jewList.offer(temp);
        }

        int eachBag;
        for (int i = 0; i < bagNum; i++) {
        	eachBag = Integer.parseInt(input.readLine());
        	bagUpList.offer(eachBag);
        	bagDownList.offer(eachBag);
        }
        
        
        long valueSum = 0; int[] target; int temp;
        for (int i = 0 ; i < jewNum ; i++) {
        	target = jewList.poll();
        	if (target[0] > bagDownList.peek()) continue; // 가방 무게들의 최대값보다 크면 훔치기 X
        	if (target[0] <= bagUpList.peek()) bagUpList.poll(); // 가방 무게들의 최소값보다 작으면 훔치기 O by 최소 가방
        	
        	temp = bagDownList.poll(); // 가방 무게들 중 최대값을 잠깐 빼놓음
        	if (target[0] <= bagDownList.peek())  // 두번째 최대값보다 작거나 같다면, 가방 무게의 최대값보단 작으니 가방 최대는 바뀌지 않음
        		bagDownList.offer(temp); // 다시 넣어줌. 두번째 최대값보다 컸다면, 최대값을 써야 해서 뺀 채로 다음 보석 탐색 시작
        	
        	valueSum += target[1];
        	bagNum--;
        	if (bagNum == 0) break; // 가방을 다쓰면 break -> 보석을 다 탐색해도 break
        }
        System.out.println(valueSum);
    }
}
