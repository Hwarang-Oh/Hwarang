import java.util.Arrays;
import java.util.Date;

public class DataTypeTest {

	public static void main(String[] args) {
		byte b1 = 10; // byte의 표현 범위에 맞는 primitive int로 해서 묵시적 casting 
		short s1 = 200; // short의 표현 범위에 맞는 primitive int로 해서 묵시적 casting 
		int score = 100; // 정수의 기본형 int (primitive)
		long sum = 3_000_000_000L; // L 안붙여서 오류 , L붙이면 long이라는 명시

		boolean isSuccess = true;
		
		char ch1 = 'A'; // 문자는 char primitive , 문자열은 ""로 표현 -> ref type
//		String st1 = "A"; // 문자열 -> ref타입이어도 Primitive 타입처럼 쓸 수 있다. 
		// new string은 약간 복잡한 원소들을 문자열로 표현하고 싶을 때 사용함. 
		
		float f1 = 3.45F; // 실수형 상수는 default가 double, F를 붙여야 한다.
		double d = 3.45; // D도 있나보다, 굳이 안붙여도 double이니까 굳이?
		double d2 = 123.456E-2; // 지수형 표현도 가능
		// 여기까지는 Primitivie Data type : 하나의 값을 표현, 할당된 곳에 데이터가 직접 저장 ( 그냥 그 자체 )
		
		// 참조형 타입 ( 객체 타입 ) : 할당된 공간에 참조값이 저장되는 타입 -> 참조값을 통해 객체를 참조해서 객체 사용 : pass by value
		// 값을 가지고 있는 것 그대로 줌. 그것이 primitive던 reference던
		
		Date today = new Date(); // 정적 타이핑 언어 ( 정확하게 표현할 수 있는 데이터 타입을 선언해줘야 함. 지역변수는 약간 편하게 가능
		String[] names = new String[] {"ㅇㅇ", "ㅎㅎ", "ㅠㅠ"}; // 객체는 복합체 ( 여러가지 가능 ) // 문자열 : 문자가 여러개 나열되어 있는 // 단일 문자의 여러개 (char primitive)
		System.out.println(isSuccess);
		System.out.println(ch1);
		System.out.println(b1);
		System.out.println(s1);
		System.out.println(score);
		System.out.println(sum);
		System.out.println(f1);
		System.out.println(d);
		System.out.println(d2);
		System.out.println("--------------------------------------");
		System.out.println(today); // 내부적으로 toString()을 불러서 함
		System.out.println(today.toString());
		System.out.println(names); // 배열은 toString() Method는 내용이 나오게 되어 있지 않은 것임. 
		System.out.println(names.toString());
		System.out.println(Arrays.toString(names)); // 원소로 되어 있는 문자열이 스스로 toString이 가능해서 이쁘게 나오는 것 
		
		byte b2 = 10, b3 = 20;
		int result = b2 + b3; // int형과 int형의 합의 연산임.
		byte bResult = (byte)(b2 + b3); // byte, short는 계산될 땐 형변환이 되어서 int형과 int형의 계산으로 변환됨
		// 명시적 형변환은 하면 데이터 손실의 위험성이 있다.
		
//		int price = 1_000_000_000;
//		int amount = 30;
//		int totalPrice = price*amount; // Overflow (난리남)
//		System.out.println(totalPrice);
		
//		int price = 1_000_000_000;
//		int amount = 30;
//		long totalPrice = price*amount; // 이래도 안됨, 계산할 때 부터 int형이 최대라서 손실된 데이터는 복구되지 않음. 연산부터 long형으로 해서 결과를 보존해야함. 
//		System.out.println(totalPrice);
		
		
		
		int price = 1_000_000_000;
		int amount = 30;
		long totalPrice = (long)(price)*amount; // 이래도 안됨, 계산할 때 부터 int형이 최대라서 손실된 데이터는 복구되지 않음. 연산부터 long형으로 해서 결과를 보존해야함. 
		System.out.println(totalPrice);
		
		int total = 345;
		int count = 4;
		double avg = (double)total / count; // double로 하나를 바꿔서 묵시적인 형변환이 일어나게 함. 
		System.out.println(avg);
		
		// if (~~~) 블럭을 해주는 것이 보통 권장됨.
		// 작성한 코드의 유형을 정하는 것도 중요함. 
		// if / if else / if else if else if else
		// 순서대로 내려가기 때문에, 논리에 맞게 잘 구성하는 것이 중요함.
		// 클린코드 : if문을 가독성차원에서 위에서 걸러내면서 내려오기
		// 조건은 무조건 boolean Expression
		// switch : 조건문 case -> 같은지를 빅하는 것
		// case 1 case 2 ... -> default ( 동등비교만 가능 )
		// int 정수로 표현될 수 있는 타입만 비교 가능
		// enumuration 도 가능?
		// 문자열 비교도 가능해짐. jdk 7 이상
		// switch case는 순서대로 내려가는 것이 아님. -> 바로 접근 함.
		// 접근하고 맞으면, 그대로 statement를 쭉 내려감. ( 그래서 break를 걸어줘야 함 )
		// case 1 : / case 2 : / case 3 : ... break; 로 한번에 처리도 가능.
		
		
		// int[] su = {24, 6, 4, ..., }
		// for (int count ; count < ; count++ )
		// 선 조건 -> 후 수행
		
		// Enhanced for문 -> 반복이 가능한 Collections
		// 자료구조의 꺼내는 방법을 굳이 정의하지 않아도 된다. ( 동일한 방법으로 꺼낼 수 있음 )
		// 조회만 가능하다. 그 공간에 있는 것을 바꿀 수 없음. 
		// for (type item : items) :
			// System.out.println(s);
		
		// 반복문 - while() : 조건 기반 반복 (count 변수 설정 -> 안하면, 무한루프)
		// continue와 count변수 제어를 잘 넣어줘야 의도한대로 된다고 하신다.
		// Python, Java 잘 균형잡아서 ㄱㄱ
		// do while ()
		// break; -> 반복문을 종료
		// continue -> 다음 반복문을 실행하기 위한 전 단계 (증감식 for ), (while 조건)으로 감
		// 그래서 while에서는 무한 loop에 빠질 위험이 있다.
		
		// Java는 빠져나오고 싶은 반복문의 break;와 continue;의 label을 설정할 수 있다.
		
		
	}
}
