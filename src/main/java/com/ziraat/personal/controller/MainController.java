package com.ziraat.personal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("main", "This is Main Page");
        return "index";
    }
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("about", "This page is about Bank");
        return "about";
    }

    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("news", "Bank News");
        return "news";
    }
}
