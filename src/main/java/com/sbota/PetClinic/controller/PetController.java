package com.sbota.PetClinic.controller;

import com.sbota.PetClinic.model.Pet;
import com.sbota.PetClinic.service.OwnerService;
import com.sbota.PetClinic.service.PetService;
import com.sbota.PetClinic.service.VetService;
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
public class PetController {
    @Autowired
    private PetService petService;
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private VetService vetService;
    @Autowired
    private VisitService visitService;
    @GetMapping("allpets")
    public String showAllPets(Model model) {

        List<Pet> pets = petService.findAll();
        model.addAttribute("pets", pets);

        return "pet/allpets";
    }

    @GetMapping("/addpet")
    public String addPet(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("owners", ownerService.findAll());
        model.addAttribute("vets",vetService.findAll());
        return "pet/addpet";
    }

    @PostMapping("/addpet")
    public String addPet(@ModelAttribute Pet pet) {
        petService.save(pet);
        return "redirect:/allpets";

    }

    @GetMapping("/editpet/{id}")
    public String editPet(Model model, @PathVariable Integer id) {
        model.addAttribute("owners", ownerService.findAll());
        model.addAttribute("vets",vetService.findAll());
        Pet pet = petService.findById(id);
        model.addAttribute("pet",pet);
        return "pet/editpet";
    }

    @PostMapping("/editpet/{id}")
    public String editPet(@ModelAttribute Pet pet, @PathVariable Integer id) {

        petService.save(pet); // save it again. SAVE acts as UPDATE

        return "redirect:/allpets";

    }

    @GetMapping("/deletepet/{id}")
    public String deletePet(@PathVariable Integer id) {
        petService.deleteById(id);

        return "redirect:/allpets";
    }
//    @GetMapping("/pet/{id}/visits")
//    public String searchVisitsByPet(Model model, @PathVariable Integer id) {
//        model.addAttribute("visits", petService.findVisitsByPet(id));
//        return "pet/findvisit";
//    }
}
