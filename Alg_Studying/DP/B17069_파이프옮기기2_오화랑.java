import java.io.*;
import java.util.*;

public class B17069_파이프옮기기2_오화랑 {
	static class roomInfo {
		long row, diag, col;
		boolean isWall;
		
		public roomInfo(boolean isWall) {
			super();
			this.row = 0;
			this.diag = 0;
			this.col = 0;
			this.isWall = isWall;
		}

		public roomInfo(long row, long diag, long col) {
			super();
			this.row = row;
			this.diag = diag;
			this.col = col;
			this.isWall = false;
		}
		public roomInfo() {
			this.row = 0;
			this.diag = 0;
			this.col = 0;
		}
		public long getSum() {
			return row + diag + col;
		}
		
		@Override
		public String toString() {
			return "roomInfo [row=" + row + ", diag=" + diag + ", col=" + col + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int size = Integer.parseInt(input.readLine());
		ArrayList<ArrayList<roomInfo>> Map = new ArrayList<>();
		
		for (int i = 0 ; i <= size ; i++) Map.add(new ArrayList<>()); 
		for (int i = 0 ; i <= size ; i++) {
			Map.get(0).add(new roomInfo());
			if(i >= 1) Map.get(i).add(new roomInfo());
		}
		
		for (int i = 1 ; i <= size ; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 1 ; j <= size ; j++) {
				
				if (i == 1 & j == 2) { st.nextToken(); Map.get(i).add(new roomInfo(1,0,0)); continue;}
				
				long rowSum, diagSum, colSum;
				
				if (Integer.parseInt(st.nextToken())== 1) {
					Map.get(i).add(new roomInfo(true));
				}
				
				else if (Map.get(i - 1).get(j).isWall && Map.get(i-1).get(j-1).isWall && Map.get(i).get(j-1).isWall) {
					Map.get(i).add(new roomInfo(0,0,0));
				}
				
				else if (Map.get(i - 1).get(j).isWall && Map.get(i-1).get(j-1).isWall) {
					rowSum = Map.get(i).get(j - 1).row;
					Map.get(i).add(new roomInfo(rowSum, 0, 0));
				}
				
				else if (Map.get(i - 1).get(j - 1).isWall && Map.get(i).get(j - 1).isWall) {
					colSum = Map.get(i - 1).get(j).col;
					Map.get(i).add(new roomInfo(0, 0, colSum));
				}
				else if (Map.get(i - 1).get(j).isWall && Map.get(i).get(j - 1).isWall) {
					Map.get(i).add(new roomInfo(0, 0, 0));
				}
				
				else if (Map.get(i).get(j - 1).isWall) {
					colSum = Map.get(i - 1).get(j).diag + Map.get(i - 1).get(j).col;
					Map.get(i).add(new roomInfo(0,0, colSum));
				}
				
				else if (Map.get(i - 1).get(j - 1).isWall) {
					rowSum = Map.get(i).get(j - 1).row;
					colSum = Map.get(i - 1).get(j).col;
					Map.get(i).add(new roomInfo(rowSum, 0, colSum));
				}
				
				else if (Map.get(i - 1).get(j).isWall) {
					rowSum = Map.get(i).get(j - 1).row + Map.get(i).get(j - 1).diag;
					Map.get(i).add(new roomInfo(rowSum, 0,0));
				}
				else {
					rowSum = Map.get(i).get(j - 1).row + Map.get(i).get(j - 1).diag;
					diagSum = Map.get(i - 1).get(j - 1).row + Map.get(i - 1).get(j - 1).diag + Map.get(i - 1).get(j - 1).col;
					colSum = Map.get(i - 1).get(j).diag + Map.get(i - 1).get(j).col;
					Map.get(i).add(new roomInfo(rowSum, diagSum, colSum));
				}
			}
		}
		System.out.println(Map.get(size).get(size).getSum());
	}
}
