package com.sbota.PetClinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactUsController {

//    @GetMapping("/contactus")
//    public String contactusPage(){
//
//        return "security/contactus";
//    }
//
//    @PostMapping("/contactus")
//    public String contactusPage1(){
//
//        return "redirect:/";
//    }
@GetMapping("/contact")
public String contactusPage(){

    return "security/contact";
}

    @PostMapping("/contact")
    public String contactusPage1(){

        return "redirect:/";
    }
}
