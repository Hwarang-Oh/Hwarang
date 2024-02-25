import java.util.EmptyStackException;

public class A0206_SSAFYStack<E> implements A0206_IStack<E> {

	private A0207_Node<E> top;
	

	@Override
	public void push(E e) {
		top = new A0207_Node<E>(e, top);
	}

	@Override
	public E pop() {
		if (isEmpty()) throw new EmptyStackException();
		A0207_Node<E> popNode = top;
		top = popNode.link;
		popNode.link = null;
		return popNode.data;
	}

	@Override
	public E peek() {
		if (isEmpty()) throw new EmptyStackException();
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		int count = 0;
		for (A0207_Node<E> temp = top; temp != null ; temp = temp.link )
			count++;

		return count;
	}


}
