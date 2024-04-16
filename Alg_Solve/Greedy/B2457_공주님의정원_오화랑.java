import java.io.*;
import java.util.*;

public class B2457_공주님의정원_오화랑 {
	static class flower {
		int mon1, day1, mon2, day2;
		
		public flower(int mon1, int day1, int mon2, int day2) {
			super();
			this.mon1 = mon1;
			this.day1 = day1;
			this.mon2 = mon2;
			this.day2 = day2;
		}
		
		@Override
		public String toString() {
			return "flower [mon1=" + mon1 + ", day1=" + day1 + ", mon2=" + mon2 + ", day2=" + day2 + "]";
		}
	}
	static PriorityQueue<flower> fList;
	static PriorityQueue<flower> tempList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int fNum = Integer.parseInt(input.readLine());
		fList = new PriorityQueue<>(fNum, new Comparator<flower>() {
			@Override
			public int compare(flower o1, flower o2) {
				int diff = Integer.compare(o1.mon1, o2.mon1);
				return diff != 0 ? diff : Integer.compare(o1.day1, o2.day1);
			}});
		
		tempList = new PriorityQueue<>(fNum, new Comparator<flower>() {
			@Override
			public int compare(flower o1, flower o2) {
				int diff = Integer.compare(o2.mon2, o1.mon2);
				return diff != 0 ? diff : Integer.compare(o2.day2, o1.day2);
			}});
		
		for (int i = 0 ; i < fNum ; i++) {
			st = new StringTokenizer(input.readLine());
			int mon1 = Integer.parseInt(st.nextToken());
			int day1 = Integer.parseInt(st.nextToken());
			int mon2 = Integer.parseInt(st.nextToken());
			int day2 = Integer.parseInt(st.nextToken());
			fList.offer(new flower(mon1, day1, mon2, day2));
		}
		int startM, startD, fCount;
		startM = 3; startD = 1; fCount = 0;
		
		while(!fList.isEmpty()) {
			if (fList.peek().mon1 < startM) tempList.offer(fList.poll());
			else if (fList.peek().mon1 == startM && fList.peek().day1 <= startD) tempList.offer(fList.poll());
			else {
				if(tempList.isEmpty()) { System.out.println(fCount = 0); ; return; }
				startM = tempList.peek().mon2;
				startD = tempList.poll().day2;
				fCount++;
				tempList.clear();
				if (startM >= 12) { System.out.println(fCount); return; }
			}
			if (fList.isEmpty()) fList.offer(new flower(13,1,13,2));
		}
	}
}
// 바로 0이 되는 경우를 조심해야 함!!

// N개의 꽃은 모두 같은 해에 피어서 같은 해에 진다. 하나의 꽃은 피는 날과 지는 날이 정해져 있다.
// 5.8 ~ 6.13 => 피어있는 시간 5.8 ~ 6.12
// 4 6 9 11 -> 30일, 1 3 5 7 8 10 12 -> 31일, 2 -> 28일
// 3월 1일 ~ 11월 30일까지 매일 꽃이 한가지 이상 피어있도록 한다.
// 정원이 넓지 않으므로 정원에 심는 꽃들의 수를 가능한 적게 한다. -> 겹치는 것은 문제가 안되지만, 최대한 적은 꽃을 사용
