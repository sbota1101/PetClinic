package com.sbota.PetClinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vet extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vetId;
    private String speciality;


    @OneToMany(mappedBy = "vet" , cascade = CascadeType.ALL)
    private List<Pet> petList;
//
//    @OneToMany(mappedBy = "vet" , cascade = CascadeType.ALL)
//    private List<Visit> vetVisitList;
}
