package com.sbota.PetClinic.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;



@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int visitId;
    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;


    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visit() {
        this.date = LocalDate.now();
    }



    public LocalDate getDate() {
        return this.date;
    }



    public void setDate(LocalDate date) {
        this.date = date;
    }



    public String getDescription() {
        return this.description;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return this.pet;
    }


    public void setPet(Pet pet) {
        this.pet = pet;
    }

}


