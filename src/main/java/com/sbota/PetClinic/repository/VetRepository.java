package com.sbota.PetClinic.repository;

import com.sbota.PetClinic.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;



public interface VetRepository extends JpaRepository<Vet, Integer> {
}
