package com.sbota.PetClinic;

import com.sbota.PetClinic.model.Image;
import com.sbota.PetClinic.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class PetClinicApplication {

    @Autowired
    private ImageService imageService;

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApplication.class, args);
    }



    public void run(String... arg0) throws Exception {
        // image 1
        ClassPathResource backImgFile = new ClassPathResource("image/Bunny.png");
        byte[] arrayPic = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(arrayPic);
        Image blackImage = new Image(1, "Bunny", "png", arrayPic);

        // image 2
        ClassPathResource blueImgFile = new ClassPathResource("Foxy.png");
        arrayPic = new byte[(int) blueImgFile.contentLength()];
        blueImgFile.getInputStream().read(arrayPic);
        Image blueImage = new Image(2, "Foxy", "png", arrayPic);

        // store image to MySQL via SpringJPA
        imageService.save(blackImage);
        imageService.save(blueImage);

        // retrieve image from MySQL via SpringJPA
        for (Image imageModel : imageService.findAll()) {
            Files.write(Paths.get("retrieve-dir/" + imageModel.getName() + "." + imageModel.getType()), imageModel.getPic());
        }
    }

}
