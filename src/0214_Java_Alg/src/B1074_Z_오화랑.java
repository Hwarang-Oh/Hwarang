import java.io.*;
import java.util.*;


public class B1074_Z_오화랑 {
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int size = Integer.parseInt(st.nextToken());
		int zArraySize = 1 << size;
		int rowS = 1 << (size - 1);
		int colS = 1 << (size - 1);
		
		int[][] zArray = new int[zArraySize][zArraySize];
		int rowT = Integer.parseInt(st.nextToken());
		int colT = Integer.parseInt(st.nextToken());
		Zeus(zArraySize);
		
	}
	public static void Zeus(int zArraySize, int rowS, int colS) {
		
		Zeus(zArraySize/2, 0, 0); // 
		Zeus(zArraySize/2, 0, colS/2); //  
		Zeus(zArraySize/2, rowS/2, 0); //
		Zeus(zArraySize/2, rowS/2, colS/2); //

	}
}
