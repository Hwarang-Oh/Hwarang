import java.io.*;

public class JavaLang_4 {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("60갑자를 입력하세요 : ");
		String inputYear = input.readLine();
		
		System.out.println(inputYear.substring(0,1));
		System.out.println(inputYear.substring(1,2));
	}

}
