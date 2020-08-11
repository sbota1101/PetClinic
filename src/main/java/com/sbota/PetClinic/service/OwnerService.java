package com.sbota.PetClinic.service;

import com.sbota.PetClinic.model.Owner;
import com.sbota.PetClinic.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("IOwnerService")
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public void save(Owner owner) {
        ownerRepository.save(owner);
    }

    public Owner findById(Integer id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        if (owner.isPresent()) {
            return owner.get();
        }

        return null;
    }

    public void deleteById(Integer id) {
        ownerRepository.deleteById(id);
    }
}
