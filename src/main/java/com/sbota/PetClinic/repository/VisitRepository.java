package com.sbota.PetClinic.repository;

import com.sbota.PetClinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit,Integer> {
}
