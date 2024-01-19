package H_Company;

import com.shape.ShapeUtil;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new Shape(); // error
		Circle circle = new Circle(10);
		ShapeUtil.calcArea(circle);

	}

}
