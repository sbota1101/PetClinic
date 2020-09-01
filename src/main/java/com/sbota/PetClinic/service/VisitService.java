package com.sbota.PetClinic.service;

import com.sbota.PetClinic.model.Pet;
import com.sbota.PetClinic.model.Visit;
import com.sbota.PetClinic.repository.PetRepository;
import com.sbota.PetClinic.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("IVisitService")
public class VisitService {
    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private PetRepository petRepository;

    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    public void findAllPets() {

    }

    public void save(Visit visit) {
        visitRepository.save(visit);
    }

    public Visit findById(Integer id) {
        Optional<Visit> visit = visitRepository.findById(id);
        if (visit.isPresent()) {
            return visit.get();
        }

        return null;
    }

    public void deleteById(Integer id) {
        visitRepository.deleteById(id);
    }

//    public List<Pet> findVisitByPet(Integer id) {
//        Optional<Visit> pets = visitRepository.findById(id);
//        if (pets.isPresent()) {
//            List<Pet> allpets = petRepository.findAll();
//            return allpets;
//        }
//        return null;
//
//    }
//public List<Pet> findVisitByPet(Integer id) {
//    Optional<Visit> petlist = visitRepository.findById(id);
//    if (petlist.isPresent()) {
//        return petlist.get().pets();
//    }
//    return null;
//}
}
