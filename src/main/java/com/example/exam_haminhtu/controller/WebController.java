package com.example.exam_haminhtu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @Autowired

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/error")
    public String error() {
        return "404";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}