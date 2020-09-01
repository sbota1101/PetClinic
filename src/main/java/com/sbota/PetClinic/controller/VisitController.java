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
    @GetMapping("/editvisit/{id}")
    public String editVisit(Model model, @PathVariable Integer id) {

        Visit visit = visitService.findById(id);
        model.addAttribute("visit",visit);
        return "visit/editvisit";
    }



    @PostMapping("/editvisit/{id}")
    public String editVisit(@ModelAttribute Visit visit, @PathVariable Integer id) {

        visitService.save(visit); // save it again. SAVE acts as UPDATE

        return "redirect:/allvisits";

    }

    @GetMapping("/deletevisit/{id}")
    public String deleteVisit(@PathVariable Integer id) {
        visitService.deleteById(id);

        return "redirect:/allvisits";
    }
    @GetMapping("/visit/{id}/pets")
    public String searchVisitsByPet(Model model,@PathVariable Integer id) {
        model.addAttribute("pets", visitService.findVisitByPet(id));
        return "visit/findpet";
    }

}
