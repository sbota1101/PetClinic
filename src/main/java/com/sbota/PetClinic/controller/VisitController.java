package com.sbota.PetClinic.controller;
import com.sbota.PetClinic.model.Visit;
import com.sbota.PetClinic.service.GeneratePdf;
import com.sbota.PetClinic.service.PetService;
import com.sbota.PetClinic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
public class VisitController {
    @Autowired
    private VisitService visitService;
    @Autowired
    private PetService petService;

    @GetMapping("allvisits")
    public String showAllVisits(Model model) {

        List<Visit> visits = visitService.findAll();
        model.addAttribute("visits", visits);


        return "visit/allvisits";
    }


    @GetMapping("/addvisit")
    public String addVisit(Model model) {
        model.addAttribute("visit", new Visit());
        model.addAttribute("pets", petService.findAllPets());
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
        model.addAttribute("visit", visit);
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

    @RequestMapping(value = "/visit/pdf/", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> visittAsPdf() {

        ByteArrayInputStream bis = GeneratePdf.generate(visitService.findAll());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=" + "visits");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));

    }

}
