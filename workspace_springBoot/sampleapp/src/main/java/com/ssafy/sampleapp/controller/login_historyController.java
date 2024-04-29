package com.ssafy.sampleapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.sampleapp.model.service.login_historyService;

@RequestMapping("/login_history")
@Controller
public class login_historyController {
    private final login_historyService login_historyService;

    public login_historyController(login_historyService login_historyService) {
        this.login_historyService = login_historyService;
    }

    // public String registerlog(Model model) {

    // }
}
