package com.SSAFY_1.day5.b_interface.staticdefault;

import java.util.Arrays;

interface Aircon {
    void makeCool();
    // TODO: 2. 건조기능을 추가해보자.
//    void dry(); -> 이러면, 반드시 Override해야 하는 기능
    default void dry() {
    	System.out.println("건조 매우필요하지");
    }
    // TODO: 3.Aircon이 동작 방식에 대해 설명해보자.
}

class OldisButGoodies1 implements Aircon {
    @Override
    public void makeCool() {
        System.out.println("전체 냉각해줘");
    }
}

class OldisButGoodies2 implements Aircon {
    @Override
    public void makeCool() {
        System.out.println("집중 냉각해줘");
    }
}

// TODO: 1. 무풍 에어컨을 구현해보자.
class NoWind implements Aircon {
	public void makeCool() {
		System.out.println("무풍 최고");
	}
	public void dry() {
		System.out.println("건조도 되어야지 ");
	}
	static void desc() {
		System.out.println("에어컨은 좋은것");
	}
}
// END

public class StaticDefaultMethod {
    public static void main(String[] args) {
        Aircon[] aircons = { new OldisButGoodies1(), new OldisButGoodies2() };
        for (Aircon aircon : aircons) {
            aircon.makeCool();
        }
    }
}
