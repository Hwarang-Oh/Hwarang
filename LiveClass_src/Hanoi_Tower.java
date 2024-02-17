import java.util.*;
import java.io.*;

public class Hanoi_Tower {
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(input.readLine());
		hanoi(cnt, 1, 2, 3);
		System.out.println(result.toString());
	}
	public static void hanoi(int cnt, int from, int temp, int to) {
		if (cnt == 0) return;
		hanoi(cnt - 1, from, to, temp);
		result.append(cnt + " : " + from + " -> " + to + "\n");
		hanoi(cnt - 1, temp, from, to);
		if(cnt > 1)hanoi(cnt - 1, from, to, temp);
		result.append(cnt + " : " + from + " -> " + to + "\n");
		if(cnt > 1)hanoi(cnt - 1, temp, from, to);
		
	}
}
