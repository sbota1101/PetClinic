package com.sbota.PetClinic.controller;

import com.sbota.PetClinic.model.Pet;
import com.sbota.PetClinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PetController {
    @Autowired
    private PetService petService;
    @GetMapping("allpets")
    public String showAllPets(Model model) {

        List<Pet> pets = petService.findAll();
        model.addAttribute("pets", pets);

        return "pet/allpets";
    }

    @GetMapping("/addpet")
    public String addPet(Model model) {
        model.addAttribute("pet", new Pet());
        return "pet/addpet";
    }

    @PostMapping("/addpet")
    public String addDiscipline(@ModelAttribute Pet pet) {
        petService.save(pet);
        return "redirect:/allpets";

    }
//
//    @GetMapping("/editdiscipline/{id}")
//    public String editDiscipline(Model model, @PathVariable Integer id) {
//        model.addAttribute("disciplines", disciplineService.findAll());
//        Discipline discipline = disciplineService.findById(id);
//
//        model.addAttribute("discipline", discipline); // initial bind with the form, to say to the webpage
//
//        // what is the type of student th:object
//
//        return "discipline/editdiscipline";
//    }
//
//    @PostMapping("/editdiscipline/{id}")
//    public String editDiscipline(@ModelAttribute Discipline discipline, @PathVariable Integer id) {
//
//        disciplineService.save(discipline); // save it again. SAVE acts as UPDATE
//
//        return "redirect:/alldisciplines";
//
//    }
//
//    @GetMapping("/deletediscipline/{id}")
//    public String deleteDiscipline(@PathVariable Integer id) {
//        disciplineService.deleteById(id);
//
//        return "redirect:/alldisciplines";
//    }

}
