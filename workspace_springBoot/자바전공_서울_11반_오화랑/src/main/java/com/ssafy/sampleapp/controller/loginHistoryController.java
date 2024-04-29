package com.ssafy.sampleapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.sampleapp.model.dto.loginHistory;
import com.ssafy.sampleapp.model.service.loginHistoryService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/loginHistory")
@Controller
public class loginHistoryController {
    private final loginHistoryService loginhistoryService;

    public loginHistoryController(loginHistoryService loginhistoryService) {
        this.loginhistoryService = loginhistoryService;
    }

    @GetMapping("/regist")
    protected String register() throws Exception {
        // return loginhistoryService.register("log");
        return null;
    }

    @GetMapping("/regist")
    protected String getAll() throws Exception {
        loginhistoryService.getAll(0);
        return null;
    }

    @GetMapping("/regist")
    protected String getAll_admin() throws Exception {
        loginhistoryService.getAll_admin();
        return null;
    }

    @GetMapping("/regist")
    protected String getByDate() throws Exception {
        loginhistoryService.getByDate(0, "Date1", "Date2");
        return null;
    }

    @GetMapping("/regist")
    protected String getByDate_admin() throws Exception {
        loginhistoryService.getByDate_admin("date1", "date2");
        return null;
    }

}
