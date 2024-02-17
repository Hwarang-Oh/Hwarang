package com.remote;

public class RemoteTest {
    public static void main(String[] args) {
        Device setTopBox = new SetTopBox();
        Device television = new Television();

        RemoteController rc = new RemoteController();

        rc.deviceToggle(setTopBox);
        rc.powerToggle();

        rc.volumeDown();
        rc.volumeUp();

        rc.deviceToggle(television);

        rc.powerToggle();
        rc.volumeDown();
        rc.volumeUp();

    }
}
