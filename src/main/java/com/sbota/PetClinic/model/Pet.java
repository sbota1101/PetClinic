package com.sbota.PetClinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
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
    private String imagine;


    @ManyToOne(fetch = FetchType.LAZY)
    private Vet vet;

    @ManyToOne(fetch = FetchType.LAZY)
    private Owner owner;
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<Visit> visits;
//    @ManyToMany
//    @JoinTable(name = "pet_visit", joinColumns = @JoinColumn(name = "PetId"),
//            inverseJoinColumns = @JoinColumn(name = "visitId"))
//    private List<Visit> visits;

    @OneToOne(mappedBy = "pet")
    private Image image;

}
