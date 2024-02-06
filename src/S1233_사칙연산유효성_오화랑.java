import java.util.*;
import java.io.*;

public class S1233_사칙연산유효성_오화랑 {
	static int[][] tree;
	static StringTokenizer st;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		for (int tc = 1 ; tc <= 10 ; tc++) {
			Solve(tc);
		}
		System.out.println(sb);
	}
	
	public static void Solve(int tc) throws IOException {
		int nodeLength = Integer.parseInt(input.readLine());
		tree = new int[nodeLength + 1][3];
		int nodeNum;
		String tempValue;
		
		for (int i = 1 ; i <= nodeLength ; i++) {
			st = new StringTokenizer(input.readLine());
			nodeNum = Integer.parseInt(st.nextToken());
			tempValue = st.nextToken(); // 각 Node는 연산자 혹은 숫자를 입력 받는다.
			switch (tempValue) {
				case "+" : case "-" : case "*" : case "/" : tree[nodeNum][0] = 1; break; // 들어온 것이 연산자 -> 1로 저장 
				default : tree[nodeNum][0] = 2; // 들어온 것이 숫자 -> 2로 저장
			}
			
			if (nodeNum > nodeLength/2) // nodeNum이 전체 노드 수의 half보다 크면, left / right 자식 없으니 X
				continue;
			
			if (nodeLength/2 == nodeNum && nodeLength%2 == 0) { // nodeNum == 전체 노드 수의 half와 같고, nodeLength가 짝수면 => 왼쪽 자식만 존재
				tree[nodeNum][1] = Integer.parseInt(st.nextToken()); // 왼쪽 자식 index만 읽어주기
				continue;
			}
			
			tree[nodeNum][1] = Integer.parseInt(st.nextToken());
			tree[nodeNum][2] = Integer.parseInt(st.nextToken());
		}
		calCheck(tc, nodeLength);
	}
	
	public static void calCheck(int tc, int nodeLength) {
		boolean canCalculate = true;
		if (nodeLength%2 == 0) {
			canCalculate = false;
			sb.append("#").append(tc).append(" ").append(canCalculate ? 1 : 0).append("\n");
			return;
		}
		
		for (int i = (nodeLength/2) ; i >= 1 ; i--) {
			int left = tree[i][1]; // 현재 부모 입장에서 왼쪽 자식 Index
			int right = tree[i][2]; // 현재 부모 입장에서 오른쪽 자식 Index
			if ((tree[left][0] - tree[i][0]) * tree[right][0] != 2) { // => "숫자 연산자 숫자"인 경우에만, 결과가 숫자로 나올 수 있음, 따라서 (숫자V - 연산자V)*숫자V = 숫자V가 되게 구성 
				canCalculate = false; // ( 2 - 1 ) * 2 = 2 , 다른 경우에는 절대로 2로 돌아가지 않음. => 따라서 2가 안되면, 즉 숫자로 결과가 나올 수 없다면, 계산 불가! 
				break;
			}
			tree[i][0] = (tree[left][0] - tree[i][0]) * tree[right][0];
		}
		sb.append("#").append(tc).append(" ").append(canCalculate ? 1 : 0).append("\n");
	}
}
