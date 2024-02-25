import java.util.Stack;

public class A0206_StackAPITest {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>(); // vector로부터 상속받은 add Method도 존재

		System.out.println(stack.isEmpty() + "//" + stack.size());
		stack.push("카리나");
		stack.push("최예나");
		stack.push("홍은채");
		stack.push("설윤");
		stack.push("윈터");
		stack.push("배유빈");

		System.out.println(stack.isEmpty() + "//" + stack.size());
		stack.push("이나경");
		stack.push("세은");

		System.out.println(stack.peek());
		System.out.println(stack.isEmpty() + "//" + stack.size());

		System.out.println(stack.pop());
		System.out.println(stack.isEmpty() + "//" + stack.size());
		System.out.println("===========================================");
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}
}