package com.Remote;

public class RemoteTest {

	public static void main(String[] args) {
		TV myTV = new TV();
		setBox mySetBox = new setBox();
		
		myTV.volumeUp();
		myTV.volumeUp();
		myTV.volumeDown();
		
		mySetBox.volumeUp();
		mySetBox.volumeUp();
		mySetBox.volumeDown();
		
		mySetBox.Power();
		myTV.Power();
		
		mySetBox.volumeUp();
		mySetBox.volumeDown();
		
		myTV.Power();
		myTV.volumeUp();
		myTV.volumeDown();
		myTV.Power();
	}
}
