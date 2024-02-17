
public class Student implements Comparable<Student> {
	private String name;
	private int point;
	
	public Student(String name, int point){
		this.name = name;
		this.point = point;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", point=" + point + "]";
	}

	@Override
	public int compareTo(Student o) {
		int diff = Integer.compare(o.point, this.point);
		return diff;
	}
}
