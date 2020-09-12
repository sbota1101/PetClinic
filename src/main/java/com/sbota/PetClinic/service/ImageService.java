package com.sbota.PetClinic.service;

import com.sbota.PetClinic.model.Image;
import com.sbota.PetClinic.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("IImageSerice")
public class ImageService {
    @Autowired
    ImageRepository imageRepository;
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    public void save(Image image) {
        imageRepository.save(image);
    }

}
