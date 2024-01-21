package com.SSAFY_1.day3.a_inheritance;

public class SpiderMan extends Person {
    boolean isSpider;
    // has a 관계
    Spider spider; // reference type -> NULL

    public SpiderMan() {
        this("피터 파커");
    }

    public SpiderMan(String name) {
        // 조상의 생성자 호출 - 코드 절감
        super(name);
        this.spider = new Spider();
    }


    void fireWeb() {
        if (isSpider){
            spider.fireWeb();
        }
        else
            System.out.println("어떻게 쏘누");
    }
    // Override
    @Override
    public void jump() {
        if (isSpider){
            spider.jump();
        }
        else
            super.jump(); // 안하면 재귀
    }

    @Override
    public String toString() {
        return "SpiderMan{" +
                "isSpider=" + isSpider +
                ", spider=" + spider +
                "} " + super.toString();
    }
}
