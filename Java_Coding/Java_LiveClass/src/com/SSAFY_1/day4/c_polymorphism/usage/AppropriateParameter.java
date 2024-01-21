package com.SSAFY_1.day4.c_polymorphism.usage;

import com.SSAFY_1.day3.a_inheritance.SpiderMan;
import com.SSAFY_1.day3.a_inheritance.Person;

public class AppropriateParameter {
    public void useJump1(Object obj) {
        if (obj instanceof Person) {
            Person casted = (Person) obj;
            casted.jump();
        }
    }

    public void useJump2(Person person) {
        person.jump();
    }

    public void useJump3(SpiderMan spiderMan) {
        spiderMan.jump();
    }

    public static void main(String[] args) {
        Object obj = new Object(); // 활용도가 높아보이지만, 작성할 것이 많아 니옴
        Person person = new Person();
        SpiderMan sman = new SpiderMan();

        AppropriateParameter ap = new AppropriateParameter();
        ap.useJump1(obj);
        ap.useJump2(person);
        ap.useJump3(sman);

        // END

    }

}
