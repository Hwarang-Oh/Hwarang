package com.SSAFY_1.day3.a_inheritance;

public class SpiderManTest {
    public static void main(String[] args) {
        SpiderMan spiderMan = new SpiderMan();
        spiderMan.isSpider = true;
//        spiderMan.equals
        spiderMan.jump();
        spiderMan.fireWeb();
        spiderMan.eat();
    }
}
