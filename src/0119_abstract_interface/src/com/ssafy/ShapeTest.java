package com.ssafy;

import com.shape.ShapeUtil;

public class ShapeTest {

	public static void main(String[] args) {

//		new Shape(); // error
		Rectangle r = new Rectangle(10, 20);
		ShapeUtil.calcArea(r);
	}

}
