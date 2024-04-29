package com.ssafy.sampleapp.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class login_history {
    private int log_id;
    private String member_id;
    private Date login_time;
    private Date logout_time;

    public login_history() {
    }

    public login_history(int log_id, String member_id, Date login_time, Date logout_time) {
        this.log_id = log_id;
        this.member_id = member_id;
        this.login_time = login_time;
        this.logout_time = logout_time;
    }
}
