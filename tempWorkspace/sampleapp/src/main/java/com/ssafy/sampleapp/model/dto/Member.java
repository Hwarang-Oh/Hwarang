package com.ssafy.sampleapp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String id;
    private String name;
    private String password;
    private String join_date;

    public Member() {
    }

    public Member(String id, String name, String password, String join_date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.join_date = join_date;
    }
}
