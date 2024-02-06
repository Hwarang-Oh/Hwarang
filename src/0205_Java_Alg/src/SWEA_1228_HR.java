import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1228_HR {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int length, optNum;
		int loc, num;
		LinkedList<Integer> llist;
		
		for (int i = 1 ; i <= 10 ; i++) {
			
			llist = new LinkedList<Integer>();
			length = Integer.parseInt(input.readLine());
			st = new StringTokenizer(input.readLine());
			for (int j = 0 ; j < length ; j++)
				llist.add(Integer.parseInt(st.nextToken()));
			
			optNum = Integer.parseInt(input.readLine());
			st = new StringTokenizer(input.readLine());
			for (int j = 0 ; j < optNum ; j++) {
				String opt = st.nextToken();
				loc = Integer.parseInt(st.nextToken()) - 1;
				num = Integer.parseInt(st.nextToken());
				for (int plus = 1 ; plus <= num ; plus++) {
					llist.add(loc + plus, Integer.parseInt(st.nextToken()));
				}
			}
			
			sb.append("#").append(i).append(" ");
			for (int j = 0 ; j < 10 ; j++)
				sb.append(llist.get(j)).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
