package com.sbota.PetClinic.repository;

import com.sbota.PetClinic.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
