import java.util.Scanner;

public class LastDayTest {
	public static void main(String[] args) {
		// 1. 년, 월 입력 받아 해당 월의 마지막 날짜를 구하시오
		// 2. 반복적으로 입력 받아 처리 ( Year : -1 -> 종료 )
		Scanner dateScan = new Scanner(System.in);
		int year, month, day;
		
		while (true) {
			System.out.print("Enter Year and Month ex) 2024 1 : ");
			year = dateScan.nextInt();
			if (year < 0) {
				System.out.println("Program End");
					break;
			}
			month = dateScan.nextInt();
			day = 0;
			
			switch (month) {
				case 1 : case 3 : case 5 : case 7 : 
				case 8 : case 10 : case 12 :
					day = 31;
					break;
				case 4 : case 6 : case 9 : case 11 :
					day = 30;
					break;
				case 2 :
					if (year % 4 == 0) {
						if (year % 400 == 0) {
							day = 29;
						}
						else if (year % 100 == 0) {
							day = 28;
						}
						else 
							day = 29;
						}
					else 
						day = 28;
					break;
				default :
					System.out.println("Not Available Month!");
					continue;
			}
			System.out.println(year + "년의 " + month + "월은 총 " + day + "일 입니다");
		}
	}
}

