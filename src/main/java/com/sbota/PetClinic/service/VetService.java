package com.sbota.PetClinic.service;
import com.sbota.PetClinic.model.Vet;
import com.sbota.PetClinic.repository.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("IVetService")
public class VetService {
    @Autowired
    private VetRepository vetRepository;
    public List<Vet> findAll() {
        return vetRepository.findAll();
    }

    public void save(Vet vet) {
        vetRepository.save(vet);
    }

    public Vet findById(Integer id) {
        Optional<Vet> vet = vetRepository.findById(id);
        if (vet.isPresent()) {
            return vet.get();
        }

        return null;
    }

    public void deleteById(Integer id) {
        vetRepository.deleteById(id);
    }
}
