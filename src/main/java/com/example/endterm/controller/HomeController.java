package com.example.endterm.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/post")
    public String post() {
        return "post";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String profile() {
        return "profile";
    }

    @GetMapping("/add_blog")
    @PreAuthorize("isAuthenticated()")
    public String add_blog() {
        return "add_blog";
    }
    
}