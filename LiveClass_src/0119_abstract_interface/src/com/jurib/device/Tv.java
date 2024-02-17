package com.jurib.device;

import com.ssafy.exception.InvalidValueException;

public class Tv extends Device {

	public Tv(int maxVolume) throws InvalidValueException {
		super(maxVolume);
	}

	@Override
	public void volumeUp() {
		if(volume != MAX_VOLUME){
			volume ++;
		}
		System.out.println("볼륨 up : "+this.toString());		
	}

	@Override
	public void volumeDown() {
		if(volume != MIN_VOLUME){
			volume --;
		}
		System.out.println("볼륨 down : "+this.toString());		
	}

	@Override
	public String toString() {
		return "Tv [volume=" + volume + ", MAX_VOLUME=" + MAX_VOLUME
				+ ", powerOn=" + powerOn + "]";
	}


	
	
}
