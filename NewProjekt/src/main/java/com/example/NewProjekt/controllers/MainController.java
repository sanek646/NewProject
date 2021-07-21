package com.example.NewProjekt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String home( Model model) {
        model.addAttribute("title", "First page");
        return "home_page";
    }
    @GetMapping("/about")
    public String about( Model model) {
        model.addAttribute("title", "Support page");
        return "about";
    }

}