package com.remote;

public class SetTopBox extends Device{
    public static final int MAX_VOLUME = 100;
    @Override
    public void upVolume() {
        if (!isPowerOn) {
            System.out.println("전원을 켜주세요");
            return;
        }
        if (volume + 5 > MAX_VOLUME) {
            System.out.println("최대 음량(" + MAX_VOLUME + ") 을 넘을 수 없습니다.");
            return;
        }
        volume += 5;
        System.out.println("셋톱박스 현재 볼륨 : " + volume);
    }

    @Override
    public void downVolume() {
        if (!isPowerOn) {
            System.out.println("전원을 켜주세요");
            return;
        }
        if (volume - 5 < MIN_VOLUME) {
            System.out.println("최소 음량(" + MIN_VOLUME + ") 을 넘을 수 없습니다.");
            return;
        }
        volume -= 5;
        System.out.println("셋톱박스 현재 볼륨 : " + volume);
    }

    @Override
    public String toString() {
        return "SetTopBox{" +
                "음량=" + volume +
                ", 전원=" + (isPowerOn ? "켜짐" : "꺼짐") +
                '}';
    }
}
