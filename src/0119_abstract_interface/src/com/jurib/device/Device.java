package com.jurib.device;

import com.jurib.remote.Controllable;
import com.ssafy.exception.InvalidValueException;

public abstract class Device implements Controllable {

	public int volume=0;
	public final int MAX_VOLUME;
	public static final int MIN_VOLUME = 0;
	public boolean powerOn=false;
	
	public Device(int maxVolume) throws InvalidValueException {
		super();
		if(maxVolume<0) throw new InvalidValueException(maxVolume);
		
		this.MAX_VOLUME = maxVolume;
	}

	@Override
	public void powerOn() {

		if(!powerOn){
			powerOn = true;
			System.out.println(this.getClass().getSimpleName()+"의 전원이 켜졌습니다.");
		}
	}

	@Override
	public void powerOff() {
		if(powerOn){
			powerOn = false;
			System.out.println(this.getClass().getSimpleName()+"의 전원이 꺼졌습니다.");
		}
	}
	

}
