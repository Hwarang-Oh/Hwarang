package com.ssafy.day5.a_abstract;

public class VehicleTest {

  public static void main(String[] args) {
    // TODO: DieselSUV와 ElectricCar를 각각 한대씩 관리하는배열을 만들고 사용해보자.
	  Vehicle [] vehicles = {new DieselSUV(), new ElectricCar()};
	  for (Vehicle v : vehicles) {
		  v.addFuel();
		  v.reportPosition();
	  }
    // END
  }

}
