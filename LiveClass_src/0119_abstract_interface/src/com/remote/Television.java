package com.remote;

public class Television extends Device {
    public static final int MAX_VOLUME = 50;
    @Override
    public void upVolume() {
        if (!isPowerOn) {
            System.out.println("전원을 켜주세요");
            return;
        }
        if (volume + 1 > MAX_VOLUME) {
            System.out.println("최대 음량(" + MAX_VOLUME + ") 을 넘을 수 없습니다.");
            return;
        }
        volume += 1;
        System.out.println("TV 현재 볼륨 : " + volume);
    }

    @Override
    public void downVolume() {
        if (!isPowerOn) {
            System.out.println("전원을 켜주세요");
            return;
        }
        if (volume - 1 < MIN_VOLUME) {
            System.out.println("최소 음량(" + MIN_VOLUME + ") 을 넘을 수 없습니다.");
            return;
        }
        volume -= 1;
        System.out.println("TV 현재 볼륨 : " + volume);
    }

    @Override
    public String toString() {
        return "Television{" +
                "음량=" + volume +
                ", 전원=" + (isPowerOn ? "켜짐" : "꺼짐") +
                '}';
    }
}
