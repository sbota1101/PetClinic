package com.sbota.PetClinic.controller;

import com.sbota.PetClinic.model.Visit;
import com.sbota.PetClinic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VisitController {
    @Autowired
    private VisitService visitService;

    @GetMapping("allvisits")
    public String showAllVisits(Model model) {

        List<Visit> visits = visitService.findAll();
        model.addAttribute("visits", visits);

        return "visit/allvisits";
    }

    @GetMapping("/addvisit")
    public String addVisit(Model model) {
        model.addAttribute("visit", new Visit());
        return "visit/addvisit";
    }

    @PostMapping("/addvisit")
    public String addVisit(@ModelAttribute Visit visit) {
        visitService.save(visit);
        return "redirect:/allvisits";

    }

//    @GetMapping("/visit/{id}/vets")
//    public String searchVetsByVisit(Model model, @PathVariable Integer id) {
//        model.addAttribute("vets", visitService.findVetsByVisit(id));
//        return "visit/findvet";
//    }
}
