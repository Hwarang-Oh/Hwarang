import java.io.*;
import java.util.*;

public class B6987_월드컵_오화랑 {
	
	static int[][] graph = new int[6][6];
	static boolean[][] visited = new boolean[6][6];
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//		sb = new StringBuilder();
		ArrayList<int[]> gameList = new ArrayList<int[]>(15);
		
		
		chooseTeam(0, 0);
		System.out.println(Arrays.deepToString(gameList));
	}
		
	public static void chooseTeam(int cnt, int start) {
		if (cnt == 2) {
		}
		
		
	}
}

