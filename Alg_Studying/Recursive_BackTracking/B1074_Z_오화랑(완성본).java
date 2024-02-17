import java.io.*;
import java.util.*;


public class B1074_Z_오화랑 {
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int size = Integer.parseInt(st.nextToken());
		int zArraySize = 1 << size;
		
		int[][] zArray = new int[zArraySize][zArraySize];
		int rowT = Integer.parseInt(st.nextToken());
		int colT = Integer.parseInt(st.nextToken());
		Zeus(zArraySize, rowT, colT);
		System.out.println(cnt);
		
	}
	public static void Zeus(int zArraySize, int rowT, int colT) {

		if (zArraySize == 1) return;

		if(rowT < zArraySize/2 && colT < zArraySize/2)
			Zeus(zArraySize/2, rowT, colT);

		else if(rowT < zArraySize/2 && colT >= zArraySize/2) {
			cnt += zArraySize * zArraySize / 4;
			Zeus(zArraySize/2, rowT, colT - zArraySize/2);
		}

		else if(rowT >= zArraySize/2 && colT < zArraySize/2) {
			cnt += (zArraySize * zArraySize/4) * 2;
			Zeus(zArraySize/2, rowT - zArraySize/2, colT);
		}


		else {
			cnt += (zArraySize * zArraySize/4) * 3;
			Zeus(zArraySize/2, rowT - zArraySize/2, colT - zArraySize/2);
		}
	}
}
// ArraySize가 4 : ArraySize 2 -> 2 -> 2 -> 2
