package com.remote;

public abstract class Device implements Remotable {
    int volume = 20;
    boolean isPowerOn = false;
    final int MIN_VOLUME = 0;

    @Override
    public void togglePower() {
        isPowerOn = !isPowerOn;
        StringBuffer sb = new StringBuffer("전원이 ");
        sb.append(isPowerOn ? "켜졌습니다." : "꺼졌습니다.");
        System.out.println(sb);
    }
}
