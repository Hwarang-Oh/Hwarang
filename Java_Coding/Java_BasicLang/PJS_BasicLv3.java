import java.io.*;

public class PJS_BasicLv3 {
	public static void main(String[] args) throws IOException {
		// DigitTest1
		for (int num = 1 ; num <= 15 ; num++) {
			System.out.printf("%d\t", num);
			if (num == 5 || num == 9 || num == 12 || num == 14)
				System.out.println();
			switch (num) {
			case 14 :
				System.out.printf(" \t");
			case 12 :
				System.out.printf(" \t");
			case 9 :
				System.out.printf(" \t");
			case 5 :
				System.out.printf(" \t");
			}
		}
		System.out.println();
		// DigitTest2
		for (int num = 1 ; num <= 17 ; num++) {
			System.out.printf("%d\t", num);
			if (num == 5 || num == 8 || num == 9 || num == 12)
				System.out.println();
			switch (num) {
				case 8:
					System.out.print(" \t");
				case 5: case 9:
					System.out.print(" \t");
			}
		}
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르시오"); System.out.println();
		System.out.println("1.5판 3승"); System.out.println("2.3판 2승"); System.out.println("3.1판 1승");
		System.out.println(); System.out.print("번호를 입력하세요 >> ");
		int gameMode = Integer.parseInt(input.readLine());
		int cpuToWin = 1;
		int humanToWin = 1;
		int maxGame = 1;

		String humanChoice;
		int cpuChoice;

		System.out.print("번호를 입력하세요. >> ");
		switch (gameMode) {
		case 1 :
			cpuToWin = humanToWin = 3;
			maxGame = 5;
			break;
		case 2 :
			cpuToWin = humanToWin = 2;
			maxGame = 3;
		}
		
		while (maxGame > 0) {
			System.out.print("가위/바위/보 중 하나 입력 : ");
			humanChoice = input.readLine();
			cpuChoice = (int)(Math.random()*3) + 1;

			if (humanChoice.equals("가위")) {
				System.out.printf("사용자 : %s ",humanChoice);
				switch (cpuChoice) {
				case 1 :
					System.out.printf("컴퓨터 : %s => 비겼습니다.\n", "가위");
					break;
				case 2 :
					System.out.printf("컴퓨터 : %s => 졌습니다.\n", "바위");
					cpuToWin--; break;
				case 3 :
					System.out.printf("컴퓨터 : %s => 이겼습니다.\n", "보");
					humanToWin--; break;
				}
			}
			else if (humanChoice.equals("바위")) {
				System.out.printf("사용자 : %s ",humanChoice);
				switch (cpuChoice) {
				case 1 :
					System.out.printf("컴퓨터 : %s => 이겼습니다.\n", "가위");
					humanToWin--; break;
				case 2 :
					System.out.printf("컴퓨터 : %s => 비겼습니다.\n", "바위");
					break;
				case 3 :
					System.out.printf("컴퓨터 : %s => 졌습니다.\n", "보");
					cpuToWin--; break;
				}
			}
			else {
				System.out.printf("사용자 : %s ",humanChoice);
				switch (cpuChoice) {
				case 1 :
					System.out.printf("컴퓨터 : %s => 졌습니다.\n", "가위");
					cpuToWin--; break;
				case 2 :
					System.out.printf("컴퓨터 : %s => 이겼습니다.\n", "바위");
					humanToWin--; break;
				case 3 :
					System.out.printf("컴퓨터 : %s => 비겼습니다.\n", "보");
					break;
				}
			}
			if (cpuToWin == 0)
				break;
			if (humanToWin == 0)
				break;
			maxGame--;
		}
		if (cpuToWin > humanToWin)
			System.out.println("### 당신의 승!!!");
		else if (cpuToWin < humanToWin)
			System.out.println("### 컴퓨터 승!!!");
		else
			System.out.println("### 비겼습니다!!!");
	}
}
