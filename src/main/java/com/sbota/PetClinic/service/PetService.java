package com.sbota.PetClinic.service;

import com.sbota.PetClinic.model.Pet;
import com.sbota.PetClinic.repository.PetRepository;
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
}
