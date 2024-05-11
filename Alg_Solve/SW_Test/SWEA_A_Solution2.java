import java.io.*;
import java.util.*;

public class SWEA_A_Solution2 {
	static class house {
		int r, c, dist;

		public house(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	static ArrayList<ArrayList<PriorityQueue<house>>> Map = new ArrayList<>();
	static ArrayList<ArrayList<house>> possList = new ArrayList<>();
	static int minDist = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int testCase = Integer.parseInt(input.readLine());
		for (int t = 1; t <= testCase; t++) {

			for (int i = 0; i <= 30; i++) { // Map 초기화
				Map.add(new ArrayList<>());
				for (int j = 0; j <= 30; j++) {
					Map.get(i).add(new PriorityQueue<house>(new Comparator<house>() {
						@Override
						public int compare(house o1, house o2) {
							return Integer.compare(o2.dist, o1.dist);
						}
					}));
				}
			}

			int tNum = Integer.parseInt(input.readLine());
			int R, C, D, currDist;
			possList.add(new ArrayList<>());
			for (int i = 0; i < tNum; i++) { // Map에 집의 충전 가능범위를 깔아주기
				possList.add(new ArrayList<>());
				st = new StringTokenizer(input.readLine());
				C = Integer.parseInt(st.nextToken()) + 15;
				R = 15 - Integer.parseInt(st.nextToken());
				D = Integer.parseInt(st.nextToken());
				for (int r = R - D; r <= R + D; r++) {
					for (int c = C - D; c <= C + D; c++) {
						if (r < 0 || c < 0 || r > 30 || c > 30)
							continue;
						currDist = Math.abs(r - R) + Math.abs(c - C);
						if (currDist <= D)
							Map.get(r).get(c).add(new house(R, C, currDist));
					}
				}
			}

			for (int i = 0; i < 30; i++) { // Map의 지역 칸마다, 몇개의 집을 커버하는 지 List로 관리 (1 ~ tNum개 까지!)
				for (int j = 0; j < 30; j++) {
					if (Map.get(i).get(j).isEmpty())
						continue;
					house temp = Map.get(i).get(j).peek();
					int r = temp.r;
					int c = temp.c;
					int dist = temp.dist;
					int tempSize = Map.get(i).get(j).size();
					if (tempSize >= 1)
						possList.get(tempSize).add(new house(r, c, dist));
				}
			}
			System.out.println(possList);
			System.out.println(minDist);
		}
	}
}
