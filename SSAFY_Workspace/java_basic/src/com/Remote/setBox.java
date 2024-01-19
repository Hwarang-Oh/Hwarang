package com.Remote;

import java.util.Random;

public class setBox implements RemoteControl{
	Random rand = new Random();
	private final int MAX_VOLUME = rand.nextInt(100,300);
	private int currentVolume;
	
	private boolean isSetBoxOn = false;
	private static int SetBoxcount = 0;	
	private String setBoxname;


	public setBox() {
		this("SetBox" + ++SetBoxcount);
	}
	
	public setBox(String name) {
		Random rand2 = new Random();
		this.setBoxname = name;
		this.isSetBoxOn = true;
		this.currentVolume = rand2.nextInt(1,30);
		System.out.println(setBoxname + " Turn On ");
	}

	@Override
	public void volumeUp() {
		if (isSetBoxOn) {
			currentVolume += 5;
			if (currentVolume <= MAX_VOLUME)
				System.out.printf(this.setBoxname + " Volume : %d / %d",currentVolume, MAX_VOLUME).println();
			else
				System.out.println("Volume MAX");
		}
		else
			System.out.println("SetBox is Off!!");
	}

	@Override
	public void volumeDown() {
		if (isSetBoxOn) {
			currentVolume -= 5;
			if (currentVolume >= 0)
				System.out.printf(this.setBoxname + " Volume : %d / %d",currentVolume, MAX_VOLUME).println();
			else
				System.out.println("Volume MUTE");
		}
		else
			System.out.println("SetBox is Off!!");
	}

	@Override
	public void Power() {
		if (isSetBoxOn) {
			isSetBoxOn = false;
			System.out.println(setBoxname + " Turn Off");
		}
		else {
			isSetBoxOn = true;	
			System.out.println(setBoxname + " Turn Off");
		}
	}

}
