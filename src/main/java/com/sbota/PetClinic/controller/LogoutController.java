package com.sbota.PetClinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LogoutController {
    @GetMapping("/logout")
    public String logoutPage(){

        return "redirect:/";
    }
}
