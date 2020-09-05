package com.sbota.PetClinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
    @RequestMapping("/")
    public String menu() {
        return "/";
    }
}
