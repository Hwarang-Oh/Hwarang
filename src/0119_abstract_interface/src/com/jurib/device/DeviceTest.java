package com.jurib.device;

import com.jurib.remote.RemoteControl;
import com.ssafy.exception.InvalidValueException;

public class DeviceTest {
	public static void main(String[] args) {
		
		RemoteControl controller = new RemoteControl();
		Tv tv=null,tv2=null;
		SettopBox sb=null;
		try {
			tv = new Tv(50);
//			tv2 = new Tv(70);
		} catch (InvalidValueException e) {
			e.printStackTrace();
		}
		try {
			tv2 = new Tv(-70);
		} catch (InvalidValueException e) {
			e.printStackTrace();
		}
		try {
			sb = new SettopBox(100);
		} catch (InvalidValueException e) {
			e.printStackTrace();
		}
		
		controller.setMode(tv);
		controller.powerOn();
		controller.volumeUp();
		controller.volumeUp();
		controller.volumeUp();
		
		controller.setMode(sb);
		controller.powerOn();
		controller.volumeUp();
		controller.volumeUp();
		controller.volumeDown();
		controller.powerOff();
		
		
		System.out.println(tv);
		System.out.println(sb);
		
	}

}
