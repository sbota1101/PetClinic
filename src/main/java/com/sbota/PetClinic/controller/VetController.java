package com.sbota.PetClinic.controller;

import com.sbota.PetClinic.model.Vet;
import com.sbota.PetClinic.repository.VetRepository;
import com.sbota.PetClinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VetController {
    @Autowired
    private VetService vetService;
    @GetMapping("allvets")
    public String showAllVets(Model model) {

        List<Vet> vets = vetService.findAll();
        model.addAttribute("vets", vets);

        return "vet/allvets";
    }

    @GetMapping("/addvet")
    public String addVet(Model model) {
        model.addAttribute("vet", new Vet());
        return "vet/addvet";
    }

    @PostMapping("/addvet")
    public String addVet(@ModelAttribute Vet vet) {
        vetService.save(vet);
        return "redirect:/allvets";

    }

    @GetMapping("/editvet/{id}")
    public String editVet(Model model, @PathVariable Integer id) {
        Vet vet = vetService.findById(id);
        model.addAttribute("vet",vet);

        return "vet/editvet";
    }

    @PostMapping("/editvet/{id}")
    public String editVet(@ModelAttribute Vet vet, @PathVariable Integer id) {

        vetService.save(vet); // save it again. SAVE acts as UPDATE

        return "redirect:/allvets";

    }

    @GetMapping("/deletevet/{id}")
    public String deleteVet(@PathVariable Integer id) {
        vetService.deleteById(id);

        return "redirect:/allvets";
    }

}
