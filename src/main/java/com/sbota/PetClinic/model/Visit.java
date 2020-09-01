package com.sbota.PetClinic.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int visitId;


    private Date date;


    @Column(name = "description")
    private String description;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    private Pet pet;

    public List<Pet> pets() {
        return pets();
    }
//    @ManyToMany(mappedBy = "visits")
//    private List<Pet> pets;
}


