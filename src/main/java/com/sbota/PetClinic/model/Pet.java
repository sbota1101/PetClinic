package com.sbota.PetClinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petId;

    private String petName;
    private String breed;
    private String typeOfAnimal;
    private int age;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.LAZY)
    private Set<Visit> visits;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vet vet;

    @ManyToOne(fetch = FetchType.LAZY)
    private Owner owner;
}
