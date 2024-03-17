package Hwarang.hellospring.controller;

public class MemberForm {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
// name이 form의 name에 매칭이 되서 값이 들어 올 것임