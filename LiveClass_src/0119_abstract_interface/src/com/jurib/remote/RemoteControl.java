package com.jurib.remote;

public class RemoteControl {

	Controllable target;
	
	public void setMode(Controllable target){
		this.target = target;
	}
	public void powerOn(){
		target.powerOn();
	}
	public void powerOff(){
		target.powerOff();
	}
	public void volumeUp(){
		target.volumeUp();
	}
	public void volumeDown(){
		target.volumeDown();
	}	
}
