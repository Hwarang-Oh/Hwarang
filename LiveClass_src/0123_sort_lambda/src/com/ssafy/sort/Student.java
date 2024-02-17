package com.ssafy.sort;

public class Student implements Comparable {  //implements Comparable<Student> -> 주석처리하면 ClassCastException {
	private int no, score;

	public Student(int no, int score) {
		super();
		this.no = no;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Object o) {
		return Integer.compare(this.no, o.no);
	}
}
