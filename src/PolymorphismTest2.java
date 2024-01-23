
public class PolymorphismTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Company2 c = Company2.getInstance(); // Singletone Design Pattern 
		Company2 c2 = Company2.getInstance(); // Singletone Design Pattern 
		Employee eg = new Engineer("오화랑", 1_000_000_000);
		Manager m = new Manager("오화랑2", 1_000_000_000);
		
		c.increaseSalary(eg); // Employee e = eg
		c.increaseSalary(m); // Employee e = m -> 매개변수의 다형성

	}

}
