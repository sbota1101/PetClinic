package com.sbota.PetClinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Owner extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerId;
    private String city;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "owner" , cascade = CascadeType.ALL)
    private List<Pet> petList;

}

