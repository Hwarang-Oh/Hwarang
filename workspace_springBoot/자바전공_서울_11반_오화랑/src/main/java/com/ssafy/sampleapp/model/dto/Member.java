package com.ssafy.sampleapp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private int no;
    private String member_id;
    private String member_name;
    private String password;
    private String email;
    private String mobile;
    private int is_admin;

    public Member() {
    }

    public Member(int no, String member_id, String member_name, String password, String email, String mobile,
            int is_admin) {
        this.no = no;
        this.member_id = member_id;
        this.member_name = member_name;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.is_admin = is_admin;
    }
}
