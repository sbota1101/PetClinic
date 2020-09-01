package com.sbota.PetClinic.service;

import com.sbota.PetClinic.model.Pet;
import com.sbota.PetClinic.model.Visit;
import com.sbota.PetClinic.repository.PetRepository;
import com.sbota.PetClinic.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("IPetService")
public class PetService {
    @Autowired
    private PetRepository petRepository;


    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public void save(Pet pet) {
        petRepository.save(pet);
    }

    public Pet findById(Integer id) {
        Optional<Pet> pet = petRepository.findById(id);
        if (pet.isPresent()) {
            return pet.get();
        }

        return null;
    }

    public void deleteById(Integer id) {
        petRepository.deleteById(id);
    }

    public List<Visit> findVisitsByPet(Integer id) {
        Optional<Pet> pets = petRepository.findById(id);
        if (pets.isPresent()) {
            return pets.get().getVisits();
        }
        return null;
    }

    public List<Pet> findAllPets() {
        List<Pet>pets=petRepository.findAll();
        return pets;
    }
}
