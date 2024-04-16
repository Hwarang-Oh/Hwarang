import java.io.*;
import java.util.*;

public class B11048_이동하기_오화랑 {
	static int[][] Map;
	static int[][] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map = new int[N + 1][M + 1];
		memo = new int[N + 1][M + 1];
	
		for (int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 1 ; j <= M ; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = Map[i][j] + Math.max(memo[i - 1][j - 1], Math.max(memo[i-1][j], memo[i][j-1]));
			}
		}
		System.out.println(memo[N][M]);
	}
}
