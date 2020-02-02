package com.goncharoff.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Owner extends Person {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Column(name = "address")
    private String address;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "city")
    private String city;

    @Builder
    public Owner(Long id, String firstName, String lastName, Set<Pet> pets, String address, String telephone, String city) {
        super(id, firstName, lastName);
        this.pets = pets;
        this.address = address;
        this.telephone = telephone;
        this.city = city;
    }
}
