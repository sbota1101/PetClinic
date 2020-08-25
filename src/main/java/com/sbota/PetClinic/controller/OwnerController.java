package com.sbota.PetClinic.controller;

import com.sbota.PetClinic.model.Owner;
import com.sbota.PetClinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OwnerController {
    @Autowired
    private OwnerService ownerService;
    @GetMapping("allowners")
    public String showAllOwners(Model model) {

        List<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);

        return "owner/allowners";
    }

    @GetMapping("/addowner")
    public String addOwner(Model model) {
        model.addAttribute("owner", new Owner());
        return "owner/addowner";
    }

    @PostMapping("/addowner")
    public String addOwner(@ModelAttribute Owner owner) {
        ownerService.save(owner);
        return "redirect:/allowners";

    }

    @GetMapping("/editowner/{id}")
    public String editOwner(Model model, @PathVariable Integer id) {

        Owner owner = ownerService.findById(id);

        model.addAttribute("owner",owner);

        return "owner/editowner";
    }

    @PostMapping("/editowner/{id}")
    public String editOwner(@ModelAttribute Owner owner, @PathVariable Integer id) {

        ownerService.save(owner); // save it again. SAVE acts as UPDATE

        return "redirect:/allowners";

    }

    @GetMapping("/deleteowner/{id}")
    public String deleteOwner(@PathVariable Integer id) {
        ownerService.deleteById(id);

        return "redirect:/allowners";
    }
    @GetMapping("/owner/{id}/allpets")
    public String searchPetsByOwner(Model model, @PathVariable Integer id) {
        model.addAttribute("pets", ownerService.findPetsByOwner(id));
        return "owner/findpet";
    }

}

