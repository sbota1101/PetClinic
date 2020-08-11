package com.sbota.PetClinic.repository;

import com.sbota.PetClinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
