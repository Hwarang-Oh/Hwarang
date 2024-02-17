import java.util.*;
import java.io.*;

public class J1015_HR {
	static ArrayDeque<String> fStack;
	static ArrayDeque<String> bStack;
	static String currSite;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		fStack = new ArrayDeque<String>();
		bStack = new ArrayDeque<String>();
		currSite = "http://www.acm.org/";
		
		StringTokenizer st;
		String opt;
		
		while (true) {
			st = new StringTokenizer(input.readLine());
			opt = st.nextToken();
			if (st.hasMoreTokens())
				visit(st.nextToken());
			else {
				if (opt.equals("BACK"))
					back();
				if (opt.equals("FORWARD"))
					forward();
				if (opt.equals("QUIT"))
					break;
			}
		}
		System.out.println(sb);
	}
	
	public static void visit(String nextSite) {
		bStack.push(currSite);
		fStack.clear();
		currSite = nextSite;
		sb.append(nextSite).append("\n");
	}
	public static void back() {
		if (!bStack.isEmpty()) {
			fStack.push(currSite);
			currSite = bStack.pop();
			sb.append(currSite).append("\n");
		} else
			sb.append("Ignored").append("\n");
	}
	public static void forward() {
		if (!fStack.isEmpty()) {
			bStack.push(currSite);
			currSite = fStack.pop();
			sb.append(currSite).append("\n");
		} else
			sb.append("Ignored").append("\n");
	}
}
