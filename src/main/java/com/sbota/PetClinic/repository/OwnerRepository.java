package com.sbota.PetClinic.repository;

import com.sbota.PetClinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {
}
