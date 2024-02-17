package com.remote;

public class RemoteController{
    Remotable remotable;

    {
        remotable = new Television();
    }

    public void volumeUp(){
        remotable.upVolume();
    }
    public void volumeDown(){
        remotable.downVolume();
    }

    public void powerToggle(){
        remotable.togglePower();
    }

    public void deviceToggle(Remotable remotable) {
        this.remotable = remotable;
        System.out.println("현재 기기 : " + remotable.getClass());
    }

}
