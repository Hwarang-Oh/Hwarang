package H_Company;

import com.shape.Shape;

public class Circle extends Shape {
	
	private int radius;
	private double pi = Math.PI; 
	public Circle(int radius) {
		super();
		this.radius = radius;
	}
	
	public void makeArea() {
		area = pi * radius * radius;
	}
}
