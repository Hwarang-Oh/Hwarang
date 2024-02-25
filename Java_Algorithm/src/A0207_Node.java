
public class A0207_Node<T> {
	public T data;
	public A0207_Node<T> link;
	public A0207_Node(T data) {
		super();
		this.data = data;
	}
	public A0207_Node(T data, A0207_Node<T> link) {
		super();
		this.data = data;
		this.link = link;
	}
	
	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}

}
