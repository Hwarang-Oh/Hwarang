package com.SSAFY_1.day5.b_interface;

public class IronMan implements Heroable {
    @Override
    public void fight() {
        System.out.println("변신");
    }
    @Override
    public void changeShape() {
        System.out.println("땅");
    }
    @Override
    public void upgrade() {
        System.out.println("짜잔");
    }
}
