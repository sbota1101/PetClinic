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

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date date;


    @Column(name = "description")
    private String description;
//    @ManyToOne
//    @JoinColumn(name = "pet_id")
//    private Pet pet;

//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Visit visitVet;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Visit visitPet;


}


