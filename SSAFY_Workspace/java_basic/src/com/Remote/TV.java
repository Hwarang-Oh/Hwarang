package com.Remote;
import java.util.Random;

public class TV implements RemoteControl {
	Random rand = new Random();
	private final int MAX_VOLUME = rand.nextInt(100,300);
	private int currentVolume;
	private boolean isTvOn = false;
	private static int TVcount = 0;
	private String TVname;


	public TV() {
		this("TV" + ++TVcount);
	}
	
	public TV(String name) {
		Random rand2 = new Random();
		this.TVname = name;
		this.isTvOn = true;
		this.currentVolume = rand2.nextInt(1,30);
		System.out.println(TVname + " Turn On");
	}

	@Override
	public void volumeUp() {
		if (isTvOn) {
			if (++currentVolume <= MAX_VOLUME)
				System.out.printf(this.TVname + " Volume : %d / %d",currentVolume, MAX_VOLUME).println();
			else
				System.out.println("Volume MAX");
		}
		else
			System.out.println("TV is Off!!");
	}

	@Override
	public void volumeDown() {
		if (isTvOn) {
			if (--currentVolume >= 0)
				System.out.printf(this.TVname +" Volume : %d / %d",currentVolume, MAX_VOLUME).println();
			else
				System.out.println("Volume MUTE");
		}
		System.out.println("TV is Off!!");
	}

	@Override
	public void Power() {
		if (isTvOn) {
			isTvOn = false;
			System.out.println(TVname + " Turn Off");
		}
		else {
			isTvOn = true;
			System.out.println(TVname + " Turn On");
		}
	}
}
