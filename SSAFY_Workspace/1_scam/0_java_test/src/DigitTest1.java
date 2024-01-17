public class DigitTest1 {
	public static void main(String[] args) {	
		for (int num = 1 ; num < 16 ; num++) {
			System.out.printf("%d ", num);
			if (num == 5 | num == 9 | num == 12 | num == 14) {
				System.out.println();
				switch (num) {
				case 14 :
					System.out.print("  ");
				case 12 :
					System.out.print("  ");
				case 9 :
					System.out.print("  ");
				case 5 :
					System.out.print("  ");
				}
			}
		}
	}
}

