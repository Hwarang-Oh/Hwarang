package com.ssafy.sampleapp.model.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private int no;
    private String member_id;
    private String member_name;
    private String password;
<<<<<<< HEAD
    private String email;
    private String mobile;
    private int is_admin;
=======
    private Date join_date;
>>>>>>> ff04bcea937c4e1a9645d2bb90070137e914f1e0

    public Member() {
    }

<<<<<<< HEAD
    public Member(int no, String member_id, String member_name, String password, String email, String mobile,
            int is_admin) {
        this.no = no;
        this.member_id = member_id;
        this.member_name = member_name;
=======
    public Member(String id, String name, String password, Date join_date) {
        this.id = id;
        this.name = name;
>>>>>>> ff04bcea937c4e1a9645d2bb90070137e914f1e0
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.is_admin = is_admin;
    }
}
