package com.sbota.PetClinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactUsController {

    @GetMapping("/contactus")
    public String contactusPage(){

        return "security/contactus";
    }

    @PostMapping("/handler")
    public String contactusPage1(){

        return "redirect:/";
    }

}
