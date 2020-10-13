package com.sbota.PetClinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactUsController {

    @GetMapping("/contactus")
    public String contactusPage(){

        return "security/handler";
    }

//    @PostMapping("/contactus")
//    public String contactusPage1(){
//
//        return "redirect:/";
//    }
    @PostMapping("/handler")
    public String home() {
        return "redirect:/";
    }
}
