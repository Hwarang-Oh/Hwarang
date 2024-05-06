import java.io.*;

public class B18921_비요뜨의징검다리건너기_오화랑 {
	static int threshold = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(input.readLine());
		for (int t = 0; t < testCase; t++) {
			int size = Integer.parseInt(input.readLine());
			if (size == 1 || size == 2)
				sb.append(1).append("\n");
			else
				sb.append(getJump(size - 2)).append("\n");
		}
		System.out.print(sb);
	}

	public static long getJump(int size) {
		if (size == 0)
			return 1;
		long result = getJump(size / 2);
		return result * result * (size % 2 + 1) % threshold;
	}
}

/*
 * 거듭제곱의 거듭제곱
 * 2^32 -> (2^16)^2
 */