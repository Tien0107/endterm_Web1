package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.model.User;
import com.example.demo.service.ArticleService;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ViewController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
//
    @GetMapping("/")
    public String Home(Model model) {
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        return "/home";
    }


    @GetMapping("/admin")
    public String AdminPage(Model model) {
        // Lấy danh sách user và article từ service
        List<User> users = userService.findAll();
        List<Article> articles = articleService.findAll();

        // Đưa dữ liệu vào model để Thymeleaf sử dụng
        model.addAttribute("users", users);
        model.addAttribute("articles", articles);
        return "admin";
    }

    @GetMapping("/blog")
    public String blogPage(Model model) {
        List<Article> articles = articleService.findAll();
        model.addAttribute("posts", articles);
        return "blog";
    }
    @GetMapping("/post")
    public String postPage(Model model) {
        List<Article> articles = articleService.findAll();
        model.addAttribute("posts", articles);
        return "post";
    }
    

    
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    


}