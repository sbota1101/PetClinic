package com.sbota.PetClinic.service;

import com.sbota.PetClinic.model.Visit;
import com.sbota.PetClinic.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("IVisitService")
public class VisitService {
    @Autowired
    private VisitRepository visitRepository;
    public List<Visit> findAll() {
        return visitRepository.findAll();
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
}
