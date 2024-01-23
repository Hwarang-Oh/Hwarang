package com.ssafy;

import com.shape.Shape;

public class Rectangle extends Shape {

	private int width,height;
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	@Override
	public void makeArea() {
		area = width * height;
	}

}
