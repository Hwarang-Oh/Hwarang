import java.io.*;
import java.util.*;

public class B11286_absHeap_¿ÀÈ­¶û {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<int[]> absHeap = new PriorityQueue<int[]>(new Comparator<int []>() {
			public int compare(int[] con1, int[] con2) {
				int diff = Integer.compare(con1[0], con2[0]);
				return diff != 0 ? diff : Integer.compare(con1[1], con2[1]);
			}});
		
		int tempNum;
		int[] tempNode;
		int optNum = Integer.parseInt(input.readLine());
		
		for (int i = 0 ; i < optNum ; i++) {
			tempNum = Integer.parseInt(input.readLine());
			tempNode = new int [2];
			
			if (tempNum < 0) {
				tempNode[0] = Math.abs(tempNum);
				tempNode[1] = -1;
				absHeap.offer(tempNode);
			}
			else if (tempNum > 0) {
				tempNode[0] = tempNum;
				tempNode[1] = 1;
				absHeap.offer(tempNode);
			}
			else {
				if(!absHeap.isEmpty()) {
					tempNode = absHeap.poll();
					sb.append(tempNode[0]*tempNode[1]).append("\n");
				}
				else sb.append(0).append("\n");
			}	
		}
		System.out.println(sb);
	}
}
