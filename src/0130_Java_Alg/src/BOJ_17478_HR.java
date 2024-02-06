import java.io.*;
import java.lang.*;

public class BOJ_17478_HR {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int recurNum = Integer.parseInt(input.readLine());
		int cnt = 0;
		wordMake(recurNum,cnt);
	}
	public static void wordMake(int recurNum, int cnt) {
		StringBuilder sb = new StringBuilder();
		if (cnt == 0)
			System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		if (cnt == recurNum) {
			sb = new StringBuilder();
			for (int i = 0; i < cnt ; i++) sb.append("____");
			sb.append("\"재귀함수가 뭔가요?\"\n");
			for (int i = 0; i < cnt ; i++) sb.append("____");
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			for (int i = 0; i < cnt ; i++) sb.append("____");
			sb.append("라고 답변하였지.");
			System.out.println(sb.toString());
			return;
		}
		
		sb = new StringBuilder();
		sb.append(words(cnt));
		System.out.println(sb.toString());
		
		cnt++; 
		wordMake(recurNum, cnt);
		
		sb = new StringBuilder();
		for (int i = 0; i < cnt-1 ; i++) sb.append("____");
		sb.append("라고 답변하였지.");
		System.out.println(sb.toString());
	}
	
	
	public static String words(int cnt) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < cnt ; i++) sb.append("____");
		sb.append("\"재귀함수가 뭔가요?\"\n");
		
		for (int i = 0; i < cnt ; i++) sb.append("____");
		sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		
		for (int i = 0; i < cnt ; i++) sb.append("____");
		sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		
		for (int i = 0; i < cnt ; i++) sb.append("____");
		sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		
		return sb.toString();
	}
}
