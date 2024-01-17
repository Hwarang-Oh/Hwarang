
public class Person {
	static int count = 0;
	int order;
	String name = "김싸피";
	int age = 1;
	
	static {
		System.out.println("Hello World");
	}

	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		order = ++count;
		System.out.printf("%s님은 %d번째 사람입니다", this.name, count).println();
	}
	public Person(String name) {
		this(name, 1);
	}
	public Person(int age) {
		this("김싸피", age);
	}
	public Person() {
		this("김싸피", 1);
	}
	public void getInfo() {
		System.out.printf("이름 : %s, 나이 : %d", this.name, this.age).println();
	}
}
// Person을 부르고 싶은 것이니, this를 통해 호출, 생성자 Person은 부를 수 없다.
// StringBuffer -> 동기화, String builder -> 비동기화 => 문자열 최적화
// 다중 스레드 Safe / UnSafe -> 
// String getInfo() { return order + "/" + totalCount + " : " + name + "," + age;
